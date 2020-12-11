package com.gtomee.audiospectrum;

import com.artemis.gwtref.client.Test;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.analysis.KissFFT;
import com.badlogic.gdx.audio.io.Mpg123Decoder;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.hydrozoa.pokemon.battle.STAT;

import java.util.ArrayList;
import java.util.HashMap;

public class AudioSpectrum extends Game {
    private Stage stage;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;

    String FILE = "data/two.mp3";
    Mpg123Decoder decoder;
    AudioDevice device;
    boolean playing = false;

    short[] samples = new short[40480];

    KissFFT fft;
    float[] spectrum = new float[40480];
    float[] maxValues = new float[16];
    float[] topValues = new float[16];

    Texture colors;
    OrthographicCamera camera;
    SpriteBatch batch;

    int NB_BARS = 31;
    float barWidth = ((float) WIDTH / (float) NB_BARS);  //每一个格子的宽度
    float FALLING_SPEED = (1.0f / 3.0f);



    ArrayList<String> arrayList = new ArrayList();
    HashMap<String,String> hashMap = new HashMap<>();


    @Override
    public void create() {
        arrayList.add("a2");
        arrayList.add("L");
        arrayList.add("4");
        arrayList.add("a2");
        arrayList.add("L");
        arrayList.add("g2");
        arrayList.add("J");
        arrayList.add("1");
        arrayList.add("f2");
        arrayList.add("J");
        arrayList.add("1");



//        hashMap.put("a2");
//        hashMap.put("L");
//        hashMap.put("4");
//        hashMap.put("a2");
//        hashMap.put("L");
//        hashMap.put("g2");
//        hashMap.put("J");
//        hashMap.put("1");
//        hashMap.put("f2");
//        hashMap.put("J");
//        hashMap.add("1");

        // create the camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH, HEIGHT);
        // load texture
        colors = new Texture(Gdx.files.internal("data/level_3.png"));
        // create the spritebatch
        batch = new SpriteBatch();
        // fast fourier transform    傅里叶变换
        fft = new KissFFT(2048);

        for (int i = 0; i < maxValues.length; i++) {
            maxValues[i] = 0;
            topValues[i] = 0;
        }

        // the audio file has to be on the external storage (not in the assets)
        FileHandle externalFile = Gdx.files.external("tmp/audio-spectrum.mp3");
        Gdx.files.internal(FILE).copyTo(externalFile);

        // create the decoder (you can use a VorbisDecoder if you want to read
        // ogg files)
        decoder = new Mpg123Decoder(externalFile);

        // Create an audio device for playback
        device = Gdx.audio.newAudioDevice(decoder.getRate(),
                decoder.getChannels() == 1 ? true : false);


        // start a thread for playback
        Thread playbackThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (String o : arrayList) {

                }
            }
        });
        playbackThread.setDaemon(true);
        playbackThread.start();
        playing = true;


        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Image image = new Image(new Texture("blue.png"));
        stage.addActor(image);
        image.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                int readSamples = 0;

                // read until we reach the end of the file
                if (playing
                        && (readSamples = decoder.readSamples(samples, 0,
                        samples.length)) > 0) {
                    // get audio spectrum
                    fft.spectrum(samples, spectrum);

                    // write the samples to the AudioDevice
                    device.writeSamples(samples, 0, readSamples);
                }
            }
        });
    }

    @Override
    public void dispose() {
        // synchronize with the thread
        playing = false;
        device.dispose();
        decoder.dispose();
        // delete the temp file
        Gdx.files.external("tmp/audio-spectrum.mp3").delete();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        batch.begin();
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        for (int i = 0; i < NB_BARS; i++) {
            int histoX = 0;
            if (i < NB_BARS / 2) {
                histoX = NB_BARS / 2 - i;
            } else {
                histoX = i - NB_BARS / 2;
            }

            int nb = (samples.length / NB_BARS) / 2;
            if (avg(histoX, nb) > maxValues[histoX]) {
                maxValues[histoX] = avg(histoX, nb);
            }

            System.out.println(histoX+"==");

            if (avg(histoX, nb) > topValues[histoX]) {
                topValues[histoX] = avg(histoX, nb);
            }

            // drawing spectrum (in blue)
            batch.draw(colors, i * barWidth, 0, barWidth,
                    scale(avg(histoX, nb)), 0, 0, 16, 5, false, false);
            // drawing max values (in yellow)
            batch.draw(colors, i * barWidth, scale(topValues[histoX]),
                    barWidth, 4, 0, 5, 16, 5, false, false);
            // drawing top values (in red)
            batch.draw(colors, i * barWidth, scale(maxValues[histoX]),
                    barWidth, 2, 0, 10, 16, 5, false, false);

            topValues[histoX] -= FALLING_SPEED;
        }

        batch.end();

    }

    private float scale(float x) {
        return x / 256 * HEIGHT * 2.0f;
    }

    private float avg(int pos, int nb) {
        int sum = 0;
        for (int i = 0; i < nb; i++) {
            sum += spectrum[pos + i];
        }
        return (float) (sum / nb);
    }
}
		// start a thread for playback
//		Thread playbackThread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				int readSamples = 0;
//
//				// read until we reach the end of the file
//				while (playing
//						&& (readSamples = decoder.readSamples(samples, 0,
//								samples.length)) > 0) {
//					// get audio spectrum
//					fft.spectrum(samples, spectrum);
//
//					// write the samples to the AudioDevice
//					device.writeSamples(samples, 0, readSamples);
//				}
//			}
//		});
package kw.test.memory.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class AssetResource {
    public AssetResource(GameOptions options){
        this.options = options;
        Preferences preferences = Gdx.app.getPreferences("memory_free_hd.prefs");
        if (preferences.contains("soundOn")) {
            options.soundOn = preferences.getBoolean("soundOn");
        }
        font = new BitmapFont(getFileHandle("berlin_64.fnt"), false);
        smallFont = new BitmapFont(getFileHandle("berlin_42.fnt"), false);
        card = new Texture(getFileHandle("card-front.png"));
        cardBack = new Texture(getFileHandle("card-back.png"));
        cardBackMark = new Texture(getFileHandle("card-back-mark.png"));
        check = new Texture(getFileHandle("Check_32x32.png"));
        positive = new Texture(getFileHandle("Positive_256x256.png"));
        grey = new Texture(getFileHandle("grey.png"));
        background = new Texture(getFileHandle("background.jpg"));
        gradientTop = new Texture(getFileHandle("gradient_oben.png"));
        gradientBottom = new Texture(getFileHandle("gradient_unten.png"));
        if (GameOptions.isFreeVersion) {
            logo = new Texture(getFileHandle("Logo.png"));
        } else {
            logo = new Texture(getFileHandle("Logo_donated.png"));
        }

        cardBack.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        cardBackMark.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        logo.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Texture vehiclesTexture = new Texture(getFileHandle("vehicles.png"));
        vehiclesTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        TextureRegion[][] veh = TextureRegion.split(vehiclesTexture, 256, 256);

        icons = new TextureRegion[24];
        icons[0] = new TextureRegion(loadTexture("animals/Butterfly_128x128.png"));
        icons[1] = new TextureRegion(loadTexture("animals/Dolphin_128x128.png"));
        icons[2] = new TextureRegion(loadTexture("animals/Elephant_128x128.png"));
        icons[3] = new TextureRegion(loadTexture("animals/Hippopotamus_128x128.png"));
        icons[4] = new TextureRegion(loadTexture("animals/Panda_128x128.png"));
        icons[5] = new TextureRegion(loadTexture("animals/Turtle_128x128.png"));
        icons[6] = new TextureRegion(loadTexture("vacation/surfboard_256x256.png"));
        icons[7] = new TextureRegion(loadTexture("vacation/umbrella_256x256.png"));

        int count = 0;
        for (int i = 0; i < veh.length; i++) {
            TextureRegion[] textureRegions = veh[i];
            for (int j = 0; j < textureRegions.length; j++) {
                icons[8 + count] = textureRegions[j];
                count++;
            }
        }

        // Particle effects
        fireworks = new ParticleEffect();
        fireworks.load(getFileHandle("fireworks"), getFileHandle(""));

        // sounds
        sndFlipCard = Gdx.audio.newSound(getFileHandle("flipcard.ogg"));
        sndCheer = Gdx.audio.newSound(getFileHandle("drums.ogg"));
        sndDing = Gdx.audio.newSound(getFileHandle("ding.ogg"));
    }

    private String prefix = "assets/";

    public GameOptions options;
    public Texture card, cardBack, cardBackMark;
    public Texture check, positive;
    public BitmapFont font, smallFont;
    public TextureRegion[] icons;
    public Texture grey, background;
    public Texture gradientTop, gradientBottom;
    public Texture logo;
    public ParticleEffect fireworks;
    public Sound sndFlipCard, sndCheer, sndDing;


    /**
     * Little helper method for porting the asset manager to android
     *
     * @param file the file to load
     * @return a file handle
     */
    private FileHandle getFileHandle(String file) {
//        if (Gdx.app.getType() == Application.ApplicationType.Desktop)
//            return Gdx.files.internal(prefix + file); // for desktop use
//        else
        return Gdx.files.internal(file); // for android use
    }

    private Texture loadTexture(String fileHandle) {
        Texture tmp;
        tmp = new Texture(getFileHandle(fileHandle));
        tmp.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        return tmp;
    }

    /**
     * Shuffle card icons to see something new every time.
     */
    public void shuffleIcons() {
        TextureRegion tmp;
        int a, b;
        for (int k = 0; k < 25; k++) {
            a = (int) Math.floor(Math.random()*icons.length);
            b = (int) Math.floor(Math.random()*icons.length);
            if (a!=b) {
                tmp = icons[a];
                icons[a] = icons[b];
                icons[b] = tmp;
            }
        }
    }
}

package kw.test.memory;

import com.artemis.gwtref.client.Test;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import kw.test.memory.asset.AssetResource;
import kw.test.memory.asset.GameOptions;
import kw.test.memory.constant.Contant;
import kw.test.memory.screen.SplashScreen;

public class MemoryGame extends Game {
    @Override
    public void create() {
        Contant.viewport = new ExtendViewport(720,1280);
        resize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        Contant.batch = new CpuSpriteBatch();
        Contant.assetManager = new AssetManager();
        Contant.assetResource = new AssetResource(new GameOptions());
        Contant.game = this;
        setScreen(new SplashScreen());
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        Contant.viewport.update(width,height);
        Contant.wwidth = Contant.viewport.getWorldWidth();
        Contant.wheight = Contant.viewport.getWorldHeight();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.3F,0.3F,0.3F,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
    }
}

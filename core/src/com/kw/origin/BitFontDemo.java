package com.kw.origin;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BitFontDemo extends Game {
    private BitmapFont bitmapFont;
    private Batch batch;
    @Override
    public void create() {
        batch = new SpriteBatch();
        bitmapFont = new BitmapFont(Gdx.files.internal("font100-500.fnt"),
                Gdx.files.internal("font100-500.png"),false);
    }

    @Override
    public void render() {
        super.render();
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        bitmapFont.draw(batch,"fbhhgg",100,100);
        batch.end();
    }
}

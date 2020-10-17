package com.kw.origin;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureDemo extends Game {
    private Batch batch;
    private Texture texture;
    @Override
    public void create() {
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
    }

    float x = 0;
    @Override
    public void render() {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
        batch.begin();
        x ++;
        batch.draw(texture,100+x,100);
        batch.end();
    }
}

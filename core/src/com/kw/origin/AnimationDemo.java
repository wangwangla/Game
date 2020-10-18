package com.kw.origin;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationDemo extends Game {
    private Batch batch;
    private Animation<TextureRegion> animation;
    private Texture texture;
    private TextureRegion currentRegin;
    @Override
    public void create() {
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
        TextureRegion region = new TextureRegion(texture);
        TextureRegion[][] split = region.split(texture.getWidth() / 2, texture.getHeight() / 2);
        TextureRegion [] frames = new TextureRegion[2*2];
        int index = 0;
        for (TextureRegion[] textureRegions : split) {
            for (TextureRegion textureRegion : textureRegions) {
                frames[index++] = textureRegion;
            }
        }
        animation = new Animation(0.02F,frames);
        batch = new SpriteBatch();
    }
    float stateTime = 0;
    @Override
    public void render() {
        super.render();
        stateTime+=Gdx.graphics.getDeltaTime();
        currentRegin = animation.getKeyFrame(stateTime, true);
        batch.begin();
        batch.draw(currentRegin,100,100);
        batch.end();
    }
}

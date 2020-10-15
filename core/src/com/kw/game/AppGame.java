package com.kw.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.kw.game.screen.SplashScreen;

public class AppGame extends Game {
	private static Viewport viewPort;
	private static Batch batch;

	@Override
	public void create () {
        viewPort = new ExtendViewport(720,1280);
        setScreen(new SplashScreen());
	}

	@Override
	public void render () {
		super.render();
	}

	public static Batch getBatch(){
	    if (batch == null){
            batch = new CpuSpriteBatch();
        }
	    return batch;
    }

    public static Viewport getViewPort() {
        return viewPort;
    }
}

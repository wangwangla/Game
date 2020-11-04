package com.kw.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.kw.game.constant.GameConsatant;
import com.kw.game.screen.SplashScreen;

public class AppGame extends Game {
	private static Viewport viewPort;
	private static Batch batch;
	private static World world;
	private static Box2DDebugRenderer renderer;

	@Override
	public void create () {
        GameConsatant.viewPort = viewPort = new ExtendViewport(720,1280);
		GameConsatant.batch = batch = new SpriteBatch();
		GameConsatant.world = world = new World(new Vector2(0,0),true);
		renderer = new Box2DDebugRenderer();
		setScreen(new SplashScreen());
	}

	@Override
	public void render () {
		super.render();
		world.step(1/60f, 6, 2);
		renderer.render(world,viewPort.getCamera().combined);
	}

    public static Viewport getViewPort() {
        return viewPort;
    }
}

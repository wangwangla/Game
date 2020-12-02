package com.pacman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pacman.constant.Constant;
import com.pacman.screen.GameScreen;
import com.pacman.screen.LoadingScreen;

import box2dLight.RayHandler;

public class PacManGame extends Game {
    public CpuSpriteBatch batch;
    public Viewport viewport;
    public OrthographicCamera camera;
    @Override
    public void create() {
        Constant.batch = batch = new CpuSpriteBatch();
        Constant.orthographicCamera = camera = new OrthographicCamera();
        Constant.viewport = viewport = new FitViewport(Constant.WIDTH,Constant.HEIGHT, camera);
        Constant.game = this;
        camera.translate(Constant.WIDTH / 2, Constant.HEIGHT / 2);
        camera.update();
        setScreen(new LoadingScreen());
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height);
    }
}

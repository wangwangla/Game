package com.pacman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pacman.constant.Constant;
import com.pacman.screen.LoadingScreen;

import box2dLight.RayHandler;

public class PacManGame extends Game {
    private OrthographicCamera camera;
    private RayHandler rayHandler;
    @Override
    public void create() {
        Constant.orthographicCamera = camera = new OrthographicCamera();
        Constant.viewport = new FitViewport(Constant.WIDTH, Constant.HEIGHT, camera);
        camera.translate(Constant.WIDTH / 2, Constant.HEIGHT / 2);
        camera.update();
        Constant.batch = new CpuSpriteBatch();
        Constant.rayHandler = rayHandler = new RayHandler(Constant.world);
        Constant.game = this;
        Constant.world = new World(new Vector2(0,0),false);
        Constant.batch.setProjectionMatrix(camera.combined);
        Constant.box2DDebugRenderer = new Box2DDebugRenderer();
        setScreen(new LoadingScreen());
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0F, 0F, 0F, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT |
                (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));
        super.render();
    }
}

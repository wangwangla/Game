package com.pacman.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.pacman.PacManGame;
import com.pacman.constant.Constant;
import com.pacman.screen.base.BaseScreen;
import com.pacman.view.GameView;
import com.pacman.view.controller.GameController;

import box2dLight.RayHandler;

public class GameScreen extends BaseScreen {
    private SpriteBatch batch;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    public GameScreen() {
        batch = Constant.batch;
    }

    @Override
    public void show() {
        tiledMap = new TmxMapLoader().load("map/map.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1 / 16f, batch);
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        tiledMapRenderer.setView(Constant.orthographicCamera);
        tiledMapRenderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }


    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        tiledMap.dispose();
        tiledMapRenderer.dispose();
    }
}

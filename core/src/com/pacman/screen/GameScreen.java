package com.pacman.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
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
import com.pacman.view.util.MapUtils;
import com.pacman.view.util.Tools;

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

        float worldWidth = Constant.viewport.getWorldWidth();
        float worldHeight = Constant.viewport.getWorldHeight();
        float scale = Math.min(worldWidth/19,worldHeight/23);

        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap,scale/16, batch);


        MapLayers layers = tiledMap.getLayers();
        MapUtils utils = new MapUtils();
        for (MapLayer layer : layers) {
            utils.buildStaticObject(layer);
        }
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

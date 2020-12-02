package com.pacman.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.pacman.constant.Constant;
import com.pacman.view.util.MapUtils;

public class GameView extends Group {
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private OrthographicCamera camera;
    public GameView(){
        //绘制地图
        Constant.viewport.setWorldSize(19,23);
        tiledMap = new TmxMapLoader().load("map/map.tmx");
//        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1/16, Constant.batch);
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 0.001F, new SpriteBatch());
        MapLayers layers = tiledMap.getLayers();
        MapUtils utils = new MapUtils();
        camera = Constant.orthographicCamera;
        camera.translate(Constant.WIDTH/2,Constant.HEIGHT/2);
        camera.update();
        for (MapLayer layer : layers) {
            utils.buildStaticObject(layer);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
//        super.draw(batch, parentAlpha);
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

    }
}

package com.learn2.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.learn2.constant.Constant;
import com.learn2.view.GameView;

public class GameScreen implements Screen {
    private Stage stage;
    private GameView gameView;
    @Override
    public void show() {
        stage = new Stage();
        gameView = new GameView();
        stage.addActor(gameView);
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Constant.engine.update(delta);
        stage.getCamera().position.set(new Vector2(gameView.getBody().getPosition().x,gameView.getBody().getPosition().y),0);
        stage.act(delta);
        stage.draw();
        Constant.world.step(1/60.0F,1,1);
        Constant.renderer.render(Constant.world,stage.getCamera().combined);
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

    }

    @Override
    public void dispose() {

    }
}

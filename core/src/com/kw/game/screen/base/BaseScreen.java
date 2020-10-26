package com.kw.game.screen.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kw.game.AppGame;

public class BaseScreen implements Screen {
    protected Stage stage;
    protected Group rootView;

    @Override
    public void show() {
        stage = new Stage(AppGame.getViewPort(),AppGame.getBatch());
        Gdx.input.setInputProcessor(stage);
        if (rootView!=null){
            stage.addActor(rootView);
        }
    }

    @Override
    public void render(float delta) {
        if (stage!=null){
            stage.act();
            stage.draw();
        }
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

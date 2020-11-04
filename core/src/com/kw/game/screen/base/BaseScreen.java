package com.kw.game.screen.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kw.game.AppGame;
import com.kw.game.constant.GameConsatant;

public class BaseScreen implements Screen {
    private Stage stage;
    protected Group rootView;

    @Override
    public void show() {
        stage = new Stage(AppGame.getViewPort(), GameConsatant.batch);
        if (rootView!=null){
            stage.addActor(rootView);
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2F,0.2F,0.2F,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);
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

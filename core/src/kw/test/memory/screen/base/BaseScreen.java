package kw.test.memory.screen.base;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.lang.reflect.InvocationTargetException;

import kw.test.memory.MemoryGame;
import kw.test.memory.constant.Contant;

public class BaseScreen implements Screen {
    protected Stage stage;
    protected MemoryGame game;
    private InputMultiplexer inputMultiplexer;
    protected enum gameStatus{
        enter,exit,passlevel
    }
    protected gameStatus status;

    @Override
    public void show() {
        status = gameStatus.enter;
        stage = new Stage(Contant.viewport,Contant.batch);
        game = Contant.game;
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(inputMultiplexer);
        initData();
        initView();
        initListener();
    }

    protected void initListener() {
    }

    protected void initData() {

    }

    protected void initView() {

    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
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

    protected void enterScreen(BaseScreen screen){
        status = gameStatus.exit;
        game.setScreen(screen);
    }

    protected void enterScreen(Class t){
        status = gameStatus.exit;
        try {
            game.setScreen((Screen) t.getConstructors()[0].newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

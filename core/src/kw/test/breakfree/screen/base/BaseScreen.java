package kw.test.breakfree.screen.base;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;

import kw.test.breakfree.constant.Constant;

public class BaseScreen implements Screen {
    private Stage stage ;
    @Override
    public void show() {
        stage = new Stage(Constant.viewport,Constant.batch);
        initData();
        initView();
        initListener();
    }

    protected void initData() {

    }

    protected void initView() {

    }

    protected void initListener() {

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
}

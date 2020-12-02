package com.pacman.screen.base;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pacman.PacManGame;
import com.pacman.constant.Constant;
import com.pacman.screen.GameScreen;

public class BaseScreen extends ScreenAdapter {
    protected Stage stage;
    @Override
    public void show() {
        stage = new Stage(Constant.viewport,Constant.batch);
        enterScreen();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act();
        stage.draw();
    }

    public void enterScreen(){

    }

    public void exitScreen(Class<? extends Screen> screen){
        try {
            Constant.game.setScreen(screen.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

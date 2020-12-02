package com.pacman.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.pacman.constant.Constant;
import com.pacman.screen.base.BaseScreen;

/**
// *
 */
public class LoadingScreen extends BaseScreen {
    @Override
    public void show() {
        super.show();
        Image image = new Image(new Texture("images/loading.png"));
        image.setPosition(Constant.width/2,Constant.height/2, Align.center);
        stage.addActor(image);
        stage.addAction(Actions.delay(0,Actions.run(()->{
            exitScreen(GameScreen.class);
        })));
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
}

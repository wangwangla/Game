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
 * 主页定时3秒之后挑转，目前只放一张图片
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
}

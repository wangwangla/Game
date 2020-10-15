package com.kw.game.screen;


import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kw.game.AppGame;
import com.kw.game.screen.base.BaseScreen;
import com.kw.game.view.SplashView;
import com.kw.game.view.base.BaseView;

public class SplashScreen extends BaseScreen {
    public SplashScreen(){
        rootView = new SplashView();
    }
    @Override
    public void show() {
        super.show();
    }
}

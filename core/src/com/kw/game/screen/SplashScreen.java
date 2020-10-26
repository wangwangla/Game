package com.kw.game.screen;

import com.badlogic.gdx.Gdx;
import com.kw.game.model.SplashData;
import com.kw.game.screen.base.BaseScreen;
import com.kw.game.view.SplashView;

public class SplashScreen extends BaseScreen {
    public SplashScreen(){

    }

    @Override
    public void show() {
        super.show();
        SplashData data = new SplashData();
        rootView = new SplashView(data);
        stage.addActor(rootView);
    }
}

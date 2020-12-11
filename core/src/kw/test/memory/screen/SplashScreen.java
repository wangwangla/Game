package kw.test.memory.screen;

import kw.test.memory.screen.base.BaseScreen;
import kw.test.memory.screen.view.SplashView;

public class SplashScreen extends BaseScreen {
    private float time;
    private boolean out;

    @Override
    public void show() {
        super.show();
        SplashView view = new SplashView();
        stage.addActor(view);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        time+=delta;
        if (out) return;
        if (time>1){
            out = true;
            enterScreen(MainScreen.class);
        }
    }
}

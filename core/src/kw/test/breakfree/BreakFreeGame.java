package kw.test.breakfree;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import kw.test.breakfree.constant.Constant;
import kw.test.breakfree.screen.LoadScreen;


public class BreakFreeGame extends Game {
    private Viewport viewport;
    @Override
    public void create() {
        Constant.viewport = viewport = new ExtendViewport(Constant.stu_width,Constant.stu_height);
        Constant.batch = new SpriteBatch();
        resize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        setScreen(new LoadScreen());
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width,height);
        Constant.wwidth = viewport.getWorldWidth();
        Constant.wheight = viewport.getWorldHeight();
    }
}

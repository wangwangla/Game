package com.kw.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.kw.game.screen.SplashScreen;

public class AppGame extends Game {
	private static Viewport viewPort;
	private static Batch batch;

	@Override
	public void create () {
	    //加载资源： cvs   json


        viewPort = new ExtendViewport(720,1280);
        setScreen(new SplashScreen());
	}

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        //重新设置宽高,需要设置相机的位置，不然相机会一直照着开始的地方。
        viewPort.update(width,height,true);
        /**
         * 不加会出现什么问题？
         *  我不断的拉伸宽度，物体的位置是不发生改变的
         */
        if(viewPort instanceof ExtendViewport) {
            float viewportWidth = viewPort.getWorldWidth();
            if (viewportWidth > 720) {
                viewPort.setWorldSize(720, 720 / viewportWidth * 1280);
                viewPort.apply(true);
            }
        }
    }

    @Override
	public void render () {
		super.render();
	}

	public static Batch getBatch(){
	    if (batch == null){
            batch = new CpuSpriteBatch();
        }
	    return batch;
    }

    public static Viewport getViewPort() {
        return viewPort;
    }
}

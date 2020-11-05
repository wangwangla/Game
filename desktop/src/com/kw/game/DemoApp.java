package com.kw.game;

import com.Box2DDemo;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kw.origin.AnimationDemo;
import com.kw.origin.BitFontDemo;
import com.kw.origin.TextureDemo;
import com.ychstudio.PacMan;

public class DemoApp{
    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 360;
        config.height = 640;
        new LwjglApplication(new Box2DDemo(), config);
    }
}

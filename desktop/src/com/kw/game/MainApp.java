package com.kw.game;

import com.Box2DDemo;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.learn.App;
import com.ychstudio.PacMan;

public class MainApp {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 360;
		config.height = 640;
		new LwjglApplication(new Box2DDemo(), config);
//        new LwjglApplication(new App(), config);
    }
}

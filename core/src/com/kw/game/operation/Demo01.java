package com.kw.game.operation;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.utils.Array;

public class Demo01 {

    public <T extends Screen & Loadable> Demo01(T screen) {
        this(screen.getDependencies(), screen);
    }

    public Demo01(Array<AssetDescriptor> assets, Screen screen) {

    }

    public interface Loadable{
        Array<AssetDescriptor> getDependencies();
    }
}

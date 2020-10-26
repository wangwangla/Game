//package com.kw.game.operation;
//
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.assets.AssetDescriptor;
//import com.badlogic.gdx.utils.Array;
//
//public class Demo02 {
//
//    private static Object AssetDescriptor;
//
//    public <T extends Screen & Loadable> Demo02(T screen) {
//        this(screen);
//    }
//
//    public Demo02(Screen screen) {
//
//    }
//
//
//
//    public interface Loadable{
//        Array<AssetDescriptor> getDependencies();
//    }
//
//    public static void main(String[] args) {
//        new Demo02(new ScreenDemo(new Array<AssetDescriptor>()));
//    }
//}

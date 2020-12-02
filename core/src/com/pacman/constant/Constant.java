package com.pacman.constant;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import box2dLight.RayHandler;

public class Constant {
    /****************constant***************/
    public static float width = 720;
    public static float height = 1280;
    public static final float PPM =16F;
    public static final float WIDTH = 19.0f;
    public static final float HEIGHT = 23.0f;



    /*****************refence*************************/
    public static Viewport viewport ;
    public static CpuSpriteBatch batch;
    public static Game game;
    public static World world;
    public static OrthographicCamera orthographicCamera;
    public static RayHandler rayHandler;
    public static Box2DDebugRenderer box2DDebugRenderer;
}

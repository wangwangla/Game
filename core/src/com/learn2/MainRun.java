package com.learn2;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.learn2.constant.Constant;
import com.learn2.screen.GameScreen;

public class MainRun extends Game {
    private World world;
    private Engine engine;

    private Box2DDebugRenderer renderer;
    @Override
    public void create() {
        Constant.world = world = new World(new Vector2(0,0),true);
        Constant.renderer = renderer = new Box2DDebugRenderer();
        Constant.engine = engine = new Engine();
        setScreen(new GameScreen());
    }

    public static void main(String[] args) {
//        Engine engine = new Engine();
//        PlaySystem system = new PlaySystem();
//        engine.addSystem(system);
//        PlayComponect helloConponent = new PlayComponect();
//        helloConponent.message = "xxxxxxxx";
//        Entity entity = new Entity();
//        entity.add(helloConponent);
//        engine.addEntity(entity);
//        engine.update(0.16F);

    }

}

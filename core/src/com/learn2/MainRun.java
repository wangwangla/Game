package com.learn2;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.World;
import com.learn2.component.HelloConponent;
import com.learn2.system.HelloSystem;

public class MainRun {
    public static void main(String[] args) {
        Engine engine = new Engine();
        HelloSystem system = new HelloSystem();
        engine.addSystem(system);
        HelloConponent helloConponent = new HelloConponent();
        helloConponent.message = "xxxxxxxx";
        Entity entity = new Entity();
        entity.add(helloConponent);
        engine.addEntity(entity);
        engine.update(0.16F);
    }
}

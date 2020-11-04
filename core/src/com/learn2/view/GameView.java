package com.learn2.view;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.learn2.box.BoxActor;
import com.learn2.component.MoveComponent;
import com.learn2.component.PlayComponect;
import com.learn2.constant.Constant;
import com.learn2.manager.GameBuilder;
import com.learn2.system.PlaySystem;

public class GameView extends Group {
    public GameView(){
//        Image image = new Image(new Texture(Gdx.files.internal("badlogic.jpg")));
//        addActor(image);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(500,10);
        BoxActor bottom = new BoxActor(shape,new Vector2(0,0));
        addActor(bottom);

        PolygonShape shapeBox = new PolygonShape();
        shapeBox.setAsBox(10,10);
        BoxActor box = new BoxActor(shapeBox,new Vector2(10,20));
        addActor(box);
        Body body = box.getBody();

        Engine engine = Constant.engine;
        PlaySystem playSystem = new PlaySystem();
        engine.addSystem(playSystem);
        Entity playEntity = new Entity();
        PlayComponect playComponect = new PlayComponect(body);
        MoveComponent component = new MoveComponent(body);
        playEntity.add(playComponect);
        playEntity.add(component);
        engine.addEntity(playEntity);
    }
}

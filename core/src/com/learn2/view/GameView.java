package com.learn2.view;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.GdxAI;
import com.badlogic.gdx.ai.steer.behaviors.Arrive;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.learn2.box.BoxActor;
import com.learn2.box.SteeringActor;
import com.learn2.component.MoveComponent;
import com.learn2.component.PlayComponect;
import com.learn2.constant.Constant;
import com.learn2.system.PlaySystem;

public class GameView extends Group {
    private Body body;
    public GameView(){
        setSize(200,200);
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
        body = box.getBody();

        Engine engine = Constant.engine;
        PlaySystem playSystem = new PlaySystem();
        engine.addSystem(playSystem);
        Entity playEntity = new Entity();
        PlayComponect playComponect = new PlayComponect(body);
        MoveComponent component = new MoveComponent(body);
        playEntity.add(playComponect);
        playEntity.add(component);
        engine.addEntity(playEntity);

//        Image image1 = new Image(new Texture(Gdx.files.internal("map/bg.png")));
//        image1.setPosition(100,100);
//        Image image2 = new Image(new Texture(Gdx.files.internal("map/tiles.png")));
//        addActor(image1);
//        addActor(image2);


        SteeringActor character = new SteeringActor(new TextureRegion(
                new Texture(Gdx.files.internal("map/bg.png"))));
        SteeringActor target = new SteeringActor(new TextureRegion(new Texture(Gdx.files.internal("map/tiles.png"))));
        target.setPosition(100,100);
        character.setMaxLinearSpeed(100);
        character.setMaxLinearAcceleration(300);
        final Arrive<Vector2> arriveSB = new Arrive<Vector2>(character, target) //
                .setTimeToTarget(0.1f) //
                .setArrivalTolerance(0.001f) //
                .setDecelerationRadius(80);
        character.setSteeringBehavior(arriveSB);
        addActor(character);
        addActor(target);
    }

    public Body getBody() {
        return body;
    }


    @Override
    public void act(float delta) {
        GdxAI.getTimepiece().getTime();
        super.act(delta);
    }
}

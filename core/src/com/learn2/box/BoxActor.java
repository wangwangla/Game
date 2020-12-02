package com.learn2.box;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.learn2.constant.Constant;

public class BoxActor extends Actor {
    private Body body;
    public BoxActor(Shape shape, Vector2 position){
        World world = Constant.world;
        BodyDef def = new BodyDef();
        def.position.set(position.x,position.y);
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);
        FixtureDef bodyFix = new FixtureDef();
        bodyFix.shape = shape;
        body.createFixture(bodyFix);
        shape.dispose();
    }

    public Body getBody() {
        return body;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

package com.pacman.view.util;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.pacman.constant.Constant;

public class MapUtils {
    private World world;
    public void buildStaticObject(MapLayer layer){
        world = Constant.world;
        for (MapObject object : layer.getObjects()) {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
            Tools.correctRectangle(rectangle);
            BodyDef bodyDef = new BodyDef();
            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set(rectangle.x + rectangle.width / 2, rectangle.y + rectangle.height / 2);
            Body body = world.createBody(bodyDef);
            PolygonShape polygonShape = new PolygonShape();
            polygonShape.setAsBox(rectangle.width / 2, rectangle.height / 2);
            FixtureDef fixtureDef = new FixtureDef();
            fixtureDef.shape = polygonShape;
//            fixtureDef.filter.categoryBits = GameManager.WALL_BIT;
//            fixtureDef.filter.maskBits = GameManager.PLAYER_BIT | GameManager.GHOST_BIT | GameManager.LIGHT_BIT;
            body.createFixture(fixtureDef);
            polygonShape.dispose();
        }
    }

    public void buildStaticObjectTest(){
        world = Constant.world;
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(100 + 19 / 2, 100 + 19 / 2);
        Body body = world.createBody(bodyDef);
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(19/2,19 / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polygonShape;
//            fixtureDef.filter.categoryBits = GameManager.WALL_BIT;
//            fixtureDef.filter.maskBits = GameManager.PLAYER_BIT | GameManager.GHOST_BIT | GameManager.LIGHT_BIT;
        body.createFixture(fixtureDef);
        polygonShape.dispose();
    }
}

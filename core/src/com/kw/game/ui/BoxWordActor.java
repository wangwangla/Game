package com.kw.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.game.constant.GameConsatant;

public class BoxWordActor extends Image {
    Body imageBody;
    public BoxWordActor(String name){
        super(new Texture(Gdx.files.internal(name)));
        setDebug(true);
        World world = GameConsatant.world;
        //定义刚体的属性
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.StaticBody;
        def.position.set(new Vector2(500.0F,500));
//        def.position.set(new Vector2(100.0F/GameConsatant.PMM,100.0F/GameConsatant.PMM));
        //创建刚体
        imageBody = world.createBody(def);
//        刚体的形状
        PolygonShape circleShape = new PolygonShape();
        circleShape.setAsBox(getWidth()/2,getHeight()/2);
        circleShape.setRadius(10F);

        Vector2[] vector2s = new Vector2[3];
        vector2s[0]=new Vector2(1,1);
        vector2s[0]=new Vector2(1,0);
        vector2s[0]=new Vector2(0,1);

        circleShape.set(vector2s);
//      刚体的一些参数
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        //密度
        fixtureDef.density = 10;
        fixtureDef.friction = 10; //摩擦
        fixtureDef.restitution = 1;
        imageBody.createFixture(fixtureDef);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(imageBody.getPosition().x, imageBody.getPosition().y, Align.center);
        super.draw(batch, parentAlpha);
    }
}

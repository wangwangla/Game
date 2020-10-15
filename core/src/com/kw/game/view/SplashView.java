package com.kw.game.view;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.kw.game.view.base.BaseView;

public class SplashView extends BaseView {
    private World world;
    private Box2DDebugRenderer renderer;
    public SplashView(){
        setSize(720,1280);
//        WordActor actor = new WordActor();
//        actor.setPosition(900,100);
//        addActor(actor);
        //        world = new World(new Vector2(0,-9.8F),true);
//        renderer = new Box2DDebugRenderer();
//
//        BodyDef def = new BodyDef();
//        def.position.set(160,400);
//        def.type = BodyDef.BodyType.StaticBody;
//        Body body = world.createBody(def);
//        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(1500,5);
//        FixtureDef def1 = new FixtureDef();
//        def1.shape = shape;
//        body.createFixture(def1);
//        def.position.set(660,800);
//        def.type = BodyDef.BodyType.DynamicBody;
//        body = world.createBody(def);
//        shape.setAsBox(50,50);
//        def1.shape = shape;
//        def1.restitution = 0.5f;  //弹起多少
//        def1.friction = 1.5F;
//        body.createFixture(def1);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
//        world.step(Gdx.app.getGraphics().getDeltaTime(), 3, 3);
//        renderer.render(world,AppGame.getCra().combined);
    }
}

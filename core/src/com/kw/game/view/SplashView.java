package com.kw.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.kw.game.ui.BoxWordActor;
import com.kw.game.view.base.BaseView;

public class SplashView extends BaseView {
    public SplashView(){
/********************box2D******************************/
        BoxWordActor b = new BoxWordActor("badlogic.jpg");
        b.setPosition(1000,10);
        addActor(b);

        Image image = new Image(new Texture(Gdx.files.internal("font100-500.png")));
        image.setPosition(1500,500,Align.center);
        image.getColor().a = 0.4F;
        addActor(image);




//        BodyDef def1 = new BodyDef();
//        def1.type = BodyDef.BodyType.DynamicBody;
//        def1.position.set(new Vector2(200,200));
//
//        imageBody = world.createBody(def1);
//        PolygonShape polygonShape = new PolygonShape();
//        polygonShape.setAsBox(300, 10.0f);
//
//        FixtureDef fixtureDef1 = new FixtureDef();
//        fixtureDef1.shape = polygonShape;
//
//        imageBody.createFixture(fixtureDef1);
//
////        body.setAngularVelocity(10);
//        imageBody.setLinearVelocity(100,100);


/********************box2D******************************/


/********************texture******************************/
//        Texture imageTexture = new Texture(Gdx.files.internal("badlogic.jpg"));
//        Image image = new Image(imageTexture);
//        addActor(image);
//        image.setPosition(400,400);
//        image.setOrigin(Align.center);
//        image.setOrigin(image.getWidth()/2,image.getHeight()/2);
//        image.setRotation(100);
//        image.setColor(Color.CLEAR);
//        image.setColor(Color.valueOf("333333"));
//        //层级
//        image.toFront(); //最前方
//        image.toBack();  // 最后方

/*******************************************************/
//              TextureRegion
/*******************************************************/
//
//        TextureRegion region = new TextureRegion();
//        region.setTexture(new Texture(Gdx.files.internal("badlogic.jpg")));
//        region.setRegion(0,0,421,601);
//        Image image = new Image(region);
//        image.setPosition(getWidth()/2,getHeight()/2,Align.center);
//        addActor(image);
//

/*******************************************************/
//              Sprite
/*******************************************************/
//        Sprite sprite = new Sprite();
//        addActor(sprite);



/*******************************************************/
//               bitfont  游戏中不会直接的使用，他会和
//           label一起使用。
/*******************************************************/
//        BitmapFont bitmapFont ;
//        addActor(bitmapFont);

/*******************************************************/
//                 label一起使用
/*******************************************************/
//        Label.LabelStyle style = new Label.LabelStyle(
//                new BitmapFont(Gdx.files.internal("font100-500.fnt"),
//                        Gdx.files.internal("font100-500.png"),false));
//        Label label = new Label("xxxxxxxxxx",style);
//        addActor(label);
//

/*******************************************************/
//                 image的使用
/*******************************************************/
//        Image image = new Image(new Texture(Gdx.files.internal("badlogic.jpg")));
//        addActor(image);
//        image.setPosition(100,100);
//

/*******************************************************/
//                 ImageButton的使用
/*******************************************************/


//        Texture upTexture = new Texture(Gdx.files.internal(""));
//        Drawable upDrawable = new TextureRegionDrawable(upTexture);
//        Texture downTexture = new Texture(Gdx.files.internal(""));
//        Drawable downDrawable = new TextureRegionDrawable(downTexture);
//        ImageButton textureButton = new ImageButton(upDrawable,downDrawable);
//        addActor(textureButton);
//
//        Texture texture = new Texture(Gdx.files.internal(""));
//        TextureRegion[][] split = TextureRegion.split(texture, 120, 120);
//        TextureRegion up = split[0][0];
//        TextureRegion down = split[0][1];
//        TextureRegionDrawable upTextureRegionDrawable = new TextureRegionDrawable(up);
//        TextureRegionDrawable downTextureRegionDrawable = new TextureRegionDrawable(down);
//        ImageButton imageButton = new ImageButton(upTextureRegionDrawable,downTextureRegionDrawable);
//        addActor(imageButton);

    }
}

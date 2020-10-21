package com.kw.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.game.model.SplashData;
import com.kw.game.view.base.BaseView;

public class SplashView extends BaseView {
    public SplashView(SplashData data){
        Image image1 = new Image(new Texture(Gdx.files.internal("white.png")));
        addActor(image1);
        image1.setSize(100,100);
        image1.setPosition(200,700);

        Image image = new Image(new Texture(Gdx.files.internal("white.png")));
        addActor(image);
        image.setSize(100,100);
        image.setPosition(400,400);

        Image image2 = new Image(new Texture(Gdx.files.internal("white.png")));
        addActor(image2);
        image2.setSize(100,100);
        image2.setPosition(800,400);

        System.out.println("===============>");
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

    }
}

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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.kw.game.common.LabelScroll;
import com.kw.game.common.textures.Textures;
import com.kw.game.model.SplashData;
import com.kw.game.view.base.BaseView;

public class SplashView extends BaseView {
    public SplashView(SplashData data){
//        Image image1 = new Image(new Texture(Gdx.files.internal("white.png")));
//        image1.setColor(Color.BLUE);
//        addActor(image1);
//        image1.setSize(100,100);
//        image1.setPosition(200,700);
//        image1.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                super.clicked(event, x, y);
//                Actor listenerActor = event.getListenerActor();
//                System.out.println(listenerActor);
//            }
//        });
//        System.out.println("======>");
//        Textures textures = new Textures();
//        Texture modal = textures.modal;
//        Image image = new Image(new Texture(Gdx.files.internal("white.png")));
//        Image image = new Image(modal);
//
//        image.setPosition(100,100);
//        image.setSize(100,100);
//        image.setColor(Color.BLUE);
//        addActor(image);


//        Image image2 = new Image(new Texture(Gdx.files.internal("white.png")));
//        Image image3 = new Image(new Texture(Gdx.files.internal("white.png")));
//        Image image4 = new Image(new Texture(Gdx.files.internal("white.png")));
//        Image image5 = new Image(new Texture(Gdx.files.internal("white.png")));
//        Image image6 = new Image(new Texture(Gdx.files.internal("white.png")));
//
//
//        final Table panel = new Table() {{
//            final float SPACING = 98;
//            add(image1).width(100).height(700).space(SPACING).row();
//            add(new Table() {{
//                add(image2).align(Align.left).row();
//                add(image3).row();
//                align(Align.left);
//            }}).space(SPACING).row();
//            add(new Table() {{
//                add(image4).align(Align.left).row();
//                add(image5).row();
//            }}).space(SPACING).row();
//        }};
//        panel.setPosition(100,100);
//        addActor(panel);


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

        LabelScroll scroll = new LabelScroll();
        scroll.setAnimal();
        scroll.setCoinNum(1000);
        scroll.setPosition(100,200);
        addActor(scroll);

    }
}

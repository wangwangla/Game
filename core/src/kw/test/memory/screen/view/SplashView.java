package kw.test.memory.screen.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

import kw.test.memory.constant.Contant;

public class SplashView extends Group {
    public SplashView(){
        Image image = new Image(new Texture("Logo.png"));
        addActor(image);
        image.setPosition(Contant.wwidth/2,Contant.wheight/2, Align.center);


        Label label = new Label("Hi,i am xiao wangwang：\n" +
                "i don't know how to start！！ ,emmm…… flow me !",new Label.LabelStyle(){{font = Contant.assetResource.font;}});
        addActor(label);
    }
}

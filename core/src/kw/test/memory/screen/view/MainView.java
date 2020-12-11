package kw.test.memory.screen.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import kw.test.memory.asset.AssetResource;
import kw.test.memory.constant.Contant;
import kw.test.memory.screen.data.MainData;

public class MainView extends Group {
    public MainView(MainData data){
        AssetResource resource = Contant.assetResource;
        BitmapFont fontStyle = resource.font;
        Table table = new Table(){{
            int [] arr = data.getArr();
            for (int i = 0; i < arr.length; i++) {
                Label label = new Label("> Cards num"+arr[i],new Label.LabelStyle(){{font = fontStyle;}});
                label.setName("table_"+i);
                add(label);
                row();
            }
        }};
        addActor(table);
        table.setPosition(Contant.wwidth*0.4F,Contant.wheight*0.6F);
        Image image = new Image(new Texture("Logo.png"));
        image.setPosition(Contant.wwidth/2,Contant.wheight*0.2F, Align.bottom);
        addActor(image);
    }
}

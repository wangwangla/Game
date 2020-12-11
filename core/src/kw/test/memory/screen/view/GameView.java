package kw.test.memory.screen.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.physics.box2d.joints.GearJoint;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

import java.util.ArrayList;

import kw.test.breakfree.constant.Constant;
import kw.test.memory.card.Card;
import kw.test.memory.constant.Contant;
import kw.test.memory.data.GameData;

public class GameView extends Group {
    private GameData data;
    public GameView(GameData data){
        setSize(Constant.wwidth,Constant.wheight);
        this.data = data;
        int[] hashMap = data.getHashMap(data.getNum());
        ArrayList<Integer> icon = data.getIcon(data.getNum());
        Group temp = new Group();
        Table table = new Table(){{
            int index = 0;
            for (int i = 1; i <= hashMap[0]; i++) {
                for (int j = 1; j <= hashMap[1]; j++) {
                    Card card = new Card("" + icon.remove(0));
                    card.setName("card_"+index);
                    index++;
                    add(card);
                }
                row();
            }
            pack();
        }};
        temp.addActor(table);
        temp.setSize(table.getWidth(),table.getHeight());
        temp.setOrigin(Align.center);
        addActor(temp);
        checkWidth(temp);
        temp.setPosition(getWidth()/2,getHeight()/2,Align.center);

        Label label = new Label("Current step:"+data.getNum(),new Label.LabelStyle(){{font = Contant.assetResource.font;}});
        addActor(label);
        label.setName("step");
    }

    private void checkWidth(Group table) {
        Group tempTemp = table;
        float wwidth = Constant.wwidth;
        float v = wwidth / tempTemp.getWidth();
        if (v<1){
            table.setScale(v);
        }
    }

    public void showPassPanel(){
        Image layer = new Image(new Texture("whitex.png"));
        addActor(layer);
        layer.setName("layer");
        layer.setSize(Contant.wwidth,Contant.wheight);
        Label label = new Label("Game over",new Label.LabelStyle(){{
            font = Contant.assetResource.font;
        }});
        label.setPosition(Contant.wwidth/2,Contant.wheight/2,Align.center);
        addActor(label);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        Actor step = findActor("step");
        if (step!=null) {
            ((Label)step).setText(data.getStep());
        }
    }
}

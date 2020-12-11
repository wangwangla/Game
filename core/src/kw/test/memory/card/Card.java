package kw.test.memory.card;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import kw.test.memory.constant.Contant;

public class Card extends Group {
    public Image fanImage;
    public Image zhengImage;
    public Label label;
    public String tag;
    public Card(String name){
        tag = name;
        fanImage = new Image(new Texture("card-back.png"));
        zhengImage = new Image(new Texture("card-front.png"));
        addActor(fanImage);
        addActor(zhengImage);
        zhengImage.setVisible(false);
        setSize(fanImage.getWidth(),fanImage.getHeight());
        label = new Label(name,new Label.LabelStyle(){{font = Contant.assetResource.font;}});
        addActor(label);
        label.setPosition(getWidth()/2,getHeight()/2, Align.center);
        fan();
    }

    public void setListener(Listener listener){
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                listener.click(Card.this);
            }
        });
    }

    public void fan(){
        fanImage.setVisible(true);
        zhengImage.setVisible(false);
        label.setVisible(false);
        setTouchable(Touchable.enabled);
    }

    public void zheng(){
        fanImage.setVisible(false);
        zhengImage.setVisible(true);
        label.setVisible(true);
        setTouchable(Touchable.disabled);
    }

    public void zhengTimeAfterFan(){
        addAction(Actions.delay(2,Actions.run(()->{
            fan();
        })));
    }

    public void find(){
        zheng();
    }

    public interface Listener{
        void click(Card card);
    }

    public String getTag() {
        return tag;
    }
}

package kw.test.memory.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import kw.test.memory.asset.AssetResource;
import kw.test.memory.constant.Contant;
import kw.test.memory.screen.base.BaseScreen;
import kw.test.memory.screen.data.MainData;
import kw.test.memory.screen.view.MainView;

public class MainScreen extends BaseScreen {
    private MainView view;
    private MainData data;

    @Override
    protected void initData() {
        super.initData();
        data = new MainData();
    }

    @Override
    protected void initView() {
        super.initView();
        view = new MainView(data);
        stage.addActor(view);
    }

    @Override
    public void initListener(){
        super.initListener();
        int[] arr = data.getArr();
        for (int i = 0; i < arr.length; i++) {
            Actor actor = view.findActor("table_" + i);
            final int num = arr[i];
            actor.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    enterScreen(new GameScreen(num));
                }
            });
        }
    }
}

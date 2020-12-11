package kw.test.memory.screen;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.sun.jmx.remote.internal.ArrayQueue;
import kw.test.memory.card.Card;
import kw.test.memory.data.GameData;
import kw.test.memory.screen.base.BaseScreen;
import kw.test.memory.screen.view.GameView;

public class GameScreen extends BaseScreen {
    Array<Card> cards = new Array<>();
    private ArrayQueue<Card> arrayQueue = new ArrayQueue<>(1);
    Array<Card> currentCard = new Array<>();
    public GameData data;
    public GameView view;
    private int num;
    public GameScreen(int num) {
        this.num = num;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    protected void initView() {
        super.initView();
        view = new GameView(data);
        stage.addActor(view);
    }

    @Override
    protected void initData() {
        super.initData();
        data = new GameData();
        data.setNum(num);
    }

    @Override
    protected void initListener() {
        super.initListener();
        for (int i = 0; i < data.getNum(); i++) {
            Card card = view.findActor("card_" + i);
            card.setListener(listener);
            currentCard.add(card);
        }
    }

    private Card.Listener listener = new Card.Listener() {
        @Override
        public void click(Card card) {
            data.addNum();
            if (!arrayQueue.isEmpty()) {
                //compare
                isFind(card);
            }else {
                remaner(card);
            }
        }
    };

    private void remaner(Card card) {
        card.zheng();
        arrayQueue.add(card);
        for (Card card1 : cards) {
            card1.fan();
            card1.fan();
        }
        cards.clear();
    }

    public void isFind(Card card){
        Card remove = arrayQueue.remove(0);
        if (card.getTag().equals(remove.getTag())) {
            card.find();
            remove.find();
            cards.clear();
            currentCard.removeValue(card,true);
            currentCard.removeValue(remove,true);
            if (currentCard.size==0) {
                status = gameStatus.passlevel;
                view.showPassPanel();
                addListener();
            }
        }else {
            arrayQueue.clear();
            cards.add(card);
            cards.add(remove);
            card.zheng();
        }
    }

    private void addListener() {
        Actor layer = stage.getRoot().findActor("layer");
        layer.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                layer.remove();
                enterScreen(MainScreen.class);
            }
        });
    }

}

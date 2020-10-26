package com.kw.game.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class LabelScroll extends Group {
    private Label scoreLabel;
    private int coinNum;
    private int targetCoinNum = 10000;
    private float updateTime;
    private int updateOffset;
    private float stateTime;

    public LabelScroll() {
        super();
        init();
    }

    private void init() {
        Label.LabelStyle style = new Label.LabelStyle() {{
            font = new BitmapFont(Gdx.files.internal("font100-500.fnt"));
        }};
        scoreLabel = new Label("", style) {{
            setFontScale(0.6F);
            setWidth(getPrefWidth());
            setPosition(getWidth() / 2, getHeight() / 2, Align.center);
        }};
        addActor(scoreLabel);
        scoreLabel.setColor(Color.BLUE);
        updateOffset = 10;
    }

    private boolean needUpdate = true;
    private int aniNum = 0;

    public void setAnimal() {
        if (!needUpdate) {
            needUpdate = true;
            if (targetCoinNum - coinNum < 10) {
                updateOffset = 1;
            } else {
                updateOffset = (targetCoinNum - coinNum) / 10;
            }
            aniNum = 0;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (needUpdate) {
            stateTime += Gdx.graphics.getDeltaTime();
            if (stateTime > 0.035F) {
                stateTime = 0;
                aniNum++;
                if (coinNum < targetCoinNum) {
                    if (coinNum + updateOffset < targetCoinNum) {
                        setCoinNum(coinNum + updateOffset);
                    } else {
                        setCoinNum(targetCoinNum);
                    }
                } else {
                    needUpdate = false;
                    setCoinNum(targetCoinNum);
                }
            }
        }
        super.draw(batch, parentAlpha);
    }

    public void setCoinNum(int coinNum) {
        String coinNumTemp;
        if (coinNum > Integer.MAX_VALUE) {
            coinNum = Integer.MAX_VALUE;
        }
        if (coinNum < 9999) {
            coinNumTemp = coinNum + "";
            if (coinNum > 999 && coinNum <= 9999) {
                coinNumTemp = coinNumTemp.substring(0, 1) + "," + coinNumTemp.substring(1);
            }
        } else if (coinNum < 99999) {
            DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
            df.applyPattern("#.0");
            coinNumTemp = df.format(coinNum / 1000.0F) + "K";
        } else {
            DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
            df.applyPattern("#");
            coinNumTemp = df.format(coinNum / 1000.0F) + "K";
        }
        this.coinNum = coinNum;
        scoreLabel.setText(coinNumTemp);
        scoreLabel.setAlignment(Align.center);
        scoreLabel.setWidth(scoreLabel.getPrefWidth());
        scoreLabel.setPosition(getWidth() / 2, getHeight() / 2, Align.center);
    }
}
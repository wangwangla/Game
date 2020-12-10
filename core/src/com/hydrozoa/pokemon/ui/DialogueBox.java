package com.hydrozoa.pokemon.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

/**
 * @author hydrozoa
 *
 *  字体可以慢慢显示的类
 *  实现思路：
 *   总的时长时每个字符显示的时长总和   计算出总时长，
 *
 *   停止条件，当计数时长大于总时长的时候，可以认为是动画结束  ，改变状态，避免重复执行
 */
public class DialogueBox extends Table {
	
	private String targetText = "";
	private float animTimer = 0f;
	private float animationTotalTime = 0f;
	private float TIME_PER_CHARACTER = 0.05f;
	private STATE state = STATE.IDLE;
	
	private Label textLabel;
	
	private enum STATE {
		ANIMATING,
		IDLE,
		;
	}
	
	public DialogueBox(Skin skin) {
		super(skin);
		this.setBackground("dialoguebox");
		textLabel = new Label("\n", skin);
		this.add(textLabel).expand().align(Align.left).pad(5f);
	}
	
	public void animateText(String text) {
		targetText = text;
		animationTotalTime = text.length()*TIME_PER_CHARACTER;
		state = STATE.ANIMATING;
		animTimer = 0f;
	}
	
	public boolean isFinished() {
		if (state == STATE.IDLE) {
			return true;
		} else {
			return false;
		}
	}
	
	private void setText(String text) {
		if (!text.contains("\n")) {
			text += "\n";
		}
		this.textLabel.setText(text);
	}
	
	@Override
	public void act(float delta) {
		if (state == STATE.ANIMATING) {
			animTimer += delta;
			if (animTimer > animationTotalTime) {
				state = STATE.IDLE;
				animTimer = animationTotalTime;
			}
			String actuallyDisplayedText = "";
			int charactersToDisplay = (int)((animTimer/animationTotalTime)*targetText.length());
			for (int i = 0; i < charactersToDisplay; i++) {
				actuallyDisplayedText += targetText.charAt(i);
			}
			if (!actuallyDisplayedText.equals(textLabel.getText().toString())) {
				setText(actuallyDisplayedText);
			}
		}
	}

	@Override
	public float getPrefWidth() {
		return 200f;
	}
}

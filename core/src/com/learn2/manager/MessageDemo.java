package com.learn2.manager;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ai.msg.MessageManager;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.ai.msg.Telegraph;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.learn2.component.MoveComponent;
import com.learn2.component.PlayComponect;
import com.learn2.constant.Constant;
import com.learn2.system.PlaySystem;

public class MessageDemo implements Telegraph {
    public MessageDemo(){
        MessageManager.getInstance().dispatchMessage(0, this, this, 1, 1);
    }

    @Override
    public boolean handleMessage(Telegram msg) {
        System.out.println("=========处理消息！");
        return false;
    }

    public static void main(String[] args) {
        MessageDemo messageDemo = new MessageDemo();

    }
}

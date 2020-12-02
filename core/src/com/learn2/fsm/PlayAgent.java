package com.learn2.fsm;

import com.badlogic.gdx.ai.fsm.DefaultStateMachine;
import com.badlogic.gdx.ai.fsm.StateMachine;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.ai.msg.Telegraph;
import com.learn2.component.PlayComponect;

public class PlayAgent implements Telegraph {

    private final PlayComponect playComponect;
    public final StateMachine<PlayAgent,PlayState> stateStateMachine;

    public PlayAgent(PlayComponect componect){
        this.playComponect = componect;
        stateStateMachine = new DefaultStateMachine<>(this);
    }

    @Override
    public boolean handleMessage(Telegram msg) {
        System.out.println(msg.message+"==================");
        return false;
    }

    public void update(float deltaTime){
        stateStateMachine.update();
    }
}

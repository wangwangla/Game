package com.learn2.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;
import com.learn2.fsm.PlayAgent;
import com.learn2.fsm.PlayState;

public class PlayComponect implements Component {
    public String message;
    public Body body;
    public PlayAgent agent;

    public PlayComponect(Body body){
        this.body = body;
        agent = new PlayAgent(this);
        agent.stateStateMachine.setInitialState(PlayState.IDLE_RIGHT);
    }
    public void set(String message) {
        this.message = message;
    }
}

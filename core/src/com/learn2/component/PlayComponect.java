package com.learn2.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;

public class PlayComponect implements Component {
    public String message;
    public Body body;
    public PlayComponect(Body body){
        this.body = body;
    }
    public void set(String message) {
        this.message = message;
    }
}

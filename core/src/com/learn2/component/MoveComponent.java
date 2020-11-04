package com.learn2.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;

public class MoveComponent implements Component {
    public float speed = 3.6f;
    public Body body;

    public MoveComponent(Body body) {
        this.body = body;
    }
}

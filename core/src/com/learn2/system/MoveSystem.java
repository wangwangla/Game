package com.learn2.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.learn2.component.MoveComponent;

public class MoveSystem extends IteratingSystem {

    public MoveSystem() {
        super(Family.all(MoveComponent.class).get());
    }

    public MoveSystem(Family family, int priority) {
        super(family, priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}

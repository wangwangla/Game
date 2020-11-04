package com.learn2.component;

import com.badlogic.ashley.core.Component;

public class HelloConponent implements Component {
    public String message;

    public void set(String message) {
        this.message = message;
    }
}

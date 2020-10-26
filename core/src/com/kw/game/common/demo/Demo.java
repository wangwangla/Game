package com.kw.game.common.demo;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class Demo {
    private static final Pool<Builder> pool = Pools.get(Builder.class, 32);
    private Vector position;

    public static Builder builder() {
        return Builder.obtain(null);
    }


    public static class Builder implements Pool.Poolable {
        Demo animation;
        @Override
        public void reset() {

        }

        public static Builder obtain(Demo animation) {
            Builder builder = pool.obtain();
            builder.animation = animation;
            return builder;
        }

        public Demo build() {
            pool.free(this);
            return animation;
        }
    }
}

package com.learn2.fsm;

import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.ai.msg.Telegram;

public enum  PlayState implements State<PlayAgent> {
    MOVE_UP() {
        @Override
        public void update(PlayAgent entity) {

        }
    },
    MOVE_DOWN() {
        @Override
        public void update(PlayAgent entity) {
        }

    },
    MOVE_LEFT() {
        @Override
        public void update(PlayAgent entity) {

        }

    },
    MOVE_RIGHT() {
        @Override
        public void update(PlayAgent entity) {

        }

    },
    IDLE_UP() {
        @Override
        public void update(PlayAgent entity) {

        }

    },
    IDLE_DOWN() {
        @Override
        public void update(PlayAgent entity) {

        }

    },
    IDLE_LEFT() {
        @Override
        public void update(PlayAgent entity) {

        }

    },
    IDLE_RIGHT() {
        @Override
        public void update(PlayAgent entity) {

        }

    },
    DIE() {
        @Override
        public void update(PlayAgent entity) {
        }

    };


    @Override
    public void enter(PlayAgent entity) {

    }

    @Override
    public void exit(PlayAgent entity) {

    }

    @Override
    public boolean onMessage(PlayAgent entity, Telegram telegram) {
        return false;
    }
}

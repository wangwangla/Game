package com.learn2.fsm;

import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.ai.msg.MessageManager;
import com.badlogic.gdx.ai.msg.Telegram;

public enum  PlayState implements State<PlayAgent> {
    MOVE_UP() {
        @Override
        public void update(PlayAgent entity) {
            System.out.println("=========>MOVE_UP");
        }
    },
    MOVE_DOWN() {
        @Override
        public void update(PlayAgent entity) {
            System.out.println("=========>MOVE_DOWN");
        }
    },
    MOVE_LEFT() {
        @Override
        public void update(PlayAgent entity) {
            System.out.println("=========>MOVE_LEFT");
        }
    },
    MOVE_RIGHT() {
        @Override
        public void update(PlayAgent entity) {
            System.out.println("=========>MOVE_RIGHT");
        }
    },
    IDLE_UP() {
        @Override
        public void update(PlayAgent entity) {
            System.out.println("=========>MOVE_IDLE_UP");
        }

    },
    IDLE_DOWN() {
        @Override
        public void update(PlayAgent entity) {
            System.out.println("=========>IDLE_DOWN");
        }

    },
    IDLE_LEFT() {
        @Override
        public void update(PlayAgent entity) {
            System.out.println("=========>IDLE_LEFT");
        }

    },
    IDLE_RIGHT() {
        @Override
        public void update(PlayAgent entity) {
            System.out.println("=========>IDLE_RIGHT");
            entity.stateStateMachine.changeState(DIE);


            MessageManager.getInstance().dispatchMessage(0.0f, // ID of sender
                    entity.stateStateMachine,
                    entity, // ID of recipient
                    22, // the message
                    null);



        }

    },
    DIE() {
        @Override
        public void update(PlayAgent entity) {
            System.out.println("=========>DIE");
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
        System.out.println("================="+telegram.message);
        //处理消息
        if (telegram.message == MessageType.HI_HONEY_I_M_HOME) {
            System.out.println("处理消息！");
        }
        return false;
    }
}

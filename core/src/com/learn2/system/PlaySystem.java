package com.learn2.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.learn2.component.MoveComponent;
import com.learn2.component.PlayComponect;

/**
 * - 每时每刻处理一个实体子集
 *
 */
public class PlaySystem extends IteratingSystem {
    private final ComponentMapper<PlayComponect> playCom = ComponentMapper.getFor(PlayComponect.class);
    private final ComponentMapper<MoveComponent> moveCom = ComponentMapper.getFor(MoveComponent.class);

    public PlaySystem() {
        super(Family.all(PlayComponect.class).get());
    }

    public PlaySystem(Family family, int priority) {
        super(family, priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        MoveComponent moveComponent = moveCom.get(entity);
//        MoveComponent moveComponent = moveCom.get(entity);
//        Body body = moveComponent.body;

        /**
         * 判断实体的属性执行相应的操作
         */
        if ((Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT))) {
//            body.applyLinearImpulse(tmpV1.set(movement.speed, 0).scl(body.getMass()), body.getWorldCenter(), true);
//            body.applyLinearImpulse(new Vector2(3,0), body.getWorldCenter(), true);
            moveComponent.body.applyLinearImpulse(new Vector2(0, 3.6F).scl(moveComponent.body.getMass()),
                    moveComponent.body.getWorldCenter(), true);
        }
    }
}
//
///**
// * 跟踪实体的子集，不执行任何排序和迭代
// */
//class BaseHello extends BaseEntitySystem{
//
//    @Override
//    protected void processSystem() {
//
//    }
//}
//
///**
// * 每次间隔x个滴答处理一次实体的子集
// */
//class IntervallteratingHello extends IntervalIteratingSystem{
//
//    public IntervallteratingHello(Family family, float interval) {
//        super(family, interval);
//    }
//
//    @Override
//    protected void processEntity(Entity entity) {
//
//    }
//}
//
///**
// * 追踪的冷却时间
// */
//class DelayIteratingSystem extends DelayedIteratingSystem{
//
//    @Override
//    protected float getRemainingDelay(int entityId) {
//        return 0;
//    }
//
//    @Override
//    protected void processDelta(int entityId, float accumulatedDelta) {
//
//    }
//
//    @Override
//    protected void processExpired(int entityId) {
//
//    }
//}
//
//class EntityProcessing extends EntityProcessingSystem{
//    @Override
//    protected void process(com.artemis.Entity e) {
//
//    }
//}
//
//class EntitySystemHello extends EntitySystem {
//
//}
//
//class IntervalEntityProcessing extends IntervalEntityProcessingSystem {
//
//    /**
//     * Creates a new IntervalEntityProcessingSystem.
//     *
//     * @param aspect   the aspect to match entities
//     * @param interval
//     */
//    public IntervalEntityProcessing(Aspect.Builder aspect, float interval) {
//        super(aspect, interval);
//    }
//
//    @Override
//    protected void process(com.artemis.Entity e) {
//
//    }
//}
//
//class DelayedEntityProcessing extends DelayedEntityProcessingSystem {
//    @Override
//    protected float getRemainingDelay(com.artemis.Entity e) {
//        return 0;
//    }
//
//    @Override
//    protected void processDelta(com.artemis.Entity e, float accumulatedDelta) {
//
//    }
//
//    @Override
//    protected void processExpired(com.artemis.Entity e) {
//
//    }
//}
//

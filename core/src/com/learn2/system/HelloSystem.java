package com.learn2.system;

import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.artemis.systems.DelayedEntityProcessingSystem;
import com.artemis.systems.DelayedIteratingSystem;
import com.artemis.systems.EntityProcessingSystem;
import com.artemis.systems.IntervalEntityProcessingSystem;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IntervalIteratingSystem;
import com.badlogic.ashley.systems.IteratingSystem;
import com.learn2.component.HelloConponent;

/**
 * - 每时每刻处理一个实体子集
 *
 */
public class HelloSystem extends IteratingSystem {
    private final ComponentMapper<HelloConponent> ghostM = ComponentMapper.getFor(HelloConponent.class);
    public HelloSystem() {
        super(Family.all(HelloConponent.class).get());
    }

    public HelloSystem(Family family, int priority) {
        super(family, priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        System.out.println(entity.getComponent(HelloConponent.class).message);
        HelloConponent h = ghostM.get(entity);
        System.out.println(h.message);
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

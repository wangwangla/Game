package com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * 游戏主程序的启动入口类
 */
public class Box2DDemo extends ApplicationAdapter {

    protected OrthographicCamera camera;
    protected Box2DDebugRenderer renderer; // 测试用绘制器
    private World world;

    @Override
    public void create() {
        camera = new OrthographicCamera(48, 32);
        camera.position.set(0, 15, 0);
        renderer = new Box2DDebugRenderer();

        world = new World(new Vector2(0, -9.8f), true); // 一般标准重力场
        BodyDef bd = new BodyDef(); //声明物体定义
        bd.position.set(2f, 2f);
        bd.type= BodyDef.BodyType.DynamicBody;
        Body b = world.createBody(bd); //通过world创建一个物体
        CircleShape c = new CircleShape(); //创建一个形状（圆）
        c.setRadius(1f); //设置半径
        b.createFixture(c, 1f); //将形状和密度赋给物体
    }

    @Override
    public void dispose() {

        renderer.dispose();
        world.dispose();

        renderer = null;
        world = null;
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render() {
        world.step(Gdx.app.getGraphics().getDeltaTime(), 3, 3);
        camera.update();
        renderer.render(world, camera.combined);
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }
//
//    public static void main(String[] args) {
//        new LwjglApplication(new MainGame(new Box2DDemo(), new AppStorePayListener());
//    }

}
package com.pacman.screen;

import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.pacman.constant.Constant;
import com.pacman.screen.base.BaseScreen;
import com.pacman.view.GameView;
import com.pacman.view.controller.GameController;

import box2dLight.RayHandler;

public class GameScreen extends BaseScreen {
    private World world;
    Box2DDebugRenderer box2DDebugRenderer;
    private RayHandler handler;

    @Override
    public void show() {
        super.show();
        this.world = Constant.world;
        GameView view = new GameView();
        stage.addActor(view);
        GameController controller = new GameController();
        box2DDebugRenderer = Constant.box2DDebugRenderer;
        handler = Constant.rayHandler;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        world.step(1 / 60f, 8, 3);
        box2DDebugRenderer.render(world,Constant.viewport.getCamera().combined);
        handler.setCombinedMatrix(Constant.orthographicCamera);
        handler.updateAndRender();
    }
}

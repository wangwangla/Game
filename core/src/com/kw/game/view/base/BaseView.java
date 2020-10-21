package com.kw.game.view.base;


import com.badlogic.gdx.scenes.scene2d.Group;

public class BaseView extends Group {
    private boolean in;
    public BaseView(){
        setSize(720,1280);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isVisible()&& getParent()!=null && getParent().getChildren().size-1 == getZIndex()){
            in();
        }else{
            out();
        }
    }
    protected void in(){
        if (!in) {
            in = true;
            System.out.println("======>");
        }
    }

    protected void out(){
        if (in){
            in=false;
            System.out.println("<=========");
        }
    }
}

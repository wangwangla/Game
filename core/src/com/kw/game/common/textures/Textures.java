package com.kw.game.common.textures;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class Textures implements Disposable {
    public final Texture white;
    public final Texture modal;

    public Textures() {
        white = createTexture(new Color(0.0f, 0.0f, 0.0f, 1f));
        modal = createTexture(new Color(0.0f, 0.0f, 0.0f, 1f));
    }

    /**
     * 绘制大小为0，使用的时候设置大小
     * @param color
     * @return
     */
    public Texture createTexture(Color color) {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;


//        Pixmap pixmap = new Pixmap(800, 480, Pixmap.Format.RGBA8888);
//        pixmap.setColor(Color.BLUE);//设置pixmap的颜色
////        pixmap.drawLine(0, 0, 100, 100);//画线
////        pixmap.drawLine(200, 0, 300, 100);//起点(x1,y1)、终点(x2,y2)
////        pixmap.fillCircle(150, 150, 32);//画实心圆.(x,y)和半径
////        pixmap.drawCircle(250, 100, 50);//画空心圆.(x,y)和半径
////        pixmap.drawRectangle(0, 0, 150, 150);//画空心矩形.起点(x,y),(width,height)
//        pixmap.fillRectangle(0, 160, 100, 100);//画实心矩形.起点(x,y),(width,height)
//        Texture texture = new Texture(pixmap);
//        pixmap.dispose();
//        return texture;
    }

    @Override
    public void dispose() {
        white.dispose();
        modal.dispose();
    }
}
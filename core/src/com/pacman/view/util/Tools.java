package com.pacman.view.util;

import com.badlogic.gdx.math.Rectangle;
import com.pacman.constant.Constant;

public class Tools {
    public static void correctRectangle(Rectangle rectangle){
        rectangle.x = rectangle.x / Constant.PPM;
        rectangle.y = rectangle.y / Constant.PPM;
        rectangle.width = rectangle.width / Constant.PPM;
        rectangle.height = rectangle.height / Constant.PPM;
    }
}

package model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import utils.ColorUtils;

import java.util.List;
import java.util.Random;

public class Cat{
    private static final int CONST_WIDTH =35;
    private static final int CONST_HEIGH=35;
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getRect() {
        return rect;
    }

    private Rectangle rect;

    public Cat(int x, int y){
        this.x=x;
        this.y=y;
        this.rect = new Rectangle(CONST_WIDTH, CONST_HEIGH, Color.RED);

    }

}
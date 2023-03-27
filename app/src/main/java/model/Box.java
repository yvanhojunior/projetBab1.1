package model;

import javafx.scene.paint.Color;
public class Box {
    private int x;
    private int y;
    private Color color;
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Box(int x, int y){
        this.x=x;
        this.y = y;
        color = new Color(1.0, 1.0, 1.0, 1.0);
    }
}

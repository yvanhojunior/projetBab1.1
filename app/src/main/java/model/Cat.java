package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cat{
    private Color color;
    private int x;
    private int y;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setCol(int y) {
        this.y = y;
    }

    public Cat(int x, int y){
            this.color = generateRandomColor();
            this.x = x;
            this.y = y;
        }

       /*public Rectangle getRectangle(){
            Rectangle rect = new Rectangle(50, 50, this.color);
            rect.setX(this.x);
            rect.setY(this.y);
            return rect;
        }*/
        private Color generateRandomColor(){
            double red = Math.random();
            double green = Math.random();
            double blue = Math.random();
            return  new Color(red, green, blue, 1.0);
        }
    }

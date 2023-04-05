package model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import utils.ColorUtils;

import java.util.List;
import java.util.Random;

public class Cat extends Rectangle {

    private Color color;
    private double startX, startY;
    private boolean isDragged;

    public Cat(double width, double height, Color color){
        super(width, height);
        this.color=color;
        setFill(color);
        setStroke(color.BLACK);

        //initialisation des attributs de deplacement
        startX = 0;
        startY =0;
        isDragged = false;
    }
    //methode appelée a la fin du deplacement
    public void stopDragging(){
        //désactivation du déplacement
        isDragged=false;
    }

    //methode appelée pendant le déplacement
    public void drag(double x, double y){
        //si l'objet est entrain d'etre déplacé
        if(isDragged){
            //calcul de la new position en fonction de la position de la souris
            //et de la distance entre le point de départ du déplacement et la position de l'objet
            setX(x-startX);
            setY(y-startY);
        }
    }

    public static Group createForm(int numCats, double width, double height, Color color){
        Group group = new Group();
        for (int i = 0; i < numCats; i++) {
            Rectangle rectangle = new Rectangle(width, height, Color.RED);
            rectangle.setLayoutX(i * width); // positionnement horizontal
            rectangle.setLayoutY(0); // positionnement vertical
            group.getChildren().add(rectangle);
        }
       /* for(int i=0; i<numCats;i++){
            Cat cat = new Cat(width, height, color);
            if(i>0){
                Cat firstCat = (Cat) group.getChildren().get(0);
                if(i<(numCats/2)) {
                    cat.setX(firstCat.getWidth() * i);
                }
                else {
                    cat.setY(firstCat.getHeight()*(i-(numCats/2)));
                }

            }
            group.getChildren().add(cat);
        }*/
        return group;
    }
    public Color getColor(){
        return color;
    }
}
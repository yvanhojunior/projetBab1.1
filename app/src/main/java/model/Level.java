package model;

import controller.LevelLoader;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Level {
    public static final double WIDTH = 35;
    public static final double HEIGHT = 35;

    private int numRows;
    private int numCols;
    private String nameLevel;
    private List<VBox> listeVbox;

    public Level(String nameLevel){
        listeVbox = new ArrayList<>();
        this.nameLevel = nameLevel;
        createForm();
    }
    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }
    public List<VBox> getListeVbox() {
        return listeVbox;
    }
    LevelLoader levelLoader = new LevelLoader(nameLevel);

    /**
     * cette methode a pour but de generer des blocs de cat, elle place dans un group des rectangles de maniere a former un bloc
     * et apres avoir former le bloc, elle le met dans un vBox, les vBox a leurs tour sont misent dans une liste de Vbox.Donc au final
     * on aura une liste de Vbox qui aura a son sein deux vBox ( celle de gauche et de droite de mon interface graphique) et chaque
     * vBox aura a son sein un bloc
     */
    public void createForm() {
        List liste = levelLoader.getListe();
        this.numRows = (int)liste.get(0);
        this.numCols = (int)liste.get(1);
        Group group = new Group();
        VBox vBox = new VBox();
        for(int i=3; i<liste.size(); i++){
            int val = (int) liste.get(i);
            while(val != -1 && val!=1){
                    if(val%2==0){
                        int val1 = val/2;
                        for(int k=0; k<2; k++){
                            for(int h = 0; h<val1; h++){
                                Cat cat = new Cat(WIDTH, HEIGHT, Color.GREEN);
                                cat.setLayoutX(h*WIDTH);
                                cat.setLayoutY(k*WIDTH);
                                group.getChildren().add(cat);
                            }
                        }
                    }else{
                        int val1 = 1 + val/2;
                        for(int k = 0; k<2; k++){
                            for(int h = 0; h<val1-k; h++){
                                Cat cat = new Cat(WIDTH, HEIGHT, Color.GREEN);
                                cat.setLayoutX(h*WIDTH);
                                cat.setLayoutY(k*WIDTH);
                                group.getChildren().add(cat);
                            }
                        }
                    }
            }
            if(val == 1){
                Cat cat = new Cat(WIDTH, HEIGHT, Color.GREEN);
                cat.setLayoutX(0);
                cat.setLayoutY(0);
                group.getChildren().add(cat);
            }
            if(val!=-1)
                vBox.getChildren().add(group);
            else
                listeVbox.add(vBox);

        }

    }
}

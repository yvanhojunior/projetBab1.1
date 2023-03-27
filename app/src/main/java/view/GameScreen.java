package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Box;
import model.Cat;

public class GameScreen extends GridPane {
    private int numRows;
    private int numCols;
    private List<Cat> listeCats;
    private List<Box> listeBox;
    //public Pane gameScreen1 = new GameScreen1();
    public GameScreen(int numRows, int numCols){
        this.numRows = numRows;
        this.numCols = numCols;
        this.listeCats = new ArrayList<>();
        this.listeBox = new ArrayList<>();

        //création des boxs
        for(int i=0; i<numRows; i++){
            for(int j=0; j<numCols; j++){
                Box box = new Box(i, j);
                listeBox.add(box);

            }
        }

      //Créez des chats aléatoires
        Random rand = new Random();
        for(int i = 0; i<10; i++){
            int x = rand.nextInt(numRows);
            int y = rand.nextInt(numCols);
            Cat cat = new Cat(x, y);
            listeCats.add(cat);
        }

        // ajouter les box dans ma grille de jeu
        for(Box box : listeBox){
            Rectangle rect = new Rectangle(50, 50);
            rect.setFill(box.getColor());
            this.add(rect, box.getX(), box.getY());
        }
        //Ajoutez les chats à la grille de jeu
        for(Cat cat : listeCats){
            Rectangle rect = new Rectangle(50, 50);
            rect.setFill(cat.getColor());
            this.add(rect, cat.getX(), cat.getY());
        }

    }
    private class GameScreen1 extends GridPane{
        private Rectangle rect;
        public GameScreen1(){
            rect = new Rectangle(150, 200);
            rect.setFill(Color.WHITE);
            Group group = new Group();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    Rectangle subRect = new Rectangle(50, 50);
                    subRect.setFill(Color.RED);
                    subRect.setX(j * 50);
                    subRect.setY(i * 50);
                    group.getChildren().add(subRect);
                }
            }
        }
    }

}

package view;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Box;
import model.Cat;
import model.Level;
import org.w3c.dom.css.Rect;

public class GameScreen extends BorderPane {

    private GridPane gridPane;
    private VBox leftBox;
    private VBox rightBox;

    private List<Box> listeBox;

    /*public GameScreen(int numCats, int numRows, int numCols, double catWidth, double catHeight){*/
    public GameScreen(int numRows, int numCols){
        gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        listeBox = new ArrayList<>();
        Level level = new Level("controller/level1.txt");

        /*insertBox(numRows, numCols, catWidth, catHeight);
        createCatLeft(numCats, catWidth, catHeight);
        createCatRight(numCats, catWidth, catHeight);
        //ajout des elements a la GameScreen
        this.setCenter(gridPane);
        this.setLeft(leftBox);
        this.setRight(rightBox);*/

        this.setCenter(gridPane);
        this.setLeft(level.getListeVbox().get(0));
        this.setRight(level.getListeVbox().get(1));
    }

    //creation des box et ajout a ma gridPane
    public void insertBox(int numRows, int numCols, double catWidth, double catHeight) {
        //creation des boxs et ajout a ma gridpane--------------------
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                Box box = new Box(i, j);
                listeBox.add(box);
            }
        }

        for (Box box : listeBox) {
            Rectangle rect = new Rectangle(catWidth, catHeight);
            rect.setFill(box.getColor());
            gridPane.add(rect, box.getX(), box.getY());
        }
        gridPane.setAlignment(Pos.CENTER);
        //--------------------------------------------------------------------
    }
    public void createCatLeft(int numCats, double catWidth, double catHeight){
        //creation des cats à gauche de la Gamescreen
        leftBox = new VBox();
        leftBox.setPadding(new Insets(10));
        leftBox.setSpacing(10);

        leftBox.getChildren().add(Cat.createForm(numCats, catWidth, catHeight, Color.BLUE));
        leftBox.setAlignment(Pos.CENTER_LEFT);
        //---------------------------------------------------------------------
    }
    public void createCatRight(int numCats, double catWidth, double catHeight){
        //creation des cats à droite de ma gridpane
        rightBox = new VBox();
        rightBox.setPadding(new Insets(10));
        rightBox.setSpacing(10);

        rightBox.getChildren().add(Cat.createForm(numCats, catWidth, catHeight, Color.GREEN));
        rightBox.setAlignment(Pos.CENTER_RIGHT);
    }

}






package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Box;
import model.Cat;
import model.Level;

public class GameScreen extends BorderPane {

    private GridPane gridPane;
    private VBox leftBox;
    private VBox rightBox;

    public GameScreen() {
        Level level = new Level();

        gridPane = level.getGridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setHgap(1);
        gridPane.setVgap(1);

        VBox leftVbox = level.getLeftVbox();

        VBox rightVbox = level.getRightVbox();

        this.setCenter(gridPane);
        this.setLeft(leftVbox);
        this.setRight(rightVbox);

    }
}


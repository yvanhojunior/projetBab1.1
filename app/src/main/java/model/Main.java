package model;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.GameScreen;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.Collection;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
       BorderPane root = new BorderPane();
       root.setPrefSize(500, 500);

        //creation de la région centrale
        GridPane centerPaneGameScreen = new GameScreen(5, 5);
        centerPaneGameScreen.setGridLinesVisible(true);//active la visibilité des lignes de la grille
        centerPaneGameScreen.setPrefSize(250, 250);

        //creation des regions left, rigth, top rt bottom
       // Pane leftPane = ((GameScreen) centerPaneGameScreen).gameScreen1;
        Pane leftPane = new Pane();
        Pane rigthPane = new Pane();
        Pane topPane = new Pane();
        Pane bottomPane = new Pane();

        leftPane.setPrefSize(125, 125);
        rigthPane.setPrefSize(125, 125);
        topPane.setPrefSize(125, 125);
        bottomPane.setPrefSize(125, 125);

        //ajout des région a la borderPane
        root.setLeft(leftPane);
        root.setRight(rigthPane);
        root.setTop(topPane);
        root.setBottom(bottomPane);
        root.setCenter(centerPaneGameScreen);

        // Ajouter une bordure à la BorderPane
        root.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Game Screen");
        primaryStage.show();

    }
    public static void main(String[] args){

        //lancer l'appli
        launch(args);
    }
}

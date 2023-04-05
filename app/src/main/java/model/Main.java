package model;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Cat;
import view.GameScreen;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //test de la nouvelle methode createForm de la classe Level
        Level level = new Level("controller/level1.txt");
        List<VBox> vBox = new ArrayList<>();
        vBox = level.getListeVbox();

        // Création d'un groupe de chats avec la méthode createForm de la classe Cat
        Group catsGroup = Cat.createForm(4, 25, 25, Color.ORANGE);
        GameScreen gameScreen = new GameScreen(level.getNumRows(), level.getNumCols());

        //test ------------------------------------------------
        Rectangle rect = new Rectangle(0, 0,25, 25);
        rect.setFill(Color.RED);
        Rectangle rect1 = new Rectangle(0, 1,25, 25);
        rect1.setFill(Color.GRAY);
        Rectangle rect2 = new Rectangle(1, 0,25, 25);
        rect2.setFill(Color.PINK);
        Group gp = new Group();
        gp.getChildren().addAll(rect, rect1, rect2);
        //-------------------------------------------------------
        // Création de la scène avec le groupe de chats
        Scene scene = new Scene(gameScreen, 800, 600);

        // Configuration de la fenêtre
        primaryStage.setTitle("Cats");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

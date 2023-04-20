package model;
import controller.LevelLoader;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import view.GameScreen;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
            GameScreen gameScreen = new GameScreen();
            Scene scene = new Scene(gameScreen, 800, 600);
            primaryStage.setTitle("Cats");
            primaryStage.setScene(scene);
            primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

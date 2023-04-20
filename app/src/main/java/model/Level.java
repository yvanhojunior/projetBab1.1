package model;

import controller.LevelLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level {
    public static final double WIDTH = 35;
    private double[] startPos;
    private VBox leftVbox;
    private VBox rightVbox;

    public VBox getLeftVbox() {
        return leftVbox;
    }

    public VBox getRightVbox() {
        return rightVbox;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    private GridPane gridPane;

    private GridPane gridPane1;

    public Level() {
        leftVbox = new VBox();
        shapping(leftVbox);

        rightVbox = new VBox();
        shapping(rightVbox);

        gridPane = new GridPane();

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/jyvan/OneDrive/Documents/Niveau2/Quad2/ProjetBab1/app/src/main/java/controller/level1.txt"))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                if (i == 0) {
                    for (int j = 0; j < Integer.parseInt(words[0]); j++) {
                        for (int k = 0; k < Integer.parseInt(words[1]); k++) {
                            Box box = new Box(j, k);
                            Rectangle rect = new Rectangle(WIDTH, WIDTH, box.getColor());
                            gridPane.add(rect, box.getX(), box.getY());
                        }
                    }
                    i = 1;
                } else {
                    gridPane1 = new GridPane();
                    if (i == 1) {
                        if (Integer.parseInt(words[0]) == -1)
                            i = 2;
                        for (int j = 0; j < Integer.parseInt(words[0]) * 2; j += 2) {
                            Cat cat = new Cat(Integer.parseInt(words[j + 1]), Integer.parseInt(words[j + 2]));
                            System.out.println(cat.getX() + " " + cat.getY());
                            gridPane1.add(cat.getRect(), cat.getX(), cat.getY());
                        }
                        EventManager(gridPane1);
                        leftVbox.getChildren().add(gridPane1);
                    } else {
                        for (int j = 0; j < Integer.parseInt(words[0]) * 2; j += 2) {
                            Cat cat = new Cat(Integer.parseInt(words[j + 1]), Integer.parseInt(words[j + 2]));
                            System.out.println(cat.getX() + " " + cat.getY());
                            gridPane1.add(cat.getRect(), cat.getX(), cat.getY());
                        }
                        EventManager(gridPane1);
                        rightVbox.getChildren().add(gridPane1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shapping(VBox vBox) {
        vBox.setSpacing(50);
        vBox.setPadding(new Insets(30));

    }

    public void EventManager(GridPane gridPaneCat) {

        // ajoutez un gestionnaire d'evenements pour chaque bloc
        gridPaneCat.setOnMousePressed(e -> {
            // Stocke la position initiale du bloc lorsque l'utilisateur clique dessus
            gridPaneCat.setUserData(new double[]{gridPaneCat.getLayoutX(), gridPaneCat.getLayoutY()});
            startPos = new double[] {gridPaneCat.getLayoutX(), gridPaneCat.getLayoutY()};
        });

        // Ajoutez un gestionnaire d'événements pour suivre le mouvement de la souris et déplacer le bloc en conséquence
        gridPaneCat.setOnMouseDragged(e -> {
            double[] startPos = (double[]) gridPaneCat.getUserData();
            double x = e.getSceneX() - startPos[0];
            double y = e.getSceneY() - startPos[1];
            gridPaneCat.setLayoutX(x);
            gridPaneCat.setLayoutY(y);
        });

       // Ajoutez un gestionnaire d'événements pour placer le bloc
        gridPaneCat.setOnMouseReleased(e -> {
            //vérifiez si le bloc est en collision avec la gridPane
            if (gridPaneCat.getBoundsInParent().intersects(gridPane.getBoundsInParent())) {
                //convertissez les coordonnées de la souris en coordonnées de la gridpane
                double x = e.getSceneX() - gridPane.getLayoutX() - gridPaneCat.getLayoutX();
                double y = e.getSceneY() - gridPane.getLayoutY() - gridPaneCat.getLayoutY();
                int colIndex = (int) Math.floor(x / gridPaneCat.getWidth());
                int rowIndex = (int) Math.floor(y / gridPaneCat.getHeight());

                //Vérifiez si la case de la gridPane est libre
                if (gridPane.getChildren().stream().noneMatch(cell -> GridPane.getColumnIndex(cell) == colIndex &&
                        GridPane.getRowIndex(cell) == rowIndex)) {
                    //Déplacez le bloc vers la case de la gridPane
                    gridPane.add(gridPaneCat, colIndex, rowIndex);
                }
            }
            //remplacez le bloc dans la vBox s'il n'a pas été déplacé
            else {
                double[] startPos = (double[]) gridPaneCat.getUserData();
                gridPaneCat.setLayoutX(startPos[0]);
                gridPaneCat.setLayoutY(startPos[1]);
            }
        });

    }


}

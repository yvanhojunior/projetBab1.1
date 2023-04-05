package controller;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LevelLoader {
    private List liste;
    public LevelLoader(String nameFile){
            liste =new ArrayList();
            File file = new File(nameFile);
            try{
                Scanner scanner = new Scanner(file);

                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    String[] coordinates = line.split(" ");
                    for(int i = 0; i<coordinates.length; i++){
                        liste.add(Integer.parseInt(coordinates[i]));
                    }
                    liste.add(-1);


                }
                scanner.close();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }

        }
    public List getListe() {
        return liste;
    }


}

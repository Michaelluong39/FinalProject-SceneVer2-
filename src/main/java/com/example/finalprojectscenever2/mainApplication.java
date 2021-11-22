package com.example.finalprojectscenever2;

import com.example.finalprojectscenever2.model.FileSource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Formatter;

public class mainApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainApplication.class.getResource("carTracker.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 550);
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

        String dirString = "C:\\Users\\Kei Tsubasa\\OneDrive\\Desktop\\CISP401(v2)\\FinalProject-SceneVer2-";
        //String fileString

        final Formatter y;
        File x = new File("C:\\Users\\Kei Tsubasa\\OneDrive\\Desktop\\CISP401(v2)\\FinalProject-SceneVer2-\\fileExample.txt");
            if (x.exists())
                System.out.println(x.getName() + " exists");
            else
                try{
                    y = new Formatter("fileExample.txt");
                    System.out.println("file created");
                }catch(Exception e){
                    e.printStackTrace();
                }
        }

}



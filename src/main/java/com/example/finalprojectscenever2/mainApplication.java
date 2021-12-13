package com.example.finalprojectscenever2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class mainApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainApplication.class.getResource("carTracker.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 550);
        stage.setTitle("Car Revenue Asset Program");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e ->{
                e.consume();
                closeProgram();});

    }

    //override exit program
    public void closeProgram(){
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "Close Program", ButtonType.OK, ButtonType.CANCEL);
        exitAlert.setContentText("Close without saving?");
        exitAlert.initModality(Modality.APPLICATION_MODAL);
        exitAlert.showAndWait();
        if(exitAlert.getResult() == ButtonType.OK){
            Platform.exit();
        }else{
            exitAlert.close();
        }
    }
}



package com.example.finalprojectscenever2.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

 //call code: boolean (variable) = confirmBox.display("(window title)", "(confirmation text)"); returns true or false
public class confirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(150);
        window.setMinHeight(150);
        Label label = new Label();
        label.setText(message);

        //create two buttons
        Button yesButton = new Button("yes");
        Button noButton = new Button("no");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });



        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

        public static void error(String title, String message) {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setMinWidth(150);
            window.setMinHeight(150);
            Label label = new Label();
            label.setText(message);

            //create two buttons
            Button yesButton = new Button("Ok");

            yesButton.setOnAction(e -> {
                answer = true;
                window.close();
            });

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, yesButton);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);
            window.setScene(scene);
            window.showAndWait();

        }


}

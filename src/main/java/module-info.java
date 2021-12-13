module com.example.finalprojectscenever2 {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.example.finalprojectscenever2;
    opens com.example.finalprojectscenever2 to javafx.fxml;
    exports com.example.finalprojectscenever2.model;
    opens com.example.finalprojectscenever2.model to javafx.fxml;
}
/*
package com.example.finalprojectscenever2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.finalprojectscenever2.model.FileSource;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class carController {

    //@FXML
    //private ComboBox<String> cmbDisplay;

    @FXML
    private ComboBox<String> cmbFilter;
/*
    @FXML
    private TableView<Maint> tableMaint;
    public List<Maint> listMaint;





    @FXML
    private TextField addDescription;

    @FXML
    private TableView<?> tableDetails;

    @FXML
    private Label totalAmount;

    @FXML
    ComboBox mainDisplay;

    @FXML
    private void initialize () {
        mainDisplay.setValue("Status");
    //    mainDisplay.setItems(displayOptions);
    }

}

 */
package com.example.finalprojectscenever2;

import com.example.finalprojectscenever2.view.tableData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class carController {

    @FXML
    private TextField addDescription1;

    @FXML
    private TextField addDescription11;

    @FXML
    private TextField addDescription111;

    @FXML
    private TextField addDescription12;

    @FXML
    private TextField addDescription121;

    @FXML
    private TableView<tableData> status;
    @FXML private TableColumn<tableData, String> dateColumn;
    @FXML private TableColumn<tableData, String> descriptionColumn;
    @FXML private TableColumn<tableData, String> costColumn;

    @FXML
    private TableView<?> tableDetails11;

    @FXML
    private TableView<?> tableDetails111;

    @FXML
    private TableView<?> tableDetails12;

    @FXML
    private TableView<?> tableDetails121;

    @FXML
    private Label totalAmount1;

    @FXML
    private Label totalAmount11;

    @FXML
    private Label totalAmount111;

    @FXML
    private Label totalAmount12;

    @FXML
    private Label totalAmount121;


    public void addButtonClick() {
        System.out.println("add Button clicked");
    }

    private void initialize(URL url, ResourceBundle rb) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<tableData, String>("dateColumn"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<tableData, String>("descriptionColumn"));
        costColumn.setCellValueFactory(new PropertyValueFactory<tableData, String>("costColumn"));
        /*
        TableView<tableData> table;
            //Date column

            TableColumn<tableData, String> dateColumn = new TableColumn<>("Date"); //Date = header
            dateColumn.setMinWidth(200); //set width
            dateColumn.setCellValueFactory(new PropertyValueFactory<tableData, String>("date"));

            //Description column
            TableColumn<tableData, String> descriptionColumn = new TableColumn<>("Description"); //Description = header
            descriptionColumn.setMinWidth(100); //set width
            descriptionColumn.setCellValueFactory(new PropertyValueFactory<tableData, String>("description"));


            TableColumn<tableData, Double> costColumn = new TableColumn<>("Cost"); //Cost = header
            costColumn.setMinWidth(50); //set width
            costColumn.setCellValueFactory(new PropertyValueFactory<tableData, Double>("cost"));

            table = new TableView<>();
            table.setItems(viewTable());
            table.getColumns().addAll(dateColumn, descriptionColumn, costColumn);

        }
*/
        public ObservableList<tableData> tableData {
            ObservableList<tableData> tableList = FXCollections.observableArrayList();
            //loop database underneath
            tableList.add(new tableData("12/2/1022", "something1", 10.95)); //date, description, price
            tableList.add(new tableData("12/3/1022", "something2", 10.96));
            tableList.add(new tableData("12/4/1022", "something3", 10.97));
            return tableList;

        }


    }


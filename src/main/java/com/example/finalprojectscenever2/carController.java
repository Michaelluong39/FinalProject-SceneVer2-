package com.example.finalprojectscenever2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class carController implements Initializable {


    @FXML
    private TextField addExpenseAmount;

    @FXML
    private DatePicker addExpenseDate;

    @FXML
    private TextField addExpenseDescription;

    @FXML
    private TextField addLoanAmount;

    @FXML
    private Button addLoanButton;

    @FXML
    private DatePicker addLoanDate;

    @FXML
    private TextField addLoanDescription;

    @FXML
    private TextField addMaintAmount;

    @FXML
    private Button addMaintButton;

    @FXML
    private DatePicker addMaintDate;

    @FXML
    private TextField addMaintDescription;

    @FXML
    private DatePicker addModDate;

    @FXML
    private TextField addModDescription;

    @FXML
    private Button expenseAddButton;

    @FXML
    private TableColumn<?, ?> expenseCost;

    @FXML
    private TableColumn<?, ?> expenseDate;

    @FXML
    private TableColumn<?, ?> expenseDescription;

    @FXML
    private Button expenseRemoveButton;

    @FXML
    private TableView<?> expenseTable;

    @FXML
    private TableColumn<?, ?> loanCost;

    @FXML
    private TableColumn<?, ?> loanDate;

    @FXML
    private TableColumn<?, ?> loanDescription;

    @FXML
    private TableView<?> loanTable;

    @FXML
    private TableColumn<tableData, Double> maintCost;

    @FXML
    private TableColumn<tableData, LocalDate> maintDate;

    @FXML
    private TableColumn<tableData, String> maintDescription;

    @FXML
    private TableView<tableData> maintTable;

    @FXML
    private TableColumn<?, ?> modCost;

    @FXML
    private TableColumn<?, ?> modDate;

    @FXML
    private TableColumn<?, ?> modDescription;

    @FXML
    private TableView<?> modTable;

    @FXML
    private Button removeLoanButton;

    @FXML
    private Button removeMaintButton;

    @FXML
    private Button removeModButton;

    @FXML
    private TableColumn<?, ?> sColumn;

    @FXML
    private TableColumn<?, ?> sCost;

    @FXML
    private TableColumn<?, ?> sDescription;

    @FXML
    private Label sTotalAmount;

    @FXML
    private Button statusRemoveButton;

    @FXML
    private TableView<?> statusTable;

    @FXML
    private Label totalExpenseAmount;

    @FXML
    private Label totalLoanAmount;

    @FXML
    private Label totalMaintAmount;

    @FXML
    private Label totalModAmount;

    public void addButtonClick() {
        System.out.println("add Button clicked");
    }

    public void initialize(URL url, ResourceBundle rb) {
        maintDate.setCellValueFactory(new PropertyValueFactory<tableData, LocalDate>("date"));
        maintDescription.setCellValueFactory(new PropertyValueFactory<tableData, String>("description"));
        maintCost.setCellValueFactory(new PropertyValueFactory<tableData, Double>("cost"));

        //dummy data
        maintTable.setItems(getTableData());
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
*/
    }

    public ObservableList<tableData> getTableData() {
        ObservableList<tableData> randomData = FXCollections.observableArrayList();
        //loop database underneath
        randomData.add(new tableData(LocalDate.of(2017, Month.DECEMBER, 23), "something1", 10.95)); //date, description, price
        randomData.add(new tableData(LocalDate.of(2017, Month.DECEMBER, 24), "something2", 10.96));
        randomData.add(new tableData(LocalDate.of(2017, Month.DECEMBER, 25), "something3", 10.97));
        return randomData;

    }


}



package com.example.finalprojectscenever2;

import com.example.finalprojectscenever2.model.*;
import com.example.finalprojectscenever2.view.confirmBox;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;


public class carController implements Initializable {
    //change directory string when submit
    String dirString = "FileData\\";

    //keep decimal format to ###.##
    DecimalFormat df = new DecimalFormat("###.##");


    @FXML private TextField addExpenseAmount;
    @FXML private DatePicker addExpenseDate;
    @FXML private TextField addExpenseDescription;
    @FXML private TextField addLoanAmount;
    @FXML private Button addLoanButton;
    @FXML private DatePicker addLoanDate;
    @FXML private TextField addLoanDescription;
    @FXML private TextField addMaintAmount;
    @FXML private Button addMaintButton;
    @FXML private DatePicker addMaintDate;
    @FXML private TextField addMaintDescription;
    @FXML private DatePicker addModDate;
    @FXML private TextField addModDescription;
    @FXML private TextField addModAmount;
    @FXML private Button expenseAddButton;
    @FXML private TableColumn<tableExpenseData, Double> expenseCost;
    @FXML private TableColumn<tableExpenseData, LocalDate> expenseDate;
    @FXML private TableColumn<tableExpenseData, String> expenseDescription;
    @FXML private Button expenseRemoveButton;
    @FXML private TableView<tableExpenseData> expenseTable;
    @FXML private Menu fileMenu;
    @FXML private TableColumn<tableExpenseData, Double> loanCost;
    @FXML private TableColumn<tableExpenseData, LocalDate> loanDate;
    @FXML private TableColumn<tableExpenseData, String> loanDescription;
    @FXML private TableView<tableExpenseData> loanTable;
    @FXML private TableColumn<tableExpenseData, Double> maintCost;
    @FXML private TableColumn<tableExpenseData, LocalDate> maintDate;
    @FXML private TableColumn<tableExpenseData, String> maintDescription;
    @FXML private TableView<tableExpenseData> maintTable;
    @FXML private MenuItem menuClose;
    @FXML private MenuItem menuSave;
    @FXML private TableColumn<tableExpenseData, Double> modCost;
    @FXML private TableColumn<tableExpenseData, LocalDate> modDate;
    @FXML private TableColumn<tableExpenseData, String> modDescription;
    @FXML private TableView<tableExpenseData> modTable;
    @FXML private Button removeLoanButton;
    @FXML private Button removeMaintButton;
    @FXML private Button removeModButton;
    @FXML private Label statusExpenseAmount;
    @FXML private Label statusLoanAmount;
    @FXML private Label statusMaintAmount;
    @FXML private Label statusTotalSpent;
    @FXML private Label totalExpenseAmount;
    @FXML private Label totalLoanAmount;
    @FXML private Label totalMaintAmount;
    @FXML private Label totalModAmount;


    public void initialize(URL url, ResourceBundle rb) {
    //check file existence and create if not found
        fileChecker(dirString, "Expense.txt");
        fileChecker(dirString, "Maintenance.txt");
        fileChecker(dirString, "Loan.txt");
        fileChecker(dirString, "Mods.txt");


        //
        //Expense Data
        //
        expenseDate.setCellValueFactory(new PropertyValueFactory<tableExpenseData, LocalDate>("date"));
        expenseDescription.setCellValueFactory(new PropertyValueFactory<tableExpenseData, String>("description"));
        expenseCost.setCellValueFactory(new PropertyValueFactory<tableExpenseData, Double>("cost"));

        //Use for button removal for maintenance table
        expenseTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //allow description cell edits
        expenseTable.setEditable(true);
        expenseDescription.setCellFactory(TextFieldTableCell.forTableColumn());

        //dummy data
        try {
            expenseTable.setItems(FileSource.getTableData("Expense.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //total expense amount set to display
        totalExpenseAmount.setText(FileSource.getSum(expenseTable));


        //
        //Maintenance data
        //
        maintDate.setCellValueFactory(new PropertyValueFactory<tableExpenseData, LocalDate>("date"));
        maintDescription.setCellValueFactory(new PropertyValueFactory<tableExpenseData, String>("description"));
        maintCost.setCellValueFactory(new PropertyValueFactory<tableExpenseData, Double>("cost"));

        //Use for button removal for maintenance table
        maintTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //allow description cell edits
        maintTable.setEditable(true);
        maintDescription.setCellFactory(TextFieldTableCell.forTableColumn());

        //dummy data
        try {
            maintTable.setItems(FileSource.getTableData("Maintenance.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //total maintenance amount set to display
        totalMaintAmount.setText(FileSource.getSum(maintTable));

        //
        //Mod Data
        //
        modDate.setCellValueFactory(new PropertyValueFactory<tableExpenseData, LocalDate>("date"));
        modDescription.setCellValueFactory(new PropertyValueFactory<tableExpenseData, String>("description"));
        modCost.setCellValueFactory(new PropertyValueFactory<tableExpenseData, Double>("cost"));

        //Use for button removal for maintenance table
        modTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //allow description cell edits
        modTable.setEditable(true);
        modDescription.setCellFactory(TextFieldTableCell.forTableColumn());

        //dummy data
        try {
            modTable.setItems(FileSource.getTableData("Mods.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //total mod amount set to display
        totalModAmount.setText(FileSource.getSum(modTable));

        //
        //Loan Data
        //
        loanDate.setCellValueFactory(new PropertyValueFactory<tableExpenseData, LocalDate>("date"));
        loanDescription.setCellValueFactory(new PropertyValueFactory<tableExpenseData, String>("description"));
        loanCost.setCellValueFactory(new PropertyValueFactory<tableExpenseData, Double>("cost"));

        //Use for button removal for maintenance table
        loanTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //allow description cell edits
        loanTable.setEditable(true);
        loanDescription.setCellFactory(TextFieldTableCell.forTableColumn());

        //dummy data
        try {
            loanTable.setItems(FileSource.getTableData("Loan.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //total loan amount set to display
        totalLoanAmount.setText(FileSource.getSum(loanTable));

        //
        //Status Data
        //

        statusTotalSpent.setText(String.valueOf(df.format(Double.parseDouble(FileSource.getSum(expenseTable)) +
                                                            Double.parseDouble(FileSource.getSum(maintTable)) +
                                                            Double.parseDouble(FileSource.getSum(loanTable)))));
        statusExpenseAmount.setText(FileSource.getSum(expenseTable));
        statusMaintAmount.setText(FileSource.getSum(maintTable));
        statusLoanAmount.setText(FileSource.getSum(loanTable));

    }


    //Check if files exists and create if it doesn't
    public void fileChecker(String folder, String file) {
        final Formatter y;
        Path dirPath = Paths.get(folder);
        Path filePath = Paths.get(folder, file);

        File createFolder = new File("FileData");
        if(createFolder.exists())
            System.out.println("Folder: " + createFolder.getName() + " exists...");
            else try{
               createFolder.mkdir();
               System.out.println("Folder " + createFolder.getName() + " created...");
        }catch (Exception e){
                e.printStackTrace();
        }

        File x = new File(folder, file);
        if(x.exists()){
            System.out.println(x.getName()+" exists...");
        } else
            try
            {
                y = new Formatter(x);
                System.out.println(x + " file created.");
            } catch(Exception e)
            {
                e.printStackTrace();
            }
    }


    //
    // Delete button modules
    //
    public void deleteExpenseButtonPushed() {
        boolean x = confirmBox.display("Delete Data", "Are you sure?");
        if(x == true) {
            ObservableList<tableExpenseData> selectedRows, allItems;
            allItems = expenseTable.getItems();

            selectedRows = expenseTable.getSelectionModel().getSelectedItems();

            for (tableExpenseData items : selectedRows) {
                allItems.remove(items);
            }
        }else{}
    }

    public void deleteMaintButtonPushed() {
        boolean x = confirmBox.display("Delete Data", "Are you sure?");
        if(x == true) {
            ObservableList<tableExpenseData> selectedRows, allItems;
            allItems = maintTable.getItems();

            selectedRows = maintTable.getSelectionModel().getSelectedItems();

            for (tableExpenseData items : selectedRows) {
                allItems.remove(items);
            }
        }else{}

    }

    public void deleteModButtonPushed() {
        boolean x = confirmBox.display("Delete Data", "Are you sure?");
        if(x == true) {
            ObservableList<tableExpenseData> selectedRows, allItems;
            allItems = modTable.getItems();

            selectedRows = modTable.getSelectionModel().getSelectedItems();

            for (tableExpenseData items : selectedRows) {
                allItems.remove(items);
            }
        }else{}
    }

    public void deleteLoanButtonPushed() {
        boolean x = confirmBox.display("Delete Data", "Are you sure?");
        if(x == true) {
            ObservableList<tableExpenseData> selectedRows, allItems;
            allItems = loanTable.getItems();

            selectedRows = loanTable.getSelectionModel().getSelectedItems();

            for (tableExpenseData items : selectedRows) {
                allItems.remove(items);
            }
        }else{}
    }

    //
    //add button action to add data
    //
    public void addExpenseButtonClick() {
        double parseCost;
        parseCost = Double.parseDouble(addExpenseAmount.getText()); //convert TextField into Double
        tableExpenseData newData = new tableExpenseData(
                addExpenseDate.getValue(),
                addExpenseDescription.getText(),
                parseCost
        );
        expenseTable.getItems().add(newData);
    }

    public void addMaintButtonClick() {
        double parseCost;
        parseCost = Double.parseDouble(addMaintAmount.getText()); //convert TextField into Double
        tableExpenseData newData = new tableExpenseData(
                addMaintDate.getValue(),
                addMaintDescription.getText(),
                parseCost
        );
        maintTable.getItems().add(newData);
    }

    public void addModButtonClick() {
        double parseCost;
        parseCost = Double.parseDouble(addModAmount.getText()); //convert TextField into Double
        tableExpenseData newData = new tableExpenseData(
                addModDate.getValue(),
                addModDescription.getText(),
                parseCost
        );
        modTable.getItems().add(newData);
    }

    public void addLoanButtonClick() {
        double parseCost;
        parseCost = Double.parseDouble(addLoanAmount.getText()); //convert TextField into Double
        tableExpenseData newData = new tableExpenseData(
                addLoanDate.getValue(),
                addLoanDescription.getText(),
                parseCost
        );
        loanTable.getItems().add(newData);
    }

    //
    // edit table data module
    //
    public void editDescriptionCell(TableColumn.CellEditEvent editedCell) {
        tableExpenseData maintSelect = maintTable.getSelectionModel().getSelectedItem();
        maintSelect.setDescription(editedCell.getNewValue().toString());

        tableExpenseData loanSelect = loanTable.getSelectionModel().getSelectedItem();
        loanSelect.setDescription(editedCell.getNewValue().toString());

        tableExpenseData modSelect = modTable.getSelectionModel().getSelectedItem();
        modSelect.setDescription(editedCell.getNewValue().toString());

        tableExpenseData expenseSelect = expenseTable.getSelectionModel().getSelectedItem();
        expenseSelect.setDescription(editedCell.getNewValue().toString());
    }


    //
    // save modules
    //
    public void saveMenuSelected (ActionEvent event) throws IOException {
        //set alert box to confirm save data
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Data Save Files");
        alert.setResizable(false);
        alert.setContentText("Save Data?");
        Optional<ButtonType> result = alert.showAndWait();

        if(!result.isPresent()){
            //alert exit, no button pressed
            System.out.println("Exit Save");
        }
        //save data when pressing Ok
        else if(result.get() == ButtonType.OK){
            FileSource.saveFile(expenseTable.getItems(), dirString + "\\Expense.txt");
            FileSource.saveFile(maintTable.getItems(), dirString + "\\Maintenance.txt");
            FileSource.saveFile(modTable.getItems(), dirString + "\\Mods.txt");
            FileSource.saveFile(loanTable.getItems(), dirString + "\\Loan.txt");
            System.out.println("Data Saved");
        }
        //cancelled save data
        else if (result.get() == ButtonType.CANCEL){
            System.out.println("Cancelled Save");
        }

    }

    //exit command
    public void closeApp(ActionEvent event){
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "confirm", ButtonType.OK, ButtonType.CANCEL);
        exitAlert.setContentText("Exit?");
        exitAlert.initModality(Modality.APPLICATION_MODAL);
        exitAlert.showAndWait();
        if(exitAlert.getResult() == ButtonType.OK){
            Platform.exit();
        }else{
            exitAlert.close();
        }
    }

}



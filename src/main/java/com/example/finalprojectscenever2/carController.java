package com.example.finalprojectscenever2;

import com.example.finalprojectscenever2.FileSource;
import com.example.finalprojectscenever2.model.tableExpenseData;
import com.example.finalprojectscenever2.model.tableLoanData;
import com.example.finalprojectscenever2.model.tableMaintData;
import com.example.finalprojectscenever2.model.tableModData;
import com.example.finalprojectscenever2.view.confirmBox;
import javafx.application.Platform;
import javafx.collections.FXCollections;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
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
    @FXML private TableColumn<tableLoanData, Double> loanCost;
    @FXML private TableColumn<tableLoanData, LocalDate> loanDate;
    @FXML private TableColumn<tableLoanData, String> loanDescription;
    @FXML private TableView<tableLoanData> loanTable;
    @FXML private TableColumn<tableMaintData, Double> maintCost;
    @FXML private TableColumn<tableMaintData, LocalDate> maintDate;
    @FXML private TableColumn<tableMaintData, String> maintDescription;
    @FXML private TableView<tableMaintData> maintTable;
    @FXML private MenuItem menuClose;
    @FXML private MenuItem menuSave;
    @FXML private TableColumn<tableModData, Double> modCost;
    @FXML private TableColumn<tableModData, LocalDate> modDate;
    @FXML private TableColumn<tableModData, String> modDescription;
    @FXML private TableView<tableModData> modTable;
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
            expenseTable.setItems(getExpenseTableData());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //total expense amount set to display
        totalExpenseAmount.setText(getExpenseSum(expenseCost));


        //
        //Maintenance data
        //
        maintDate.setCellValueFactory(new PropertyValueFactory<tableMaintData, LocalDate>("date"));
        maintDescription.setCellValueFactory(new PropertyValueFactory<tableMaintData, String>("description"));
        maintCost.setCellValueFactory(new PropertyValueFactory<tableMaintData, Double>("cost"));

        //Use for button removal for maintenance table
        maintTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //allow description cell edits
        maintTable.setEditable(true);
        maintDescription.setCellFactory(TextFieldTableCell.forTableColumn());

        //dummy data
        try {
            maintTable.setItems(getMaintTableData());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //total maintenance amount set to display
        totalMaintAmount.setText(getMaintSum(maintCost));

        //
        //Mod Data
        //
        modDate.setCellValueFactory(new PropertyValueFactory<tableModData, LocalDate>("date"));
        modDescription.setCellValueFactory(new PropertyValueFactory<tableModData, String>("description"));
        modCost.setCellValueFactory(new PropertyValueFactory<tableModData, Double>("cost"));

        //Use for button removal for maintenance table
        modTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //allow description cell edits
        modTable.setEditable(true);
        modDescription.setCellFactory(TextFieldTableCell.forTableColumn());

        //dummy data
        try {
            modTable.setItems(getModTableData());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //total mod amount set to display
        totalModAmount.setText(getModSum(modCost));

        //
        //Loan Data
        //
        loanDate.setCellValueFactory(new PropertyValueFactory<tableLoanData, LocalDate>("date"));
        loanDescription.setCellValueFactory(new PropertyValueFactory<tableLoanData, String>("description"));
        loanCost.setCellValueFactory(new PropertyValueFactory<tableLoanData, Double>("cost"));

        //Use for button removal for maintenance table
        loanTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //allow description cell edits
        loanTable.setEditable(true);
        loanDescription.setCellFactory(TextFieldTableCell.forTableColumn());

        //dummy data
        try {
            loanTable.setItems(getLoanTableData());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //total loan amount set to display
        totalLoanAmount.setText(getLoanSum(loanCost));

        //
        //Status Data
        //

        statusTotalSpent.setText(String.valueOf(df.format(Double.parseDouble(getExpenseSum(expenseCost)) +
                                                Double.parseDouble(getMaintSum(maintCost)) +
                                                Double.parseDouble(getLoanSum(loanCost)))));
        statusExpenseAmount.setText(getExpenseSum(expenseCost));
        statusMaintAmount.setText(getMaintSum(maintCost));
        statusLoanAmount.setText(getLoanSum(loanCost));

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
            ObservableList<tableMaintData> selectedRows, allItems;
            allItems = maintTable.getItems();

            selectedRows = maintTable.getSelectionModel().getSelectedItems();

            for (tableMaintData items : selectedRows) {
                allItems.remove(items);
            }
        }else{}

    }

    public void deleteModButtonPushed() {
        boolean x = confirmBox.display("Delete Data", "Are you sure?");
        if(x == true) {
            ObservableList<tableModData> selectedRows, allItems;
            allItems = modTable.getItems();

            selectedRows = modTable.getSelectionModel().getSelectedItems();

            for (tableModData items : selectedRows) {
                allItems.remove(items);
            }
        }else{}
    }

    public void deleteLoanButtonPushed() {
        boolean x = confirmBox.display("Delete Data", "Are you sure?");
        if(x == true) {
            ObservableList<tableLoanData> selectedRows, allItems;
            allItems = loanTable.getItems();

            selectedRows = loanTable.getSelectionModel().getSelectedItems();

            for (tableLoanData items : selectedRows) {
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
        tableMaintData newData = new tableMaintData(
                addMaintDate.getValue(),
                addMaintDescription.getText(),
                parseCost
        );
        maintTable.getItems().add(newData);
    }

    public void addModButtonClick() {
        double parseCost;
        parseCost = Double.parseDouble(addModAmount.getText()); //convert TextField into Double
        tableModData newData = new tableModData(
                addModDate.getValue(),
                addModDescription.getText(),
                parseCost
        );
        modTable.getItems().add(newData);
    }

    public void addLoanButtonClick() {
        double parseCost;
        parseCost = Double.parseDouble(addLoanAmount.getText()); //convert TextField into Double
        tableLoanData newData = new tableLoanData(
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
        tableMaintData maintSelect = maintTable.getSelectionModel().getSelectedItem();
        maintSelect.setDescription(editedCell.getNewValue().toString());

        tableLoanData loanSelect = loanTable.getSelectionModel().getSelectedItem();
        loanSelect.setDescription(editedCell.getNewValue().toString());

        tableModData modSelect = modTable.getSelectionModel().getSelectedItem();
        modSelect.setDescription(editedCell.getNewValue().toString());

        tableExpenseData expenseSelect = expenseTable.getSelectionModel().getSelectedItem();
        expenseSelect.setDescription(editedCell.getNewValue().toString());
    }


    //
    //add data to tables
    //
    public ObservableList<tableExpenseData> getExpenseTableData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader( new File(dirString, "Expense.txt")));
        String line;
        String[] array;
        ObservableList<tableExpenseData> randomData = FXCollections.observableArrayList();

        //loop read data from file
        while((line = br.readLine()) != null){
            array = line.split(";");
            randomData.add(new tableExpenseData(LocalDate.parse(array[0]), array[1], Double.parseDouble(array[2])));
        }
        //randomData.add(new tableExpenseData(LocalDate.of(2017, Month.DECEMBER, 23), "expense1", 1.33)); //date, description, price
        //randomData.add(new tableExpenseData(LocalDate.of(2017, Month.DECEMBER, 24), "expense2", 1.24));
        //randomData.add(new tableExpenseData(LocalDate.of(2017, Month.DECEMBER, 25), "expense3", 1.56));
        return randomData;
    }

    public ObservableList<tableMaintData> getMaintTableData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader( new File(dirString, "Maintenance.txt")));
        String line;
        String[] array;
        ObservableList<tableMaintData> randomData = FXCollections.observableArrayList();

        //loop data read from file
        while((line = br.readLine()) != null){
            array = line.split(";");
            randomData.add(new tableMaintData(LocalDate.parse(array[0]), array[1], Double.parseDouble(array[2])));
        }
        //randomData.add(new tableMaintData(LocalDate.of(2017, Month.DECEMBER, 23), "Maint1", 2.36)); //date, description, price
        //randomData.add(new tableMaintData(LocalDate.of(2017, Month.DECEMBER, 24), "Maint2", 2.63));
        //randomData.add(new tableMaintData(LocalDate.of(2017, Month.DECEMBER, 25), "Maint3", 2.65));
        return randomData;
    }

    public ObservableList<tableModData> getModTableData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader( new File(dirString, "Mods.txt")));
        String line;
        String[] array;
        ObservableList<tableModData> randomData = FXCollections.observableArrayList();

        //loop data read from file
        while((line = br.readLine()) != null){
            array = line.split(";");
            randomData.add(new tableModData(LocalDate.parse(array[0]), array[1], Double.parseDouble(array[2])));
        }
        //randomData.add(new tableModData(LocalDate.of(2017, Month.DECEMBER, 23), "Mod1", 3.63)); //date, description, price
        //randomData.add(new tableModData(LocalDate.of(2017, Month.DECEMBER, 24), "MOd2", 3.56));
        //randomData.add(new tableModData(LocalDate.of(2017, Month.DECEMBER, 25), "mod3", 3.45));
        return randomData;
    }

    public ObservableList<tableLoanData> getLoanTableData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader( new File(dirString, "Loan.txt")));
        String line;
        String[] array;
        ObservableList<tableLoanData> randomData = FXCollections.observableArrayList();

        //loop data read from file
        while((line = br.readLine()) != null){
            array = line.split(";");
            randomData.add(new tableLoanData(LocalDate.parse(array[0]), array[1], Double.parseDouble(array[2])));
        }
        //randomData.add(new tableLoanData(LocalDate.of(2017, Month.DECEMBER, 23), "Loan1", 4.95)); //date, description, price
        //randomData.add(new tableLoanData(LocalDate.of(2017, Month.DECEMBER, 24), "Loan2", 4.96));
        //randomData.add(new tableLoanData(LocalDate.of(2017, Month.DECEMBER, 25), "Loan3", 4.97));
        return randomData;
    }


    //
    // total calculation modules
    //
    public String getExpenseSum(TableColumn<tableExpenseData, Double> expenseCost){
        double result = 0;
        List<String> columnData = new ArrayList<>();
        for (tableExpenseData item : expenseTable.getItems()){
            result += item.getCost();
        }
        return String.valueOf(df.format(result));
    }

    public String getMaintSum(TableColumn<tableMaintData, Double> maintCost){
        double result = 0;
        List<String> columnData = new ArrayList<>();
        for (tableMaintData item : maintTable.getItems()){
            result += item.getCost();
        }
        return String.valueOf(df.format(result));
    }

    public String getModSum(TableColumn<tableModData, Double> modCost){
        double result = 0;
        List<String> columnData = new ArrayList<>();
        for (tableModData item : modTable.getItems()){
            result += item.getCost();
        }
        return String.valueOf(df.format(result));
    }

    public String getLoanSum(TableColumn<tableLoanData, Double> loanCost){
        double result = 0;
        List<String> columnData = new ArrayList<>();
        for (tableLoanData item : loanTable.getItems()){
            result += item.getCost();
        }
        return String.valueOf(df.format(result));
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
            saveExpenseFile(expenseTable.getItems(), dirString + "\\Expense.txt");
            saveMaintFile(maintTable.getItems(), dirString + "\\Maintenance.txt");
            saveModFile(modTable.getItems(), dirString + "\\Mods.txt");
            saveLoanFile(loanTable.getItems(), dirString + "\\Loan.txt");
            System.out.println("Data Saved");
        }
        //cancelled save data
        else if (result.get() == ButtonType.CANCEL){
            System.out.println("Cancelled Save");
        }

    }

    public void saveExpenseFile(ObservableList<tableExpenseData> observableList, String file){
        try {
            BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));
            for (tableExpenseData saveData : observableList){
                outWriter.write(saveData.toString());
                outWriter.newLine();
            }
            System.out.println(observableList);
            outWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveMaintFile(ObservableList<tableMaintData> observableList, String file){
        try {
            BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));
            for (tableMaintData saveData : observableList){
                outWriter.write(saveData.toString());
                outWriter.newLine();
            }
            System.out.println(observableList);
            outWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveModFile(ObservableList<tableModData> observableList, String file){
        try {
            BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));
            for (tableModData saveData : observableList){
                outWriter.write(saveData.toString());
                outWriter.newLine();
            }
            System.out.println(observableList);
            outWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveLoanFile(ObservableList<tableLoanData> observableList, String file){
        try {
            BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));
            for (tableLoanData saveData : observableList){
                outWriter.write(saveData.toString());
                outWriter.newLine();
            }
            System.out.println(observableList);
            outWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //exit command
    public void closeApp(ActionEvent event){
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "confirm", ButtonType.OK, ButtonType.CANCEL);
        //Stage stage = (Stage) fileMenu.getScene().getWindow();
        exitAlert.setContentText("Exit?");
        exitAlert.initModality(Modality.APPLICATION_MODAL);
        //exitAlert.initOwner(stage);
        exitAlert.showAndWait();
        if(exitAlert.getResult() == ButtonType.OK){
            Platform.exit();
        }else{
            exitAlert.close();
        }
    }

}



package com.example.finalprojectscenever2;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;


public class tableData {


    private LocalDate date;
    private SimpleStringProperty description;
    private double cost;
    // TableView<tableData> table;

    public tableData(LocalDate date, String description, double cost) {
        this.date = date;
        this.description = new SimpleStringProperty(description);
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
/*
    public tableData(){
        //set default values
        this.date = "";
        this.description = "";
        this.cost = 0;
    }

    public tableData (String date, String description, double cost) {
        this.date = date;
        this.description = description;
        this.cost = cost;


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

    public ObservableList<tableData> viewTable(){
        ObservableList<tableData> tableList = FXCollections.observableArrayList();
        //loop database underneath
        tableList.add(new tableData("12/2/1022", "something1", 10.95)); //date, description, price
        tableList.add(new tableData("12/3/1022", "something2", 10.96));
        tableList.add(new tableData("12/4/1022", "something3", 10.97));
        return tableList;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double price) {
        this.cost = price;
    }

     */
}

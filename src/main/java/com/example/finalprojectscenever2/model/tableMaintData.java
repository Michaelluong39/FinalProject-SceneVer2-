package com.example.finalprojectscenever2.model;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class tableMaintData {


    private LocalDate date;
    private SimpleStringProperty description;
    private double cost;

    public tableMaintData(LocalDate date, String description, double cost) {
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

    //console printing
    public String toString(){
        return getDate() + ";" + getDescription() + ";" + getCost();
    }

}

package com.example.finalprojectscenever2.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class splitData {
    String description;
    Date date;
    double amount;

    public splitData(Date date, String description, double amount){
        this.date = date;
        this.description = description;
        this.amount = amount;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(this.date);
        //return date;
    }

    public void setDate(Date newDate) {
        this.date = newDate;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double newAmount) {
        this.amount = newAmount;
    }
    @Override
    public String toString(){
        return this.getDate() + ";" +
                this.description + ";" +
                this.amount;

    }



}

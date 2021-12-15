package com.example.finalprojectscenever2.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;

// too late to rename, data handling class, import/export
public class FileSource {
    //Folder directory path
    private static String dirString = "FileData\\";
    // keep decimal format to ###.##
    private static DecimalFormat df = new DecimalFormat("###.##");

    //
    // Module for tables pulling data from files and applying to tables
    //
    public static ObservableList<tableExpenseData> getTableData(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader( new File(dirString, fileName)));
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

    //
    // total calculation modules
    //
    public static String getSum(TableView<tableExpenseData> tableName){
        double result = 0;
        for (tableExpenseData item : tableName.getItems()){
            result += item.getCost();
        }
        return String.valueOf(df.format(result));
    }

    //
    // save file module
    //
    public static void saveFile(ObservableList<tableExpenseData> observableList, String file){
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

}

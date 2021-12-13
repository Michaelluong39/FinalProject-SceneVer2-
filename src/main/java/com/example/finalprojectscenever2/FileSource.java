package com.example.finalprojectscenever2;

import com.example.finalprojectscenever2.model.splitData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//too late to rename, data handling class, import/export
public class FileSource {
/*
   public static List<splitData> loadExpense(String fileName) throws FileNotFoundException, IOException{

        String x = fileName;

        FileReader _file;
        BufferedReader _bufferedReader;
        String _lineRead;
        String[] array;
        List<splitData> listExpense = new ArrayList<>();

        _file = new FileReader(x);
        _bufferedReader = new BufferedReader( _file);
        _lineRead = _bufferedReader.readLine();

        do{
            array = _lineRead.split(";");
            listExpense.add(
                    new splitData(
                        new Date( array[0]),
                                    array[1],
                        Double.parseDouble( array[2])
                    )
            );
            _lineRead = _bufferedReader.readLine();
        }while(_lineRead != null);
        return listExpense;
    }

    //use to calculate expense total
    /*
    public static double totalCalculator(TableColumn<tableExpenseData, Double> expenseData) throws IOException {
        double total = 0;
        String list;
        String[] array;
        List<splitData> amountGrab = new ArrayList<>();
        do{

        }
        for(tableExpenseData data: expenseData){
            total += data.getAmount();
        }
        return total;


    }


     */
    //pull data from txt




/*
    public static List<Maint> loadMaint() throws FileNotFoundException, IOException {

        String maintFile = "maint.txt";
        FileReader mfile;
        BufferedReader bufferedReader;
        String lineRead;
        String[] splitDataMaint;
        List<Maint> listMaint = new ArrayList<>();

        mfile = new FileReader(maintFile);
        bufferedReader = new BufferedReader(mfile);
        lineRead = bufferedReader.readLine();

        do {
            splitDataMaint = lineRead.split(";");
            listMaint.add(
                    new Maint(
                            splitDataMaint[0],
                            new Date(splitDataMaint[1]),
                            splitDataMaint[2],
                            Float.parseFloat(splitDataMaint[3])
                    )
            );
            lineRead = bufferedReader.readLine();
        } while (lineRead != null);

        return listMaint;

    }

 */
}

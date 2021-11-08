package com.example.finalprojectscenever2.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileSource {

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

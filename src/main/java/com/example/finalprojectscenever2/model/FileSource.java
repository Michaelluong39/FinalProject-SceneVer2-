package com.example.finalprojectscenever2.model;

import java.io.*;
import java.util.*;

public class FileSource {
    public static void main(String[] arg) {
        final Formatter y;

        File x = new File("C:\\Users\\Kei Tsubasa\\OneDrive\\Desktop\\CISP401(v2)\\FinalProject-SceneVer2-\\fileExample.txt");
        if (x.exists())

            System.out.println(x.getName() + " exists");
        else
            try{
                y = new Formatter("fileExample.txt");
                System.out.println("file created");
            }catch(Exception e){
                e.printStackTrace();
            }
    }
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

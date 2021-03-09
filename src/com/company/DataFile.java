package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;


public class DataFile {
    /*
    File format
    c100_1-100,
    c200_1-120-1200,
    c300_1-120-30,
    ...
     */
    final static String src = "src\\com\\company\\";
    final static String autoFile = src + "auto.txt";

    public ArrayList<String> readAuto() throws IOException, FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(autoFile));
        String str;
        ArrayList<String> lines = new ArrayList<String>();
        while ((str = reader.readLine()) != null) {
            lines.add(str);
        }

        return  lines;
    }

    public void addMileage(String auto, String mileage) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(autoFile));
        String str;
        ArrayList<String> lines = new ArrayList<String>();
        while ((str = reader.readLine()) != null) {
            String[] tmp = str.split("-");
            if (tmp[0].equals(auto)){
                if(tmp.length <= 2){
                    String mile = tmp[1];
                    if(mile.contains(",")) {//удаляем запятую в пробеге
                        String forMile = mile.substring(0, mile.length() - 1);
                        mile = forMile;
                    }
                    int m = Integer.parseInt(mile) + Integer.parseInt(mileage);
                    lines.add(tmp[0] + "-" + m);
                }
                else{
                    int m = Integer.parseInt(tmp[1]) + Integer.parseInt(mileage);
                    lines.add(tmp[0] + "-" + m + "-" + tmp[2]);
                }
            }
            else lines.add(str);
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(autoFile, false));
        for (int i = 0; i < lines.size(); i++) {
            writer.write(lines.get(i) + "\r\n");
        }
        writer.close();
    }

}

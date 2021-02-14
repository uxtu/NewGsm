package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;


public class DataFile {
    /*
    File format
    c100_1-100,
    c200_1-120-1200,
    c300_1-120-30,
    ...
     */
    final static String path = "C:\\Users\\uxtu\\IdeaProjects\\auto.txt";

    public ArrayList<String> read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String str;
        ArrayList<String> lines = new ArrayList<String>();
        while ((str = reader.readLine()) != null) {
            lines.add(str);
        }

        return  lines;
    }

}

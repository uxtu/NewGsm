package com.company;

import java.util.ArrayList;

public class DataPrepare {

    public void filling(ArrayList<String> out,ArrayList<Cars> a, ArrayList<CarsWithParametrs> b, int type){
        if(type == 0) {
            for (int i = 0; i < out.size(); i++) {
                String[] p = separationParametrs(out.get(i));
                if (p.length <= 3) // кол-во параметров 3(тип без доп параметра)
                    a.add(new Cars(p[0], p[1], p[2]));
                else
                    b.add(new CarsWithParametrs(p[0], p[1], p[2], p[3]));
            }
        }
        else if(type == 100){
            for (int i = 0; i < out.size(); i++) {
                if(out.get(i).contains("c100")){
                    String[] p = separationParametrs(out.get(i));
                    a.add(new Cars(p[0], p[1], p[2]));
                }
            }
        }
        else if(type == 200){
            for (int i = 0; i < out.size(); i++) {
                if(out.get(i).contains("c200")){
                    String[] p = separationParametrs(out.get(i));
                    b.add(new CarsWithParametrs(p[0], p[1], p[2], p[3]));
                }
            }
        }

        else if(type == 300){
            for (int i = 0; i < out.size(); i++) {
                if(out.get(i).contains("c300")){
                    String[] p = separationParametrs(out.get(i));
                    b.add(new CarsWithParametrs(p[0], p[1], p[2], p[3]));
                }
            }
        }

        else if(type == 400){
            for (int i = 0; i < out.size(); i++) {
                if(out.get(i).contains("c400")){
                    String[] p = separationParametrs(out.get(i));
                    b.add(new CarsWithParametrs(p[0], p[1], p[2], p[3]));
                }
            }
        }
        else System.out.println("Invalid type");
    }
    private String[] separationParametrs(String str){
        String[] tmp = str.split("-");
        String type = tmp[0].substring(0,tmp[0].indexOf("_"));
        String num = tmp[0].substring(tmp[0].indexOf("_") + 1);
        String mile = tmp[1];
        String forMile;

        if(mile.contains(",")) {//удаляем запятую в пробеге
            forMile = mile.substring(0, mile.length() - 1);
            mile = forMile;
        }

        if(tmp.length > 2){
            String[] out = new String[4];
            String parametr = tmp[2];
            String forParametr;
            out[0] = type;
            out[1] = num;
            out[2] = mile;
            if(parametr.contains(",")){ //удаляем запятую после параметра (если она есть)
                forParametr = parametr.substring(0, parametr.length() - 1);
                parametr = forParametr;
            }
            out[3] = parametr; // доп параметр
            return out;
        }
        else{
            String[] out = new String[3];
            out[0] = type;
            out[1] = num;
            out[2] = mile;
            return out;
        }
    }
}

package com.company;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class SortOtherCars implements Comparator<CarsWithParametrs> {
    @Override
    public int compare(CarsWithParametrs o1, CarsWithParametrs o2) {
        return Integer.parseInt(o1.mileage) - Integer.parseInt(o2.mileage);
    }
    public TreeSet init(ArrayList<CarsWithParametrs> c,SortOtherCars z){ //заполнение данными
        TreeSet<CarsWithParametrs> t = new TreeSet<CarsWithParametrs>(z);
        for(int i = 0; i < c.size(); i++)
            t.add(new CarsWithParametrs(c.get(i).type, c.get(i).number, c.get(i).mileage, c.get(i).parametr));

        return t;
    }

    public void show(TreeSet<CarsWithParametrs> c){
        for(CarsWithParametrs a : c)
            System.out.println(a.type + " " + a.number + " " + a.mileage + " " + a.parametr);
    }
    public static class SortDescrease extends SortOtherCars implements Comparator<CarsWithParametrs>{
        @Override
        public int compare(CarsWithParametrs o1, CarsWithParametrs o2) {
            return Integer.parseInt(o2.mileage) - Integer.parseInt(o1.mileage);
        }

        public TreeSet init(ArrayList<CarsWithParametrs> c,SortDescrease z){ //заполнение данными
            TreeSet<CarsWithParametrs> t = new TreeSet<CarsWithParametrs>(z);
            for(int i = 0; i < c.size(); i++)
                t.add(new CarsWithParametrs(c.get(i).type, c.get(i).number, c.get(i).mileage, c.get(i).parametr));

            return t;
        }

    }

    public static class SortParametr extends SortOtherCars implements Comparator<CarsWithParametrs>{
        @Override
        public int compare(CarsWithParametrs o1, CarsWithParametrs o2) {
            return Integer.parseInt(o1.parametr) - Integer.parseInt(o2.parametr);
        }

        public TreeSet init(ArrayList<CarsWithParametrs> c,SortParametr z){ //заполнение данными
            TreeSet<CarsWithParametrs> t = new TreeSet<CarsWithParametrs>(z);
            for(int i = 0; i < c.size(); i++)
                t.add(new CarsWithParametrs(c.get(i).type, c.get(i).number, c.get(i).mileage, c.get(i).parametr));

            return t;
        }

    }

    public static class SortParametrDescrease extends SortOtherCars implements Comparator<CarsWithParametrs>{
        @Override
        public int compare(CarsWithParametrs o1, CarsWithParametrs o2) {
            return Integer.parseInt(o2.parametr) - Integer.parseInt(o1.parametr);
        }

        public TreeSet init(ArrayList<CarsWithParametrs> c,SortParametrDescrease z){ //заполнение данными
            TreeSet<CarsWithParametrs> t = new TreeSet<CarsWithParametrs>(z);
            for(int i = 0; i < c.size(); i++)
                t.add(new CarsWithParametrs(c.get(i).type, c.get(i).number, c.get(i).mileage, c.get(i).parametr));

            return t;
        }

    }
}


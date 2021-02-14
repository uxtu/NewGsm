package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class SortCars100 implements Comparator<Cars> { // сортировка пробега по возрастанию

    @Override
    public int compare(Cars o1, Cars o2) {
        return Integer.parseInt(o1.mileage) - Integer.parseInt(o2.mileage);
    }

    public TreeSet init(ArrayList<Cars> c, SortCars100 z){ //заполнение данными
        TreeSet<Cars> t = new TreeSet<Cars>(z);
        for(int i = 0; i < c.size(); i++)
            t.add(new Cars(c.get(i).type, c.get(i).number, c.get(i).mileage));

        return t;
    }

    public void show(TreeSet<Cars> c){
        for(Cars a : c)
            System.out.println(a.type + " " + a.number + " " + a.mileage);
    }

public static class SortDescrease extends SortCars100 implements Comparator<Cars> { // сортировка пробега по убыванию
    @Override
    public int compare(Cars o1, Cars o2) {
        return Integer.parseInt(o2.mileage) - Integer.parseInt(o1.mileage);
    }

    public TreeSet init(ArrayList<Cars> c, SortDescrease z){ //заполнение данными
        TreeSet<Cars> t = new TreeSet<Cars>(z);
        for(int i = 0; i < c.size(); i++)
            t.add(new Cars(c.get(i).type, c.get(i).number, c.get(i).mileage));

        return t;
    }
}
}

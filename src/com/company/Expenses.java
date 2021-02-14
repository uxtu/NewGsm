package com.company;

import java.util.ArrayList;
import java.util.Collections;


public class Expenses {

    final double cost1L_100 = 46.1;
    final double cost1L_200 = 48.9;
    final double cost1L_300 = 47.5;
    final double cost1L_400 = 48.9;

    final double consumption_100 = 12.5;
    final double consumption_200 = 12.0;
    final double consumption_300 = 11.5;
    final double consumption_400 = 20.0;

    final double tariff = 5.0;


    public ArrayList<Double> sumMileage(ArrayList<Cars> d, ArrayList<CarsWithParametrs> c) { // считаем  расходы на каждый тип
        double sum100 = 0.0;
        double sum200 = 0.0;
        double sum300 = 0.0;
        double sum400 = 0.0;

        for (int i = 0; i < d.size(); i++) { // расходы для типа 100
            double a = ((Double.parseDouble(d.get(i).mileage) / 100) * consumption_100);
            sum100 += (a * cost1L_100);
            // System.out.println(Double.parseDouble(d.get(i).mileage) + " " + a + " " + sum100);
        }
        for (int i = 0; i < c.size(); i++) { //расходы для осталных типов авто
            if (c.get(i).type.contains("200"))
                sum200 += (((Double.parseDouble(c.get(i).mileage) / 100) * consumption_200) * cost1L_200);
            else if (c.get(i).type.contains("300"))
                sum300 += (((Double.parseDouble(c.get(i).mileage) / 100) * consumption_300) * cost1L_300);
            else if (c.get(i).type.contains("400"))
                sum400 += (((Double.parseDouble(c.get(i).mileage) / 100) * consumption_400) * cost1L_400);
        }

        // double[] sums = new double[]{sum100, sum200, sum300, sum400};
        ArrayList<Double> s = new ArrayList<>();
        s.add(sum100);
        s.add(sum200);
        s.add(sum300);
        s.add(sum400);
        return s; // массив с расходами на каждый тип
    }

    public double allExpenses(ArrayList<Double> a) { // считаем общие расходы
        double sum = 0.0;
        for (int i = 0; i < a.size(); i++) {
            int y = i; // тип авто
            System.out.println("Type" + (y + 1) * 100 + " = " + a.get(i));
            sum += a.get(i);
        }
        System.out.println("All expenses = " + sum);
        return sum;
    }

    public void min(ArrayList<Double> a) {
        double min = Collections.min(a);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == min) { //для того чтобы вывести расход и тип
                int y = i; // тип авто
                System.out.println("Type" + (y + 1) * 100 + " have min = " + min);
                break;
            }
        }
    }

    public void max(ArrayList<Double> a) {
        double max = Collections.max(a);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == max) { //для того чтобы вывести расход и тип
                int y = i; // тип авто
                System.out.println("Type" + (y + 1) * 100 + " have max = " + max);
                break;
            }
        }
    }



}

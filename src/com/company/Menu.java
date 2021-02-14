package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Menu {
    private void showMenu(){
        System.out.println("---------GSM---------\nВыберите действие:\n" +
                "1. Общее кол-во расходов\n" +
                "2. Тип авто с наибольшим расходом\n" +
                "3. Тип авто с наименьшим расходом\n" +
                "4. Подробнее о определеном типе\n" +
                "0. Выход\n" +
                "Ваш выбор: ");
    }
    private void showSubMenu(boolean t, int  type, String str){
        if(t){
            System.out.print("\nВыберите сортировку для типа " + type + "\n" +
                    "1. По возрастанию пробега\n" +
                    "2. По убыванию пробега\n" +
                    "3. По возрастанию " + str + "\n" +
                    "4. По убыванию " + str + "\n" +
                    "Ваш выбор: ");
        }
        else{
            System.out.print("\nВыберите сортировку по пробегу для типа 100\n" +
                    "1. По возрастанию\n" +
                    "2. По убыванию\n" +
                    "Ваш выбор: ");
        }
    }
    private boolean next(){
        System.out.println("Продолжить работу:\n" +
                "1. Да\n" +
                "0. Нет\n" +
                "Ваш выбор:");
        Scanner in = new Scanner(System.in);
        int exit = in.nextInt();
        boolean ans;
        if(exit == 1) ans = true;
        else ans = false;

        return ans;
    }
    public void show(ArrayList<String> out){
        boolean  ans = true;
        int v;
        while(ans) {
            ArrayList<Cars> c = new ArrayList<>();
            ArrayList<CarsWithParametrs> d = new ArrayList<>();
            showMenu();
            Scanner in = new Scanner(System.in);
            v = in.nextInt();
            if(v == 0){
                System.out.println("Bye bye");
                ans = false;
            }
            else if(v == 1){
                DataPrepare dp = new DataPrepare();
                dp.filling(out, c, d, 0);
                Expenses e = new Expenses();
                ArrayList<Double> typesSums = e.sumMileage(c, d);
                e.allExpenses(typesSums);
            }
            else if(v == 2){
                DataPrepare dp = new DataPrepare();
                dp.filling(out, c, d, 0);
                Expenses e = new Expenses();
                ArrayList<Double> typesSums = e.sumMileage(c, d);
                e.max(typesSums);
            }
            else if(v == 3){
                DataPrepare dp = new DataPrepare();
                dp.filling(out, c, d, 0);
                Expenses e = new Expenses();
                ArrayList<Double> typesSums = e.sumMileage(c, d);
                e.min(typesSums);
            }
            else if(v == 4){
                System.out.print("----------Подбор по параметрам----------\n" +
                        "Введите тип авто(100/200/300/400):");
                int type = 0;
                int sort = 0;
                type = in.nextInt();
                if(type == 100){
                    showSubMenu(false,0,"");
                    sort = in.nextInt();
                    if(sort == 1){
                        DataPrepare dp = new DataPrepare();
                        dp.filling(out, c, d, type);
                        SortCars100 s = new SortCars100();
                        TreeSet<Cars> t = s.init(c, s);
                        s.show(t);
                    }
                    else if(sort == 2){
                        DataPrepare dp = new DataPrepare();
                        dp.filling(out, c, d, type);
                        SortCars100.SortDescrease s = new SortCars100.SortDescrease();
                        TreeSet<Cars> t = s.init(c, s);
                        s.show(t);
                    }
                    else System.out.println("Invalid input");
                }
                if(type == 200 | type == 300 | type == 400){
                    String desc = "";
                    if(type == 200) desc = "объема перевезенного груза";
                    else if(type == 300) desc = "числа перевезенных пассажиров";
                    else if(type == 400) desc = "весу поднятых грузов тонн";
                    showSubMenu(true, type, desc);
                    sort = in.nextInt();
                    if(sort == 1){
                        DataPrepare dp = new DataPrepare();
                        dp.filling(out, c, d, type);
                        SortOtherCars s = new SortOtherCars();
                        TreeSet<CarsWithParametrs> t = s.init(d, s);
                        s.show(t);
                    }
                    else if(sort == 2){
                        DataPrepare dp = new DataPrepare();
                        dp.filling(out, c, d, type);
                        SortOtherCars.SortDescrease s = new SortOtherCars.SortDescrease();
                        TreeSet<CarsWithParametrs> t = s.init(d, s);
                        s.show(t);
                    }
                    else if(sort == 3){
                        DataPrepare dp = new DataPrepare();
                        dp.filling(out, c, d, type);
                        SortOtherCars.SortParametr s = new SortOtherCars.SortParametr();
                        TreeSet<CarsWithParametrs> t = s.init(d, s);
                        s.show(t);
                    }
                    else if(sort == 4){
                        DataPrepare dp = new DataPrepare();
                        dp.filling(out, c, d, type);
                        SortOtherCars.SortParametrDescrease s = new SortOtherCars.SortParametrDescrease();
                        TreeSet<CarsWithParametrs> t = s.init(d, s);
                        s.show(t);
                    }
                    else System.out.println("Invalid input");
                }
            }
            ans = next();
        }
    }
}

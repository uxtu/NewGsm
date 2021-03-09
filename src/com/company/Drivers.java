package com.company;

import java.io.*;
import java.util.ArrayList;

public class Drivers extends DataFile{
    final static String driversList = src + "drivers.txt";
    final static String driversAuto = src + "driversOnAuto.txt";

    public void showDrivers() throws IOException { // вывод списка водителей
        BufferedReader reader = new BufferedReader(new FileReader(driversList));
        String str;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
    }

   /* private int countDrivers() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(driversList));
        String str;
        int cnt = 0;
        while ((str = reader.readLine()) != null) {
            cnt ++;
        }
        return cnt;
    }*/

    private int countWrites() throws IOException { // кол-во строк в файле
        BufferedReader reader = new BufferedReader(new FileReader(driversAuto));
        String str;
        int cnt = 0;
        while ((str = reader.readLine()) != null) {
            cnt ++;
        }
        return cnt;
    }

    public boolean checkDriver(String driver) throws IOException, FileNotFoundException {// проверка водителя на то что он существует
        BufferedReader reader = new BufferedReader(new FileReader(driversList));
        String str;
        boolean check = false;
        while ((str = reader.readLine()) != null) {
            String[] tmp = str.split(" ");
            if(driver.equals(tmp[0])){
                check = true;
            }
        }
        return check;
    }

    public boolean checkAuto(String auto) throws IOException, FileNotFoundException {// проверка авто на то что он есть
        BufferedReader reader = new BufferedReader(new FileReader(autoFile));
        String str;
        boolean check = false;
        while ((str = reader.readLine()) != null) {
            String[] tmp = str.split("-");
            if(auto.equals(tmp[0])){
                check = true;
            }
        }
        return check;
    }

    public boolean checkDriverOnAuto(String name, String auto) throws IOException {// проверка на соответствие водителя и авто при занесении данных в смене
        BufferedReader reader = new BufferedReader(new FileReader(driversAuto));
        String str;
        boolean check = false;
        while ((str = reader.readLine()) != null) {
            String tmp[] = str.split(" ");
            if(tmp[0].equals(name) & tmp[1].equals(auto)) // если водителю принадлежит авто,то ок
                check = true;
        }
        return check;
    }

    public void addDriver(String name) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(driversList,true));
        writer.newLine();
        if(!checkDriver(name)) writer.write(name);
        else writer.write(name + "1"); // если водитель с такой фамилией есть, добавляем к фамилии единицу))
        writer.close();
        System.out.println("Водитель добавлен");

    }

    /*Функция для внесения нового водителя с авто, а также изменения водителя у авто*/
    public void driverToAuto(String name, String auto) throws IOException {
        if (checkDriver(name) & checkAuto(auto)) { // если водитель и авто существуют
            BufferedReader reader = new BufferedReader(new FileReader(driversAuto));
            ArrayList<String> lines = new ArrayList<>();
            String str;
            while ((str = reader.readLine()) != null) {
                String[] tmp = str.split(" ");
                if (!(tmp[0].equals(name) | tmp[1].equals(auto))) { // если нет совпадений заносим данные
                    lines.add(str);
                }
            }

            if (lines.size() == countWrites()) { //если не было совпадений, значит переназначать не надо, просто добавляем в конец файла новую запись
                BufferedWriter writer = new BufferedWriter(new FileWriter(driversAuto, true));
                writer.newLine();
                writer.write(name + " " + auto);
                writer.close();
                System.out.println("Водителю присвоен автомобиль");
            } else { // были переназначения, перезаписываем файл с новой строкой
                lines.add(name + " " + auto); // переназначенное авто
                BufferedWriter writer = new BufferedWriter(new FileWriter(driversAuto, false));
                for (int i = 0; i < lines.size(); i++) {
                    writer.newLine();
                    writer.write(lines.get(i));
                }
                writer.close();
                System.out.println("Водителю присвоен автомобиль");
            }
        }
        else System.out.println("Водитель/автомобиль не найден");
    }
}


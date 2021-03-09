package com.company;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Smena extends DataFile{
    final static String folderSmens ="out\\ShiftLog\\";
    final static int tariff = 5;

    /*Добавление данных в отчет по смене*/
    public void work() throws IOException {
        System.out.println("Введите запись в журнал: ");
        Scanner in = new Scanner(System.in);
        System.out.print("Водитель:");
        String name = in.next();
        System.out.print("Автомобиль:");
        String auto = in.next();
        Drivers d = new Drivers();
        if (d.checkDriverOnAuto(name, auto)) {
            System.out.print("Пробег: ");
            String mileage = in.next();
            String log = folderSmens + new SimpleDateFormat("yyMMdd'.txt'").format(new Date());
            BufferedWriter writer = new BufferedWriter(new FileWriter(log, true));
            writer.write(name + " " + auto + " " + mileage);
            writer.newLine();
            writer.close();
            System.out.println("Запись добавлена.");
            new DataFile().addMileage(auto, mileage);
        }
        else System.out.println("Запись не добавлена(не соответствие водителя и авто)");
    }

    public void showAllSmens(){ // вывод смен
        File folder = new File(folderSmens);
        System.out.println("Список смен:");
        for (File file : Objects.requireNonNull(folder.listFiles()))
        {
            System.out.println(file.getName());
        }
    }

    public void showCurrentSmena(String name) throws IOException { // вывод конкретной смены
        BufferedReader reader;
        try{
            if(name.contains(".txt")) reader = new BufferedReader(new FileReader(folderSmens + name)); // если передали смену в формате 123.txt
            else reader = new BufferedReader(new FileReader(folderSmens + name + ".txt")); // если передали смену в формате 123
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        }catch(FileNotFoundException e){
            System.out.println("Файл не найден");
        }
    }

    public void showSalary(String smena) throws IOException { // вывод расходов для водителей по смене
        File f;
        try {
            if(smena.contains(".txt")) f = new File(folderSmens + smena); // если передали смену в формате 123.txt
            else f = new File(folderSmens + smena + ".txt"); // если передали смену в формате 123
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String str;
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty()) {
                    String tmp[] = str.split(" ");
                    if (tmp.length < 3)
                        System.out.println("Ошибка предоставленных данных"); // Если строка не вида: водитель авто пробег
                    else System.out.println(tmp[0] + " " + Integer.parseInt(tmp[2]) * tariff);
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("Файл не найден");
        }
    }
}


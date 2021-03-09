package com.company;

import javax.sound.midi.Soundbank;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NewMenu extends Menu{
    public void auth() throws IOException {
        System.out.println("---------Авторизация---------");
        System.out.print("Введите логин: ");
        Scanner in = new Scanner(System.in);
        String login = in.next();
        System.out.println();
        System.out.print("Введите пароль: ");
        String pass = in.next();
        if(new Auth().checkUser(login, pass)) {
            //System.out.println("ok");
            if(login.equals("admin")){
                showAdminMenu();
            }
            else{
                showUserMenu();
            }

        }
        else System.out.println("Incorrect login/password");
    }

    private void exit(){
        System.out.print("До свидания!");
        System.exit(0);
    }

    private void showAdminMenu() throws IOException {
        System.out.println("-------Меню администратора-------\n" +
                "1.Добавить оператора\n" +
                "2.Вызвать меню оператора\n" +
                "3.Вызвать меню GSM\n" +
                "4.Смены\n" +
                "5.Добавить водителя\n" +
                "6.Выход из пользователя\n" +
                "7.Выход из приложения");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выбор: ");
        try {
            int ans = in.nextInt();
            if (ans >= 1 & ans <= 7) {
                if (ans == 1) {
                    System.out.println("------Добавление пользователя------");
                    Scanner s = new Scanner(System.in);
                    System.out.print("Введите логин: ");
                    String log = s.next();
                    System.out.print("Введите пароль: ");
                    String pas = s.next();
                    new Auth().addUser(log, pas);
                } else if (ans == 2) showUserMenu();
                else if (ans == 3) new Menu().show(new DataFile().readAuto());
                else if(ans == 4) showSmens();
                else if(ans == 5){
                    System.out.print("Введите фамилию водителя: ");
                    Scanner s = new Scanner(System.in);
                    String name = s.next();
                    new Drivers().addDriver(name);
                }
                else if(ans == 6) auth();
                else exit();
            } else System.out.println("Недопустимая команда");
            showAdminMenu();
        } catch (InputMismatchException e){
            System.out.println("Некорректный ввод");
        }
    }

    private void showUserMenu() throws IOException {
        System.out.println("-------Меню оператора-------\n" +
                "1.Внести данные в смену\n" +
                "2.Вывод списка водителей\n" +
                "3.Переназначить водителя на автомобиль\n" +
                "4.Выход из пользователя\n" +
                "5.Выход из приложения");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выбор: ");
        try {
            int ans = in.nextInt();
            if(ans >= 1 & ans <= 5){
                if(ans == 1) new Smena().work();
                else if(ans == 2) new Drivers().showDrivers();
                else if(ans == 3){
                    Scanner s = new Scanner(System.in);
                    System.out.print("Введите водителя: ");
                    String name = s.next();
                    System.out.print("Введите автомобиль: ");
                    String auto = s.next();
                    new Drivers().driverToAuto(name, auto);
                }
                else if(ans == 4) auth();
                else exit();
            }
            else System.out.println("Недопустимая команда");
            showUserMenu();
        } catch (InputMismatchException e){
            System.out.println("Некорректный ввод");
        }
    }

    private void showSmens(){
        System.out.println("------- Смены --------\n" +
                "1.Посмотреть список смен\n" +
                "2.Вывести информацию по определенной смене\n" +
                "3.Вывести расходы по определенной смене\n" +
                "4.Выход");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выбор: ");
        try {
            int ans = in.nextInt();
            if (ans >= 1 & ans <= 4) {
                if (ans == 1) new Smena().showAllSmens();
                else if (ans == 2){
                    Scanner s = new Scanner(System.in);
                    System.out.print("Введите смену: ");
                    String smena = s.next();
                    new Smena().showCurrentSmena(smena);
                }
                else if (ans == 3){
                    Scanner s = new Scanner(System.in);
                    System.out.print("Введите смену: ");
                    String smena = s.next();
                    new Smena().showSalary(smena);
                }
                else exit();
            } else System.out.println("Недопустимая команда");
            showSmens();
        } catch (InputMismatchException e){
            System.out.println("Некорректный ввод");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

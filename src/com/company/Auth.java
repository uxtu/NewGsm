package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Auth extends DataFile{

    final static String usersFile = src + "users.txt";

    /*Проверка пользователя на авторизации админ = admin/admin123 юзер = tmp/Tmp!123 */
    public boolean checkUser(String login, String password) throws IOException, FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(usersFile));
        String str;
        boolean check = false;
        while ((str = reader.readLine()) != null) {
            String[] tmp = str.split(" ");
            if(login.equals(tmp[0])){ //проверка логина
                String encoded = Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
                if(encoded.equals(tmp[1])) //проверка пароля
                    check = true;
            }
        }
        return check;
    }
    /*Проверка, зарегистрирован ли уже такой пользователь*/
    private boolean checkLogin(String login) throws IOException, FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(usersFile));
        String str;
        boolean check = false;
        while ((str = reader.readLine()) != null) {
            String[] tmp = str.split(" ");
            if(login.equals(tmp[0])){
                check = true;
            }
        }
        return check;
    }

    public void addUser(String login, String password) throws IOException {
        if(!checkLogin(login)){// если такого пользователя нет, то добавляем его
            BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile,true));
            byte[] s = password.getBytes(StandardCharsets.UTF_8);
            String encPassword = Base64.getEncoder().encodeToString(s);
            writer.newLine();
            writer.write(login + " " + encPassword);
            writer.close();
            System.out.println("Пользователь добавлен");
        }
        else System.out.println("Ошибка добавления пользователя(такой логин занят)");
    }
}

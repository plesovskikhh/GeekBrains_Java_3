package ru.GeekBrains.Java_3.lession_2;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



//        1. Создать CRUD операции, 1 метод создани таблицы 2 метод для добавления записи
//           3 метод для получения записи 4 метод для удаления записи 5 удаление таблицы
//        2. Обновить данные в БД из файла (файл приложен test.txt)

public class NewDateBase {

    private static Connection conn;
    private static Statement stnt;

    public static void main(String[] args) {

        try {
            connect();
            DateBase db = new DateBase(stnt);
            try {
                 db.readFile();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
  //              db.createTable();
 //               db.addEntry("Bob", 40);
//                db.deleteEntry(3);
 //               db.deleteTable();
  //              db.infoEntry(2);

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        disconnect();

    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:main.db");
        stnt = conn.createStatement();

    }

    private static void disconnect() {
        try {
            conn.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

package ru.GeekBrains.Java_3.lession_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DateBase {
    private Statement stnt;
    private String tableName;

    public DateBase(Statement stnt) {
        this.stnt = stnt;

    }

    //    * Создаем таблицу
    public void createTable() throws SQLException {
        stnt.executeUpdate("CREATE TABLE IF NOT EXISTS students (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "score INTEGER)");
    }

    //    * Добавляем запись в таблицу
    public void addEntry(String name, Integer score) throws SQLException {
        stnt.executeUpdate("INSERT INTO students (name, score) VALUES (\'" + name + "\', " + score + ");");
    }

    //    * Получаем запись из таблицы по ID
    public void infoEntry(Integer id) throws SQLException {
        ResultSet resultSet = stnt.executeQuery("SELECT * FROM students WHERE id = " + id + ";");
        System.out.println("id = " + resultSet.getString("id") +
                        ", name = " + resultSet.getString("name") +
                        ", score = " + resultSet.getString("score"));
    }


    //    * Удаляем запись из таблицы по ID
    public void deleteEntry(Integer id)  throws SQLException {
        stnt.executeUpdate("DELETE FROM students WHERE id = " + id);
    }

    //    * Удаляем таблицу
    public void deleteTable() throws SQLException{
        stnt.executeUpdate(" DROP TABLE IF EXISTS students;");
    }
    // Читаем файл
    public void readFile() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("text.txt");
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNext()) {
            String[] mass = scanner.nextLine().split(" ");
            try {
                addEntry(mass[1], Integer.parseInt(mass[2]));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

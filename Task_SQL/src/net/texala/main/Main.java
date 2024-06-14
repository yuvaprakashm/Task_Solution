package net.texala.main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.texala.model.Student;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/mymain";
        String user = "root";
        String password = "root";

        List<Student> students = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age")
                ));
            }

            students.stream()    //Convert collection into stream
                    .filter(student -> student.getAge() > 20 && student.getAge() < 35)
                    .forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
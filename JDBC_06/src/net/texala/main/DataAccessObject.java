package net.texala.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccessObject {

	public void selectDataById(Connection connection, int id) throws SQLException {
        System.out.println("Selecting data from the database by ID:");

        String query = "SELECT * FROM student WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
                }
            }
        }

        System.out.println();
    }
	
	public void selectData(Connection connection) throws SQLException {
	    System.out.println("Selecting all data from the database:");

	    String query = "SELECT * FROM student";
	    try (PreparedStatement preparedStatement = connection.prepareStatement(query);
	         ResultSet resultSet = preparedStatement.executeQuery()) {
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String name = resultSet.getString("name");
	            int age = resultSet.getInt("age");
	            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
	        }
	    }

	    System.out.println();
	}

	

	public void insertData(Connection connection, int id, String name, int age) throws SQLException {
	    System.out.println("Inserting data into the database:");

	    String query = "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";
	    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        preparedStatement.setInt(1, id);
	        preparedStatement.setString(2, name);
	        preparedStatement.setInt(3, age);

	        int rowsAffected = preparedStatement.executeUpdate();
	        System.out.println(rowsAffected + " row(s) inserted");
	    }

	    System.out.println();
	}


    public void deleteDataById(Connection connection, int id) throws SQLException {
        System.out.println("Deleting data from the database by ID:");

        String query = "DELETE FROM student WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted");
        }

        System.out.println();
    }
    public boolean isIdExists(Connection connection, int id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE ID = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // If there is a next record, the ID exists
            }
        }
         
    }
    

}

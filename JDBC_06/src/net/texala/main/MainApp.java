/*

DAY : 09
ASSIGNMENT NO : 06

Write a Java program to connect to a database created in MS–ACCESS/SQL–
SERVER/ORACLE using JDBC concept. Perform basic operations of Selection,
Insertion and Deletion on the database. Use DAO Pattern Connection URL and user
name and Password defined in the condict.txt file.

*/
package net.texala.main;

import java.sql.Connection;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            DatabaseConnector dbConnector = new DatabaseConnector();
            DataAccessObject dao = new DataAccessObject();

            Connection connection = dbConnector.connect();

            int userChoice;
            do {
                System.out.println("Choose an option:");
                System.out.println("1. Select Data");
                System.out.println("2. Delete Data");
                System.out.println("3. Insert Data");
                System.out.println("0. Exit");

                try {
                    System.out.print("Enter your choice: ");
                    userChoice = scanner.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                    userChoice = -1;
                }

                switch (userChoice) {
                    case 1:
                        System.out.print("Enter ID to select data: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid ID. Please enter only numbers.");
                            scanner.nextLine();
                            System.out.print("Enter ID to select data: ");
                        }
                        int idToSelect = scanner.nextInt();

                        dao.selectDataById(connection, idToSelect);
                        break;

                    case 2:
                        System.out.print("Enter ID to delete data: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid ID. Please enter only numbers.");
                            scanner.nextLine();
                            System.out.print("Enter ID to delete data: ");
                        }
                        int idToDelete = scanner.nextInt();

                        dao.deleteDataById(connection, idToDelete);
                        break;


                    case 3:
                    	int idToInsert;
                    	boolean idExists;
                    	
                    	do {
                        System.out.print("Enter ID: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid ID. Please enter only numbers.");
                            scanner.nextLine();
                            System.out.print("Enter ID: ");
                        }
                         idToInsert = scanner.nextInt();
                         idExists = dao.isIdExists(connection, idToInsert);
                         if (idExists) {
                             System.out.println("ID already exists. Please choose a different ID.");
                         }
                     } while (idExists);

                        scanner.nextLine();   
                        System.out.print("Enter name: ");
                        String nameToInsert = scanner.nextLine();

                        if (!nameToInsert.matches("[a-zA-Z]+")) {
                            System.out.println("Invalid name. Please enter only alphabets.");
                            continue;
                        }

                        System.out.print("Enter age: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid age. Please enter only numbers.");
                            scanner.nextLine();
                            System.out.print("Enter age: ");
                        }
                        int ageToInsert = scanner.nextInt();

                        dao.insertData(connection, idToInsert, nameToInsert, ageToInsert);
                        dao.selectData(connection);
                        break;


                    case 0:
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }

            } while (userChoice != 0);

            scanner.close();
            dbConnector.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

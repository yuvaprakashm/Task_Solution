package net.texala.employee.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import net.texala.employee.factory.EmployeeFactory;
import net.texala.employee.manager.EmployeeManager;
import net.texala.employee.service.EmployeeOperation;

public class Main {
    public static void main(String[] args) {
        EmployeeFactory factory = new EmployeeFactory();
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display Employee");
            System.out.println("5. Commit Changes");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                EmployeeOperation operation = factory.createEmployeeOperation(choice);
                if (operation != null) {
                    operation.execute(manager, scanner);
                } else if (choice == 6) {
                    exit = true;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}

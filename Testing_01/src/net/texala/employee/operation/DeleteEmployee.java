package net.texala.employee.operation;

import java.util.Scanner;

import net.texala.employee.service.EmployeeOperation;
import net.texala.employee.manager.EmployeeManager;

public class DeleteEmployee implements EmployeeOperation {
    @Override
    public void execute(EmployeeManager manager, Scanner scanner) {
        try {
            System.out.println("1. Delete Specific Employee by EMPID");
            System.out.println("2. Delete All Employees");
            System.out.print("Enter your choice: ");
            int deleteOption = scanner.nextInt();
            scanner.nextLine();

            switch (deleteOption) {
                case 1:
                    System.out.println("Enter EMPID of the employee to delete:");
                    int empIdToDelete = scanner.nextInt();
                    scanner.nextLine();
                    boolean isDeleted = manager.deleteEmployeeById(empIdToDelete);
                    if (isDeleted) {
                        System.out.println("Employee with EMPID " + empIdToDelete + " deleted successfully.");
                    } else {
                        System.out.println("Employee with EMPID " + empIdToDelete + " not found.");
                    }
                    break;
                case 2:
                    manager.deleteAllEmployees();
                    System.out.println("All employees have been deleted.");
                    break;
                default:
                    System.out.println("Invalid option selected.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

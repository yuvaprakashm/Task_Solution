package net.texala.employee.operation;

import java.util.Scanner;

import net.texala.employee.manager.EmployeeManager;
import net.texala.employee.service.EmployeeOperation;

public class AddEmployee implements EmployeeOperation {
    @Override
    public void execute(EmployeeManager manager, Scanner scanner) {
        System.out.println("Enter EMPID:");
        int empId = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();
        
        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();
        
        System.out.println("Enter Department:");
        System.out.println("1. Dev");
        System.out.println("2. Ps");
        System.out.println("3. Qa");
        System.out.println("4. Admin");
        System.out.print("Select Department: ");
        int departmentChoice = scanner.nextInt();
        scanner.nextLine();  
        
        String department;
        switch (departmentChoice) {
            case 1:
                department = "Dev";
                break;
            case 2:
                department = "Ps";
                break;
            case 3:
                department = "Qa";
                break;
            case 4:
                department = "Admin";
                break;
            default:
                System.out.println("Invalid department choice. Defaulting to 'Unknown'.");
                department = "Unknown";
                break;
        }
        
        manager.addEmployee(empId, firstName, lastName, department);
    }
}

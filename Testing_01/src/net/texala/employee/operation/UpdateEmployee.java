package net.texala.employee.operation;

import java.util.Scanner;
import java.util.Vector;

import net.texala.employee.service.EmployeeOperation;
import net.texala.employee.manager.EmployeeManager;
import net.texala.employee.model.Employee;


public class UpdateEmployee implements EmployeeOperation {

    @Override
    public void execute(EmployeeManager manager, Scanner scanner) {
        System.out.println("Enter EMPID of the employee to update:");
        int empIdToUpdate = scanner.nextInt();
        scanner.nextLine();

        Vector<Employee> employeeToUpdate = manager.getEmployeesByEmpId(empIdToUpdate);
        if (employeeToUpdate.isEmpty()) {
            System.out.println("Employee with EMPID " + empIdToUpdate + " not found.");
            return;
        }

        System.out.println("Choose field to update:");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Department");
        System.out.println("4. Update All");
        System.out.print("Select Field: ");
        int fieldChoice = scanner.nextInt();
        scanner.nextLine();
        String fieldToUpdate;
        switch (fieldChoice) {
            case 1:
                fieldToUpdate = "First Name";
                break;
            case 2:
                fieldToUpdate = "Last Name";
                break;
            case 3:
                fieldToUpdate = "Department";
                break;
            case 4:
                fieldToUpdate = "Update All";
                break;
            default:
                System.out.println("Invalid field choice. Defaulting to 'Unknown'.");
                fieldToUpdate = "Unknown";
                return;
        }
        if (!fieldToUpdate.equals("Update All")) {
            if (!fieldToUpdate.equals("Department")) {
                System.out.println("Enter new value:");
                String newValue = scanner.nextLine();
                manager.updateEmployee(empIdToUpdate, fieldToUpdate, newValue);
            } else {
                System.out.println("Enter new department:");
                System.out.println("1. Dev");
                System.out.println("2. Ps");
                System.out.println("3. Qa");
                System.out.println("4. Admin");
                System.out.print("Select Department: ");
                int departmentChoice11 = scanner.nextInt();
                scanner.nextLine();
                String department1;
                switch (departmentChoice11) {
                    case 1:
                        department1 = "Dev";
                        break;
                    case 2:
                        department1 = "Ps";
                        break;
                    case 3:
                        department1 = "Qa";
                        break;
                    case 4:
                        department1 = "Admin";
                        break;
                    default:
                        System.out.println("Invalid department choice. Defaulting to 'Unknown'.");
                        department1 = "Unknown";
                        break;
                }
                manager.updateEmployee(empIdToUpdate, fieldToUpdate, department1);
            }
        } else {
            System.out.println("Enter new values for all fields:");
            System.out.println("Enter new EMPID:");
            int newEmpId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter new First Name:");
            String newFirstName = scanner.nextLine();
            System.out.println("Enter new Last Name:");
            String newLastName = scanner.nextLine();
            System.out.println("Enter new Department:");
            System.out.println("1. Dev");
            System.out.println("2. Ps");
            System.out.println("3. Qa");
            System.out.println("4. Admin");
            System.out.print("Select Department: ");
            int departmentChoice12 = scanner.nextInt();
            scanner.nextLine();
            String newDepartment;
            switch (departmentChoice12) {
                case 1:
                    newDepartment = "Dev";
                    break;
                case 2:
                    newDepartment = "Ps";
                    break;
                case 3:
                    newDepartment = "Qa";
                    break;
                case 4:
                    newDepartment = "Admin";
                    break;
                default:
                    System.out.println("Invalid department choice. Defaulting to 'Unknown'.");
                    newDepartment = "Unknown";
                    break;
            }
            manager.updateEmployee(empIdToUpdate, fieldToUpdate, newEmpId, newFirstName, newLastName,
                    newDepartment);
        }
    }
}

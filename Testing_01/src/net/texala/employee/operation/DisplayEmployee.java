package net.texala.employee.operation;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

import net.texala.employee.service.EmployeeOperation;
import net.texala.employee.manager.EmployeeManager;
import net.texala.employee.model.Employee;
public class DisplayEmployee implements EmployeeOperation {

    @Override
    public void execute(EmployeeManager manager, Scanner scanner) {
        try {
            System.out.println("1. Display All Employees");
            System.out.println("2. Display Employee by EMPID");
            System.out.println("3. Display Sorted Employee Records");
            System.out.print("Enter your choice: ");
            int displayOption = scanner.nextInt();
            scanner.nextLine();
            switch (displayOption) {
                case 1:
                    Vector<Employee> allEmployees = manager.getAllEmployees();
                    if (allEmployees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        System.out.println("EmpId, FirstName, LastName, Department");
                        for (Employee emp : allEmployees) {
                            System.out.println(emp);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter EMPID of the employee to display:");
                    int empIdToDisplay = scanner.nextInt();
                    scanner.nextLine();
                    Vector<Employee> employeesWithSameId = manager.getEmployeesByEmpId(empIdToDisplay);
                    if (employeesWithSameId.isEmpty()) {
                        System.out.println("Employee with EMPID " + empIdToDisplay + " not found.");
                    } else {
                        System.out.println("EmpId, FirstName, LastName, Department");
                        for (Employee emp : employeesWithSameId) {
                            System.out.println(emp);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Sort by:");
                    System.out.println("1. EMPID");
                    System.out.println("2. First Name");
                    System.out.println("3. Last Name");
                    System.out.print("Enter your choice: ");
                    int sortOption = scanner.nextInt();
                    scanner.nextLine();
                    switch (sortOption) {
                        case 1:
                            EmployeeManager.displaySortedEmployeeRecords(manager, Comparator.comparingInt(Employee::getEmpId));
                            break;
                        case 2:
                            EmployeeManager.displaySortedEmployeeRecords(manager, Comparator.comparing(Employee::getFirstName));
                            break;
                        case 3:
                            EmployeeManager.displaySortedEmployeeRecords(manager, Comparator.comparing(Employee::getLastName));
                            break;
                        default:
                            System.out.println("Invalid option selected.");
                            break;
                    }
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

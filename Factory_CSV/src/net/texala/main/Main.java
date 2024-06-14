package net.texala.main;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		EmployeeManager.Fileexists("Allemployee.csv");
		EmployeeManager manager = new EmployeeManager();
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("\n1. Add Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Delete Employee");
			System.out.println("4. Display Employee");
			System.out.println("5. Commit Changes");
			System.out.println("6. Exit");
			System.out.print("\nEnter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
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
				int departmentChoice1 = scanner.nextInt();
				scanner.nextLine();
				String department;
				switch (departmentChoice1) {
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
				break;

			case 2:
				System.out.println("Enter EMPID of the employee to update:");
				int empIdToUpdate = scanner.nextInt();
				scanner.nextLine();
				Vector<Employee> employeeToUpdate = manager.getEmployeesByEmpId(empIdToUpdate);
				if (employeeToUpdate.isEmpty()) {
					System.out.println("Employee with EMPID " + empIdToUpdate + " not found.");
					break;
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
					break;
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
				break;

			case 3:
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
				break;

			case 4:
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

						EmployeeManager.displaySortedEmployeeRecords(manager,
								Comparator.comparingInt(Employee::getEmpId));
						break;
					case 2:

						EmployeeManager.displaySortedEmployeeRecords(manager,
								Comparator.comparing(Employee::getFirstName));
						break;
					case 3:

						EmployeeManager.displaySortedEmployeeRecords(manager,
								Comparator.comparing(Employee::getLastName));
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
				break;

			case 5:
				manager.commitChanges();
				break;
			case 6:
				exit = true;
				System.out.println("Terminating the program...");
				break;
			default:
				System.out.println("Invalid option selected.");
				break;
			}
		}
		scanner.close();
	}

}
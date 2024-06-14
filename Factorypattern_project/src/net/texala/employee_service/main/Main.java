package net.texala.employee_service.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import net.texala.employee_service.File.FileUnits;
import net.texala.employee_service.generateobject.DepartmentFactory;
import net.texala.interface_employee_service.Department;

public class Main {
	private static final String FILE_PATH = "data.csv";

	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) throws IOException {
		FileUnits.ensureFileExists();
		Scanner scanner = new Scanner(System.in);
		DepartmentFactory departmentFactory = new DepartmentFactory();

		boolean continueProgram = true;

		while (continueProgram) {
			System.out.println("Select department:");
			System.out.println("1. Development");
			System.out.println("2. PS");
			System.out.println("3. QA");
			System.out.println("4. Admin");
			System.out.println("5. Exit Program");

			int departmentChoice = getIntInput(scanner, "Enter your choice:");

			if (departmentChoice == 5) {
				System.out.println("Terminating the program.");
				continueProgram = false;
				break;
			}

			Department department = departmentFactory.createDepartment(departmentChoice);

			if (department != null) {
				boolean continueDepartment = true;

				while (continueDepartment) {
					System.out.println("Select operation:");
					System.out.println("1. Register Employee");
					System.out.println("2. Delete Employee");
					System.out.println("3. Update Employee");
					System.out.println("4. Display Employee Details");
					System.out.println("5. Return to Department Selection");

					int operationChoice = getIntInput(scanner, "Enter your choice:");

					switch (operationChoice) {
					case 1:
						registerEmployee(department, scanner);
						break;
					case 2:
						deleteEmployee(department, scanner);
						break;
					case 3:
						updateEmployee(department, scanner);
						break;
					case 4:
						displayEmployeeDetails(department, scanner);
						break;
					case 5:
						System.out.println("Returning to Select Department Selection.");
						continueDepartment = false;
						break;
					default:
						System.out.println("Invalid choice.");
						break;
					}
				}
			} else {
				System.out.println("Invalid department choice.");
			}
		}
	}

	private static int getIntInput(Scanner scanner, String message) {
		int value = 0;
		while (true) {
			try {
				System.out.println(message);
				value = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid number.");
			}
		}
		return value;
	}

	private static void registerEmployee(Department department, Scanner scanner) {
		int id = getIntInput(scanner, "Enter employee ID:");
		String firstName = getStringInput(scanner, "Enter employee first name:");
		String lastName = getStringInput(scanner, "Enter employee last name:");
		String dob = getDateOfBirthInput(scanner);
		int age = getIntInput(scanner, "Enter employee age:");
		String address = getStringInput(scanner, "Enter employee address:");
		try {
			department.registerEmployee(id, firstName, lastName, dob, age, address, department.getDepartmentName());
		} catch (IOException e) {
			System.out.println("Error registering employee: " + e.getMessage());
		}
	}

	private static void deleteEmployee(Department department, Scanner scanner) {
		int id = getIntInput(scanner, "Enter employee ID to delete:");
		try {
			department.deleteEmployee(id);
		} catch (IOException e) {
			System.out.println("Error deleting employee: " + e.getMessage());
		}
	}

	private static void updateEmployee(Department department, Scanner scanner) throws IOException {
		int id = getIntInput(scanner, "Enter employee ID:");
		if (!employeeExists(department, id)) {
			System.out.println("Employee with ID " + id + " does not exist.");
			return;
		}

		String currentDepartment = getCurrentDepartment(department, id);

		boolean continueUpdating = true;
		while (continueUpdating) {
			System.out.println("Select field to update:");
			System.out.println("1. First Name");
			System.out.println("2. Last Name");
			System.out.println("3. Date of Birth");
			System.out.println("4. Age");
			System.out.println("5. Address");
			System.out.println("6. Update all data");
			System.out.println("7. Return to Previous Menu");

			int choice = getIntInput(scanner, "Enter your choice:");

			switch (choice) {
			case 1:
				String firstName = getStringInput(scanner, "Enter new first name:");
				department.updateEmployeeFirstName(id, firstName);
				break;
			case 2:
				String lastName = getStringInput(scanner, "Enter new last name:");
				department.updateEmployeeLastName(id, lastName);
				break;
			case 3:
				String dob = getDateOfBirthInput(scanner);
				department.updateEmployeeDateOfBirth(id, dob);
				break;
			case 4:
				int age = getIntInput(scanner, "Enter new age:");
				department.updateEmployeeAge(id, age);
				break;
			case 5:
				String address = getStringInput(scanner, "Enter new address:");
				department.updateEmployeeAddress(id, address);
				break;
			case 6:
				updateEmployeeAllData(department, scanner, id, currentDepartment);
				break;
			case 7:
				System.out.println("Returning to previous menu.");
				continueUpdating = false;
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		}
	}

	private static String getCurrentDepartment(Department department, int id) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length > 0 && parts[0].equals(String.valueOf(id))) {
					return parts[6];
				}
			}
		}
		return null;
	}

	private static void updateEmployeeAllData(Department department, Scanner scanner, int id, String currentDepartment)
			throws IOException {
		System.out.println("Updating all employee data:");
		String firstName = getStringInput(scanner, "Enter new first name:");
		String lastName = getStringInput(scanner, "Enter new last name:");
		String dob = getDateOfBirthInput(scanner);
		int age = getIntInput(scanner, "Enter new age:");
		String address = getStringInput(scanner, "Enter new address:");

		department.updateEmployee(id, firstName, lastName, dob, age, address, currentDepartment);
		System.out.println("Employee data updated.");
	}

	private static void displayEmployeeDetails(Department department, Scanner scanner) throws IOException {
		System.out.println("Select display option:");
		System.out.println("1. Display All Employees");
		System.out.println("2. Display Employee by ID");
		System.out.println("3. Display Employee by Department Name");

		int displayChoice = getIntInput(scanner, "Enter your choice:");

		switch (displayChoice) {
		case 1:
			try {
				department.displayEmployeeDetails();
			} catch (IOException e) {
				System.out.println("Error displaying employee details: " + e.getMessage());
			}
			break;
		case 2:
			int id = getIntInput(scanner, "Enter employee ID to display:");
			try {
				department.displayEmployeeDetailsById(id);
			} catch (IOException e) {
				System.out.println("Error displaying employee details: " + e.getMessage());
			}
			break;
		case 3:
			displayDepartmentMenu();

			int departmentChoice = getIntInput(scanner, "Enter department choice:");

			String departmentName;
			switch (departmentChoice) {
			case 1:
				departmentName = "Development";
				break;
			case 2:
				departmentName = "PS";
				break;
			case 3:
				departmentName = "QA";
				break;
			case 4:
				departmentName = "Admin";
				break;
			default:
				System.out.println("Invalid department choice.");
				return;
			}

			try {
				department.displayEmployeeDetailsByDepartmentName(departmentName);
			} catch (IOException e) {
				System.out.println("Error displaying employee details: " + e.getMessage());
			}
			break;
		default:
			System.out.println("Invalid choice.");
			break;
		}
	}

	private static void displayDepartmentMenu() {
		System.out.println("Select department:");
		System.out.println("1. Development");
		System.out.println("2. PS");
		System.out.println("3. QA");
		System.out.println("4. Admin");
	}

	public static String displayEmployeeDetailsByDepartmentName(String departmentName) throws IOException {
		boolean columnNamesPrinted = false;
		boolean employeesFound = false;
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length > 6 && parts[6].trim().equalsIgnoreCase(departmentName.trim())) {
					if (!columnNamesPrinted) {
						System.out.println(line);
						columnNamesPrinted = true;
					} else {
						System.out.println(line);
					}
					employeesFound = true;
				}
			}
		}
		if (!employeesFound) {
			System.out.println("No employees found in the department: " + departmentName);
		}
		return departmentName;
	}

	private static String getStringInput(Scanner scanner, String message) {
		String value = "";
		while (true) {
			System.out.println(message);
			value = scanner.nextLine().trim();
			if (!value.isEmpty()) {
				break;
			} else {
				System.out.println("Invalid input. Please enter a non-empty string.");
			}
		}
		return value;
	}

	private static String getDateOfBirthInput(Scanner scanner) {
		while (true) {
			try {
				System.out.println("Enter employee date of birth (DD/MM/YYYY):");
				String dobInput = scanner.nextLine().trim();
				if (dobInput.isEmpty()) {
					return "";
				}
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd-MM-yyyy][dd/MM/yyyy]");
				LocalDate dob = LocalDate.parse(dobInput, formatter);
				return dob.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private static boolean employeeExists(Department department, int id) {
		try {
			return department.employeeExists(id);
		} catch (IOException e) {
			System.out.println("Error checking if employee exists: " + e.getMessage());
			return false;
		}
	}
}

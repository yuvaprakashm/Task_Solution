package net.texala.employee_service.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import net.texala.interface_employee_service.Department;

public class admin implements Department {

	private static final String FILE_PATH = "data.csv";
	private static boolean columnNamesWritten = false;

	static {
		try {
			writeColumnNamesIfNotWritten();
		} catch (IOException e) {
			System.out.println("Error writing column names: " + e.getMessage());
		}
	}

	public admin() {
		ensureFileExists();
		try {
			writeColumnNames();
		} catch (IOException e) {
			System.err.println("Error writing column names: " + e.getMessage());
		}
	}

	private void ensureFileExists() {
		File file = new File(FILE_PATH);
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("File created: " + FILE_PATH);
			}
		} catch (IOException e) {
			System.err.println("Error creating file: " + e.getMessage());
		}
	}

	private static boolean fileContainsColumnNames() throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String firstLine = reader.readLine();
			return firstLine != null
					&& firstLine.equals("ID,First Name,Last Name,Date of Birth,Age,Address,Department");
		}
	}

	private static void writeColumnNamesIfNotWritten() throws IOException {
		if (!columnNamesWritten) {
			writeColumnNames();
			columnNamesWritten = true;
		}
	}

	private static void writeColumnNames() throws IOException {
		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
			if (!fileContainsColumnNames()) {
				writer.println("ID,First Name,Last Name,Date of Birth,Age,Address,Department");
				columnNamesWritten = true;
			}
		}
	}

	@Override
	public String getDepartmentName() {
		return "ADMIN";
	}

	@Override
	public void registerEmployee(int id, String firstName, String lastName, String dob, int age, String address,
			String departmentName) throws IOException {

		if (employeeExists(id)) {
			System.out.println("Employee with ID " + id + " already exists. Please choose a different ID.");
			return;
		}
		Date dateOfBirth = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dateOfBirth = sdf.parse(dob);
		} catch (java.text.ParseException e) {
			System.out.println("Error parsing Date of Birth: " + e.getMessage());
			return;
		}

		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
			if (!columnNamesWritten) {
				writer.write("ID,First Name,Last Name,Date of Birth,Age,Address,Department\n");
				columnNamesWritten = true;
			}

			writer.write(id + "," + firstName + "," + lastName + "," + dob + "," + age + "," + address + ","
					+ departmentName + "\n");
		}
		System.out.println("Employee registered:");
		System.out.println("ID: " + id);
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Date of Birth: " + dob);
		System.out.println("Age: " + age);
		System.out.println("Address: " + address);
		System.out.println("Department: " + departmentName);
	}

	@Override
	public void updateEmployee(int id, String firstName, String lastName, String dob, int age, String address)
			throws IOException {
		Date dateOfBirth = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dateOfBirth = sdf.parse(dob);
		} catch (java.text.ParseException e) {
			System.out.println("Error parsing Date of Birth: " + e.getMessage());
			return;
		}
		String departmentName = getDepartmentName();
		List<String> updatedEmployees = new ArrayList<>();

		boolean found = false;

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length > 0 && parts[0].equals(String.valueOf(id))) {
					found = true;
					String updatedLine = id + "," + firstName + "," + lastName + "," + dob + "," + age + "," + address
							+ "," + departmentName;
					updatedEmployees.add(updatedLine);
				} else {
					updatedEmployees.add(line);
				}
			}

			if (!found) {
				System.out.println("Employee with ID " + id + " does not exist. Cannot update.");
				return;
			}
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (String updatedLine : updatedEmployees) {
				writer.write(updatedLine);
				writer.newLine();
			}
		}

		System.out.println("Employee updated:");
		System.out.println("ID: " + id);
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Date of Birth: " + dob);
		System.out.println("Age: " + age);
		System.out.println("Address: " + address);
		System.out.println("Department: " + departmentName);
	}

	@Override
	public void deleteEmployee(int employeeId) throws IOException {
		File inputFile = new File(FILE_PATH);
		StringBuilder content = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String line;
			boolean deleted = false;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith(employeeId + ",")) {
					deleted = true;
					continue;
				}
				content.append(line).append("\n");
			}

			if (!deleted) {
				System.out.println("Employee with ID " + employeeId + " not found.");
				return;
			}

			try (FileWriter writer = new FileWriter(inputFile)) {
				writer.write(content.toString());
			}
		}

		System.out.println("Employee with ID " + employeeId + " deleted from the records.");
	}

	@Override
	public void displayEmployeeDetails() throws IOException {
		boolean columnNamesPrinted = false;
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (!columnNamesPrinted && line.equals("ID,First Name,Last Name,Date of Birth,Age,Address")) {

					System.out.println(line);
					columnNamesPrinted = true;
				} else if (!line.equals("ID,First Name,Last Name,Date of Birth,Age,Address")) {

					System.out.println(line);
				}
			}
		}
	}

	@Override
	public void displayEmployeeDetailsById(int employeeId) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			boolean found = false;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length > 0 && parts[0].equals(String.valueOf(employeeId))) {
					System.out.println(line);
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("Employee with ID " + employeeId + " not found.");
			}
		}
	}

	public boolean employeeExists(int id) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith(id + ",")) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void displayEmployeeDetailsByDepartmentName(String departmentName) throws IOException {
		if (departmentName.isEmpty()) {
			System.out.println("Department name cannot be empty.");
			return;
		}

		boolean columnNamesPrinted = false;
		boolean employeesFound = false;

		String departmentNameLowerCase = departmentName.toLowerCase();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");

				if (parts.length > 6 && parts[6].trim().toLowerCase().equals(departmentNameLowerCase)) {
					if (!columnNamesPrinted) {
						System.out.println("ID,First Name,Last Name,Date of Birth,Age,Address,Department");
						columnNamesPrinted = true;
					}
					System.out.println(line);
					employeesFound = true;
				}
			}
		}
		if (!employeesFound) {
			System.out.println("No employees found in the department: " + departmentName);
		}
	}

	private static void updateEmployeeFirstName(Department department, Scanner scanner) {
		int id = getIntInput(scanner, "Enter employee ID:");
		if (!employeeExists(department, id)) {
			System.out.println("Employee with ID " + id + " does not exist.");
			return;
		}
		String firstName = getStringInput(scanner, "Enter new first name:");
		try {
			department.updateEmployeeFirstName(id, firstName);
		} catch (IOException e) {
			System.out.println("Error updating employee first name: " + e.getMessage());
		}
	}

	private static void updateEmployeeLastName(Department department, Scanner scanner) {
		int id = getIntInput(scanner, "Enter employee ID:");
		if (!employeeExists(department, id)) {
			System.out.println("Employee with ID " + id + " does not exist.");
			return;
		}
		String lastName = getStringInput(scanner, "Enter new last name:");
		try {
			department.updateEmployeeLastName(id, lastName);
		} catch (IOException e) {
			System.out.println("Error updating employee last name: " + e.getMessage());
		}
	}

	private static String getStringInput(Scanner scanner, String message) {
		System.out.println(message);
		return scanner.nextLine();
	}

	private static void updateEmployeeDateOfBirth(Department department, Scanner scanner) {
		int id = getIntInput(scanner, "Enter employee ID:");
		if (!employeeExists(department, id)) {
			System.out.println("Employee with ID " + id + " does not exist.");
			return;
		}
		String dob = getDateOfBirthInput(scanner);
		try {
			department.updateEmployeeDateOfBirth(id, dob);
		} catch (IOException e) {
			System.out.println("Error updating employee date of birth: " + e.getMessage());
		}
	}

	private static String getDateOfBirthInput(Scanner scanner) {
		System.out.println("Enter date of birth (dd/MM/yyyy): ");
		return scanner.nextLine();

	}

	private static boolean employeeExists(Department department, int id) {
		try {
			return department.employeeExists(id);
		} catch (IOException e) {
			System.out.println("Error checking employee existence: " + e.getMessage());
			return false;
		}
	}

	private static void updateEmployeeAge(Department department, Scanner scanner) {
		int id = getIntInput(scanner, "Enter employee ID:");
		if (!employeeExists(department, id)) {
			System.out.println("Employee with ID " + id + " does not exist.");
			return;
		}
		int age = getIntInput(scanner, "Enter new age:");
		try {
			department.updateEmployeeAge(id, age);
		} catch (IOException e) {
			System.out.println("Error updating employee age: " + e.getMessage());
		}
	}

	private static void updateEmployeeAddress(Department department, Scanner scanner) {
		int id = getIntInput(scanner, "Enter employee ID:");
		if (!employeeExists(department, id)) {
			System.out.println("Employee with ID " + id + " does not exist.");
			return;
		}
		String address = getStringInput(scanner, "Enter new address:");
		try {
			department.updateEmployeeAddress(id, address);
		} catch (IOException e) {
			System.out.println("Error updating employee address: " + e.getMessage());
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

	@Override
	public void updateEmployeeFirstName(int id, String firstName) throws IOException {
		updateEmployeeField(id, 1, firstName);
	}

	@Override
	public void updateEmployeeLastName(int id, String lastName) throws IOException {
		updateEmployeeField(id, 2, lastName);
	}

	@Override
	public void updateEmployeeDateOfBirth(int id, String dob) throws IOException {
		updateEmployeeField(id, 3, dob);
	}

	@Override
	public void updateEmployeeAge(int id, int age) throws IOException {
		updateEmployeeField(id, 4, String.valueOf(age));
	}

	@Override
	public void updateEmployeeAddress(int id, String address) throws IOException {
		updateEmployeeField(id, 5, address);
	}

	private void updateEmployeeField(int id, int fieldIndex, String value) throws IOException {
		String departmentName = getDepartmentName();
		List<String> updatedEmployees = new ArrayList<>();
		boolean found = false;

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length > 0 && parts[0].equals(String.valueOf(id))) {
					found = true;
					parts[fieldIndex] = value;
					line = String.join(",", parts);
				}
				updatedEmployees.add(line);
			}

			if (!found) {
				System.out.println("Employee with ID " + id + " does not exist. Cannot update.");
				return;
			}
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (String updatedLine : updatedEmployees) {
				writer.write(updatedLine);
				writer.newLine();
			}
		}

		System.out.println("Employee with ID " + id + " updated.");
	}

	@Override
	public void updateEmployee(int id, String firstName, String lastName, String dob, int age, String address,
			String currentDepartment) throws IOException {
		Date dateOfBirth = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dateOfBirth = sdf.parse(dob);
		} catch (java.text.ParseException e) {
			System.out.println("Error parsing Date of Birth: " + e.getMessage());
			return;
		}

		List<String> updatedEmployees = new ArrayList<>();
		boolean found = false;

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length > 0 && parts[0].equals(String.valueOf(id))) {
					found = true;
					String updatedLine = id + "," + firstName + "," + lastName + "," + dob + "," + age + "," + address
							+ "," + currentDepartment;
					updatedEmployees.add(updatedLine);
				} else {
					updatedEmployees.add(line);
				}
			}

			if (!found) {
				System.out.println("Employee with ID " + id + " does not exist. Cannot update.");
				return;
			}
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (String updatedLine : updatedEmployees) {
				writer.write(updatedLine);
				writer.newLine();
			}
		}

		System.out.println("Employee with ID " + id + " updated.");
	}
}

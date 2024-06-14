package net.texala.employee.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import net.texala.employee.model.Employee;

public class EmployeeManager {
	private static final String FILE_NAME = "Allemployee.csv";
	private static final String ERROR_LOG_FILE = "error_log.csv";
	private static final String HEADER = "EMPID,First Name,Last Name,Department\n";
	private Vector<Employee> employee;

	public EmployeeManager() {
		employee = new Vector<>();
		loadDataFromCSV();
	}

	private void loadDataFromCSV() {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			boolean headerSkipped = false;
			while ((line = reader.readLine()) != null) {
				if (!headerSkipped) {
					headerSkipped = true;
					continue;
				}
				String[] parts = line.split(",");
				if (parts.length == 4) {
					int empId = Integer.parseInt(parts[0]);
					String firstName = parts[1];
					String lastName = parts[2];
					String department = parts[3];
					employee.add(new Employee(empId, firstName, lastName, department));
				}
			}
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error loading data from CSV: " + e.getMessage());
		}
	}

	public void addEmployee(int empId, String firstName, String lastName, String department) {
		if (!isValidName(firstName) && !isValidName(lastName)) {
			System.out.println("Error:First Name & Last name should contain only alphabetic characters.");
			logError("Invalid firstname & last name : " + firstName + lastName);
			return;
		}
		if (!isValidName(firstName)) {
			System.out.println("Error: First name should contain only alphabetic characters.");
			logError("Invalid first name format - First name: " + firstName);
			return;
		}

		if (!isValidName(lastName)) {
			System.out.println("Error: Last name should contain only alphabetic characters.");
			logError("Invalid last name format - Last name: " + lastName);
			return;
		}

		if (isDuplicateEmpId(empId)) {
			System.out.println("Error: Employee with EMPID " + empId + " already exists.");
			logError("Duplicate EMPID found: " + empId);
			return;
		}

		employee.add(new Employee(empId, firstName, lastName, department));
	}

	private boolean isValidName(String name) {
		return name.matches("[a-zA-Z]+");
	}

	private boolean isDuplicateEmpId(int empId) {
		for (Employee employee : employee) {
			if (employee.getEmpId() == empId) {
				return true;
			}
		}
		return false;
	}

	private void logError(String errorMessage) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ERROR_LOG_FILE, true))) {
			writer.write(errorMessage + "\n");
		} catch (IOException e) {
			System.out.println("Error writing to error log: " + e.getMessage());
		}
	}

	public void updateEmployee(int empIdToUpdate, String fieldToUpdate, int newEmpId, String newFirstName,
			String newLastName, String newDepartment) {
		for (Employee employee : employee) {
			if (employee.getEmpId() == empIdToUpdate) {
				employee.setEmpId(newEmpId);
				employee.setFirstName(newFirstName);
				employee.setLastName(newLastName);
				employee.setDepartment(newDepartment);
				System.out.println("Employee details updated successfully.");
				return;
			}
		}
		System.out.println("Employee not found.");
	}

	public void deleteEmployees(int empIdToDelete) {
		if (empIdToDelete != 0) {
			boolean deleted = deleteEmployeeById(empIdToDelete);
			if (deleted) {
				System.out.println("Employee with EMPID " + empIdToDelete + " deleted successfully.");
			} else {
				System.out.println("Employee with EMPID " + empIdToDelete + " not found.");
			}
		} else {
			employee.clear();

		}
	}

	public boolean deleteEmployeeById(int empIdToDelete) {
		Iterator<Employee> iterator = employee.iterator();
		while (iterator.hasNext()) {
			Employee emp = iterator.next();
			if (emp.getEmpId() == empIdToDelete) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public void commitChanges() {
		try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
			fileWriter.write(HEADER);
			for (Employee employee : employee) {
				fileWriter.write(employee.getEmpId() + "," + employee.getFirstName() + "," + employee.getLastName()
						+ "," + employee.getDepartment() + "\n");
			}
			System.out.println("Changes committed to CSV.");
		} catch (IOException e) {
			System.out.println("Error committing changes: " + e.getMessage());
		}
	}

	public Vector<Employee> getAllEmployees() {
		return employee;
	}

	public Vector<Employee> getEmployeesByEmpId(int empId) {
		Vector<Employee> employeesWithSameId = new Vector<>();
		for (Employee emp : employee) {
			if (emp.getEmpId() == empId) {
				employeesWithSameId.add(emp);
			}
		}
		return employeesWithSameId;
	}

	public void deleteAllEmployees() {
		employee.clear();

	}

	public static void displaySortedEmployeeRecords(EmployeeManager manager) {
		Vector<Employee> sortedEmployees = new Vector<>(manager.getAllEmployees());
		Collections.sort(sortedEmployees, Comparator.comparingInt(Employee::getEmpId));
		if (sortedEmployees.isEmpty()) {
			System.out.println("No employees found.");
		} else {
			System.out.println("EmpId, FirstName, LastName, Department");
			for (Employee emp : sortedEmployees) {
				System.out.println(emp);
			}

			storeSortedRecordsInCSV(sortedEmployees);
		}
	}

	private static void storeSortedRecordsInCSV(Vector<Employee> employees) {
		String sortedFileName = "SortedEmployeeRecords.csv";
		try (FileWriter fileWriter = new FileWriter(sortedFileName)) {
			fileWriter.write("EmpId,FirstName,LastName,Department\n");
			for (Employee emp : employees) {
				fileWriter.write(emp.getEmpId() + "," + emp.getFirstName() + "," + emp.getLastName() + ","
						+ emp.getDepartment() + "\n");
			}
			System.out.println("Sorted employee records stored in " + sortedFileName);
		} catch (IOException e) {
			System.out.println("Error storing sorted records: " + e.getMessage());
		}
	}

	public static void displaySortedEmployeeRecords(EmployeeManager manager, Comparator<Employee> comparator) {
		List<Employee> sortedEmployees = manager.getAllEmployees();
		Collections.sort(sortedEmployees, comparator);
		if (sortedEmployees.isEmpty()) {
			System.out.println("No employees found.");
		} else {
			System.out.println("EmpId, FirstName, LastName, Department");
			for (Employee emp : sortedEmployees) {
				System.out.println(emp);
			}

			storeSortedRecordsInCSV(sortedEmployees);
		}
	}

	private static void storeSortedRecordsInCSV(List<Employee> sortedEmployees) {
		String csvFileName = "Sorted_EmployeeRecords.csv";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileName))) {

			writer.write("EmpId,FirstName,LastName,Department");
			writer.newLine();

			for (Employee emp : sortedEmployees) {
				writer.write(emp.getEmpId() + "," + emp.getFirstName() + "," + emp.getLastName() + ","
						+ emp.getDepartment());
				writer.newLine();
			}

			System.out.println("Sorted employee records stored in " + csvFileName);
		} catch (IOException e) {
			System.err.println("An error occurred while writing sorted records to CSV: " + e.getMessage());
		}
	}

	static void Fileexists(String filename) {
		File file = new File(filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("File '" + filename + "' created successfully.");
			} catch (IOException e) {
				System.err.println("An error occurred while creating the file: " + e.getMessage());
			}
		}
	}

	public void updateEmployee(int empIdToUpdate, String fieldToUpdate, String newValue) {
		boolean employeeFound = false;
		for (Employee employee : employee) {
			if (employee.getEmpId() == empIdToUpdate) {
				switch (fieldToUpdate.toLowerCase()) {
				case "first name":
					employee.setFirstName(newValue);
					break;
				case "last name":
					employee.setLastName(newValue);
					break;
				case "department":
					employee.setDepartment(newValue);
					break;
				default:
					throw new IllegalArgumentException("Invalid field to update: " + fieldToUpdate);
				}
				System.out.println("Employee details updated successfully.");
				employeeFound = true;
				break;
			}
		}
		if (!employeeFound) {
			throw new IllegalArgumentException("Employee not found with EMPID: " + empIdToUpdate);
		}
	}

}
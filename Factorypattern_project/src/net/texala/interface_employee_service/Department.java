package net.texala.interface_employee_service;

import java.io.IOException;

public interface Department {
	void registerEmployee(int id, String firstName, String lastName, String dob, int age, String address,
			String departmentName) throws IOException;

	void deleteEmployee(int employeeId) throws IOException;

	void updateEmployee(int id, String firstName, String lastName, String dob, int age, String address,
			String currentDepartment) throws IOException;

	void displayEmployeeDetailsById(int employeeId) throws IOException;

	void displayEmployeeDetails() throws IOException;

	boolean employeeExists(int id) throws IOException;

	String getDepartmentName();

	void displayEmployeeDetailsByDepartmentName(String departmentName) throws IOException;

	void updateEmployeeFirstName(int id, String firstName) throws IOException;

	void updateEmployeeDateOfBirth(int id, String dob) throws IOException;

	void updateEmployeeLastName(int id, String lastName) throws IOException;

	void updateEmployeeAge(int id, int age) throws IOException;

	void updateEmployeeAddress(int id, String address) throws IOException;

	void updateEmployee(int id, String firstName, String lastName, String dob, int age, String address) throws IOException;

}

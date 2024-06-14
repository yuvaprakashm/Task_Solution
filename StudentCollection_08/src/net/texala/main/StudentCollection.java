/*

DAY : 8
ASSIGNMENT NO : 07

Write a program in Java to add, update and delete the record of a Student from a
collection.
Student class contains name, id, course, and age. All the operation are done by user
on the command prompt. When user will commit, collection will be updated in
student.txt. Moreover, collection is stored in student.txt file.

*/

package net.texala.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentCollection {
	private static List<Student> studentList = new ArrayList<>();
	private static final String FILE_NAME = "student.txt";

	public static void main(String[] args) {
		loadStudentData();

		Scanner scanner = new Scanner(System.in);

		boolean exit = false;
		while (!exit) {
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. View Students");
			System.out.println("5. Commit and Exit");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addStudent(scanner);
				break;
			case 2:
				updateStudent(scanner);
				break;
			case 3:
				deleteStudent(scanner);
				break;
			case 4:
				viewStudents();
				break;
			case 5:
				saveStudentData();
				exit = true;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

		scanner.close();
	}

	private static void loadStudentData() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			studentList = (List<Student>) ois.readObject();
			System.out.println("Student data loaded successfully.");
		} catch (FileNotFoundException e) {
			System.out.println("No existing student data found. Starting with an empty collection.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void saveStudentData() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			oos.writeObject(studentList);
			System.out.println("Student data saved successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void addStudent(Scanner scanner) {
		System.out.print("Enter student name: ");
		String name = scanner.nextLine();

		System.out.print("Enter student ID: ");
		int id = scanner.nextInt();

		scanner.nextLine();

		System.out.print("Enter student course: ");
		String course = scanner.nextLine();

		System.out.print("Enter student age: ");
		int age = scanner.nextInt();

		Student newStudent = new Student(name, id, course, age);
		studentList.add(newStudent);
		System.out.println("Student added successfully: " + newStudent);
	}

	private static void updateStudent(Scanner scanner) {
		System.out.print("Enter the student ID to update: ");
		int id = scanner.nextInt();

		Student studentToUpdate = findStudentById(id);
		if (studentToUpdate != null) {
			System.out.println("Current details of the student: " + studentToUpdate);
			System.out.print("Enter new student name (or press Enter to keep the current name): ");
			String name = scanner.nextLine();

			if (!name.isEmpty()) {
				studentToUpdate.setName(name);
			}

			System.out.print("Enter new student course (or press Enter to keep the current course): ");
			String course = scanner.nextLine();

			if (!course.isEmpty()) {
				studentToUpdate.setCourse(course);
			}

			System.out.print("Enter new student age (or press Enter to keep the current age): ");
			String ageStr = scanner.nextLine();

			if (!ageStr.isEmpty()) {
				int age = Integer.parseInt(ageStr);
				studentToUpdate.setAge(age);
			}

			System.out.println("Student details updated successfully: " + studentToUpdate);
		} else {
			System.out.println("Student with ID " + id + " not found.");
		}
	}

	private static void deleteStudent(Scanner scanner) {
		System.out.print("Enter the student ID to delete: ");
		int id = scanner.nextInt();

		Student studentToDelete = findStudentById(id);
		if (studentToDelete != null) {
			studentList.remove(studentToDelete);
			System.out.println("Student deleted successfully: " + studentToDelete);
		} else {
			System.out.println("Student with ID " + id + " not found.");
		}
	}

	private static void viewStudents() {
		if (studentList.isEmpty()) {
			System.out.println("No students in the collection.");
		} else {
			System.out.println("List of Students:");
			for (Student student : studentList) {
				System.out.println(student);
			}
		}
	}

	private static Student findStudentById(int id) {
		for (Student student : studentList) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}
}

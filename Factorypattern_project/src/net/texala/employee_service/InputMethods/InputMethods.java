package net.texala.employee_service.InputMethods;

import java.util.Scanner;

public class InputMethods {
	public static int getIntInput(Scanner scanner, String message) {
		System.out.println(message);
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid input. Please enter an integer value.");
			scanner.next();
		}
		return scanner.nextInt();
	}

	public static String getStringInput(Scanner scanner, String message) {
		System.out.println(message);
		return scanner.nextLine();
	}

	public static String getDateOfBirthInput(Scanner scanner) {
		System.out.println("Enter date of birth (dd/MM/yyyy): ");
		return scanner.nextLine();
	}
}

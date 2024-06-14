/*
DAY : 06
ASSIGNMENT NO : 1

Write a program in Java to display the names and roll numbers of students. Initialize
respective array variables for 10 students. Handle
ArrayIndexOutOfBoundsException, so that any such problem does not cause
illegal termination of the program.
Hint: int a[] = new int [10];
a[15]=90; // ArrayIndexOutOfBoundsException

*/
package net.texala.main;

import java.util.Scanner;

public class ExceptionStudent {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			int SIZE = getSizeFromUser(scanner);
			int[] rollNumbers = new int[SIZE];
			String[] names = new String[SIZE];

			try {
				for (int i = 0; i <= SIZE; i++) {
					System.out.print("Enter Rollno for student " + (i + 1) + ": ");
					while (true) {
						try {
							rollNumbers[i] = Integer.parseInt(scanner.nextLine());
							break;
						} catch (NumberFormatException e) {
							System.out.println("Invalid input! Please enter a valid roll number.");
							System.out.print("Enter roll number for student " + (i + 1) + ": ");
						}
					}

					System.out.print("Enter name for student " + (i + 1) + ": ");
					while (true) {
						String inputName = scanner.nextLine();
						if (inputName.matches("[a-zA-Z]+")) {
							names[i] = inputName;
							break;
						} else {
							System.out.println("Invalid input! Please enter a valid name.");
							System.out.print("Enter name for student " + (i + 1) + ": ");
						}
					}
				}
				System.out.println("Attempting to access an index outside the array bounds:");

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Error: ArrayIndexOutOfBoundsException occurred.");
				System.out.println("Make sure that you are accessing the array within its range.");
			}

			System.out.println("Do you want to execute again? (y/n):");

			userinput = scanner.next().charAt(0);
			scanner.nextLine();
		} while (userinput == 'y' || userinput == 'Y');

		scanner.close();
	}

	private static int getSizeFromUser(Scanner scanner) {
		int userInput;
		while (true) {
			try {
				System.out.print("Enter the value for SIZE: ");
				userInput = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println(" Invalid Input ! Please enter a valid integer value");
			}
		}

		return userInput;
	}
}

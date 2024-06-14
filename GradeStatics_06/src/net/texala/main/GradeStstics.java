/*

 DAY : 03
ASSIGNMENT : 06

Write a GradesStatistics program, which reads in n grades (of int between 0
and 100, inclusive) and displays the average, minimum, maximum, and standard
deviation. Your program shall check for the valid input. You should keep the grades
in an int[] and use a method for each of the computations.
Output should look like the following.
Enter the number of students: 4
Enter the grade for student 1: 50
Enter the grade for student 2: 51
Enter the grade for student 3: 56
Enter the grade for student 4: 53
The average is 52.5
The minimum is 50
The maximum is 56
The standard deviation is 2.29128784747792

 
 */
package net.texala.main;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeStstics {
	private static int[] grades;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput = 0;

		do {
			try {
				readGrades(scanner);
				System.out.println("The average is " + average());
				System.out.println("The minimum is " + min());
				System.out.println("The maximum is " + max());
				System.out.println("The standard deviation is " + stdDev());
			} catch (InputMismatchException e) {
				System.out.println("Error: Please enter a valid integer for the number of students.");
				scanner.nextLine();
				continue;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				continue;
			}

			System.out.println("Do you want to run again? (y/n) :");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'y' || userinput == 'Y');

		scanner.close();
	}

	public static void readGrades(Scanner scanner) throws InputMismatchException, IllegalArgumentException {
		int numStudents;

		while (true) {
			try {
				System.out.print("Enter the number of students: ");
				numStudents = scanner.nextInt();
				scanner.nextLine();

				if (numStudents <= 0) {
					throw new IllegalArgumentException("Error: Number of students must be a positive integer.");
				}

				break;
			} catch (InputMismatchException ex) {
				System.out.println("Error: Please enter a valid integer for the number of students.");
				scanner.nextLine();
			}
		}

		grades = new int[numStudents];

		for (int i = 0; i < numStudents; i++) {
			while (true) {
				try {
					System.out.print("Enter the grade for student " + (i + 1) + ": ");
					int inputGrade = scanner.nextInt();

					if (inputGrade < 0 || inputGrade > 100) {
						throw new IllegalArgumentException("Error: Please enter a valid grade between 0 and 100.");
					}

					grades[i] = inputGrade;
					break;
				} catch (InputMismatchException ex) {
					System.out.println("Error: Please enter a valid integer for the grade.");
					scanner.nextLine();
				}
			}
		}
	}

	public static double average() {
		return Arrays.stream(grades).average().orElse(0);
	}

	public static int max() {
		return Arrays.stream(grades).max().orElse(0);
	}

	public static int min() {
		return Arrays.stream(grades).min().orElse(0);
	}

	public static double stdDev() {
		double mean = average();
		double sumOfSquaredDifferences = 0;

		for (int grade : grades) {
			double difference = grade - mean;
			double squaredDifference = difference * difference;
			sumOfSquaredDifferences += squaredDifference;
		}

		double variance = sumOfSquaredDifferences / grades.length;
		double standardDeviation = Math.sqrt(variance);
		return standardDeviation;
	}
}

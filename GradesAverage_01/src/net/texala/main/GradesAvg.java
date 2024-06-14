/*

DAY : 03
ASSIGNMENT : 01

Write a GradesAverage program, which prompts the user for number of students,
reads it from the in.txt file where the number of students and grade has been
defined and saves it in an int variable called the numStudents. It then prompts
the user for the grades of each student and saves them in an int array called
grades. Your program shall check that the grade is between 0 and 100.

 */

package net.texala.main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GradesAvg {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			try {
				Scanner fileScanner = new Scanner(new File("yu.txt"));
				int numStudents = fileScanner.nextInt();
				int[] grades = new int[numStudents];
				for (int i = 0; i < numStudents; i++) {
					int grade;
					do {
						grade = fileScanner.nextInt();
					} while (grade < 0 || grade > 100);
					grades[i] = grade;
				}
				System.out.println("Grades for each student:");
				for (int i = 0; i < numStudents; i++) {
					char grade = calculateGrade(grades[i]);
					System.out.printf("Student %d Mark is : %d -> Grade: %c%n", i + 1, grades[i], grade);
				}
				double average = calculateAverage(grades);
				System.out.printf("Average grade: %.2f%n", average);
				fileScanner.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error: File not found.");
			}
			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
			scanner.nextLine();

		} while (userinput == 'y' || userinput == 'Y');
	}

	private static char calculateGrade(int mark) {
		if (mark >= 90) {
			return 'A';
		} else if (mark >= 80) {
			return 'B';
		} else if (mark >= 70) {
			return 'C';
		} else if (mark >= 60) {
			return 'D';
		} else {
			return 'F';
		}
	}

	private static double calculateAverage(int[] grades) {
		int sum = 0;
		for (int grade : grades) {
			sum += grade;
		}
		return (double) sum / grades.length;
	}
}

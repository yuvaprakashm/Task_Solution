/*
Day: 01
Assignment No: 01

Write a CheckGrade program which prints A, B, C, and F. If the int variable
score is less than 60 then it prints F otherwise;
print A for a score between 80 and 100,
print B for a score between 70 and 81, and
print C for a score between 60 and 71.

*/
package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckGrade {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			try {
				System.out.print("Enter your test score: ");
				final int score = scanner.nextInt();
				char grade = calculateGrade(score);
				System.out.println("Your grade is: " + grade);
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid integer.");
			} finally {

				scanner.nextLine();
				System.out.println("Do you want to execute again (y/n) ? :");
				userinput = scanner.next().charAt(0);
			}
		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}

	private static char calculateGrade(int score) {
		char grade;

		if (score < 60) {
			grade = 'F';
		} else if (score < 71) {
			grade = 'C';
		} else if (score < 81) {
			grade = 'B';
		} else if (score <= 100) {
			grade = 'A';
		} else {
			grade = 'I';
		}

		return grade;
	}
}

/* 
 
 Day: 01
Assignment No: 05
 
Write a SumAndAverage program to produce the sum of 1, 2, 3, ..., to anupperbound (for example, 100). Also compute and display the average up to 2 digitdecimal places

Output should be the following.
The sum is 5050
The average is 50.50


*/
package net.texala.main;

import java.util.Scanner;
import java.util.InputMismatchException;

public class SumAndAverage {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput = 0;

		do {
			int sum = 0;
			double average;

			int upperbound = getValidInput(scanner);

			final int lowerbound = 1;

			for (int number = lowerbound; number <= upperbound; number++) {
				sum = sum + number;
			}

			average = (double) sum / (upperbound - lowerbound + 1);

			System.out.println("The sum is " + sum);
			System.out.println("The average is " + average);

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}

	private static int getValidInput(Scanner scanner) {
		while (true) {
			try {
				System.out.print("Enter the upper bound: ");
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid numeric value.");
				scanner.nextLine();
			}
		}
	}
}

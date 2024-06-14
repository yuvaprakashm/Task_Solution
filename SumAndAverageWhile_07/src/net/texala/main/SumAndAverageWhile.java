/*
 * 
Day: 01

Assignment No: 07
Write a SumAndAverage program to produce the sum of 1, 2, 3, ..., to an
upperbound (for example, 100). Also compute and display the average up to 2 digit
decimal places.


*/
package net.texala.main;

import java.util.Scanner;

public class SumAndAverageWhile {

	public static void main(String[] args) {
		int sum = 0;
		double average;
		int lowerbound = 1;
		int upperbound;
		char userinput = 0;
		int number;
		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("Enter the upperbound: ");
				upperbound = scanner.nextInt();
				if (upperbound < lowerbound) {
					throw new IllegalArgumentException("Upperbound must be greater than or equal to lowerbound.");
				}

				number = lowerbound;

				while (number <= upperbound) {
					sum += number;
					number++;
				}

				average = (double) sum / (upperbound - lowerbound + 1);
				System.out.println("The sum is " + sum);
				System.out.println("The average is = " + average);
				System.out.println("Do you want to execute again (y/n)?");
				userinput = scanner.next().charAt(0);
				sum = 0;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine();

			}
		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}
}

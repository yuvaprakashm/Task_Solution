/*


Day: 01
Assignment No: 11

 Write a HarmonicSum program to compute the sum of a harmonic series, where
n=50000 (as shown in the following screenshot). The program shall compute the
sum from left-to-right as well as from right-to-left. Obtain the difference between
these two sums and explain the difference. Which sum is more accurate?


 */

package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HarmonicSum {
	public static void main(String[] args) {
		char userinput;

		Scanner scanner = new Scanner(System.in);
		do {
			int n = getValidInput("Enter the value of n: ", scanner);

			double sumLeftToRight = computeHarmonicSumLeftToRight(n);
			double sumRightToLeft = computeHarmonicSumRightToLeft(n);
			double difference = Math.abs(sumLeftToRight - sumRightToLeft);

			System.out.println("Sum from left to right: " + sumLeftToRight);
			System.out.println("Sum from right to left: " + sumRightToLeft);
			System.out.println("Difference: " + difference);

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}

	private static double computeHarmonicSumLeftToRight(int n) {
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += 1.0 / i;
		}
		return sum;
	}

	private static double computeHarmonicSumRightToLeft(int n) {
		double sum = 0;
		for (int i = n; i >= 1; i--) {
			sum += 1.0 / i;
		}
		return sum;
	}

	private static int getValidInput(String message, Scanner scanner) {
		int number = 0;
		boolean validInput = false;

		while (!validInput) {
			try {
				System.out.print(message);
				number = scanner.nextInt();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.next();
			}
		}

		return number;
	}
}

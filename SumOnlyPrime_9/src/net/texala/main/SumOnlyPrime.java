/*

Day: 01
Assignment No: 09

modify the program to sum only the Prime and Odd numbers from 1 to 1000,
and compute the average.

 */

package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SumOnlyPrime {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;

		do {
			int end = getValidInput("Enter the end value: ", scanner);
			int sum = 0;
			int count = 0;

			for (int i = 3; i <= end; i = i + 2) {
				if (isPrime(i)) {
					sum = sum + i;
					count++;
				}
			}

			double average = count > 0 ? (double) sum / count : 0;
			System.out.println("The sum of prime and odd numbers: " + sum);
			System.out.println("Average: " + average);
			System.out.println("Count: " + count);

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}

	private static boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int getValidInput(String message, Scanner scanner) {
		int number = 0;
		boolean validInput = false;

		while (!validInput) {
			try {
				System.out.print(message);
				number = scanner.nextInt();
				if (number >= 3) {
					validInput = true;
				} else {
					System.out.println("Invalid input. Please enter a number greater than or equal to 3.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.next();
			}
		}

		return number;
	}
}

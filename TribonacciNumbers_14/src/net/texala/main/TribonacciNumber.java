/*
Day: 01
Assignment No: 14

 Tribonacci numbers are a sequence of numbers T(n) similar to Fibonacci numbers,
except that a number is formed by adding the three previous numbers, that is, T(n)
= T(n-1) + T(n-2) + T(n-3), T(1) = T(2) = 1, and T(3) = 2. Write a
Tribonacci program to produce the first twenty Tribonacci numbers
 
 
 */

package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TribonacciNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;

		do {
			int n = getValidInput("Enter the number of Tribonacci numbers to generate: ", scanner);

			System.out.println("First " + n + " Tribonacci numbers:");
			generateAndPrintTribonacciNumbers(n);

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}

	private static void generateAndPrintTribonacciNumbers(int n) {
		if (n >= 1) {
			System.out.print("1 ");
		}
		if (n >= 2) {
			System.out.print("1 ");
		}
		if (n >= 3) {
			System.out.print("2 ");
		}

		int[] tribonacciNumbers = new int[n];

		for (int i = 0; i < n; i++) {
			if (i >= 3) {
				tribonacciNumbers[i] = tribonacciNumbers[i - 1] + tribonacciNumbers[i - 2] + tribonacciNumbers[i - 3];
				System.out.print(tribonacciNumbers[i] + " ");
			}
		}

		System.out.println();
	}

	private static int getValidInput(String message, Scanner scanner) {
		int number = 0;
		boolean validInput = false;

		while (!validInput) {
			try {
				System.out.print(message);
				number = scanner.nextInt();
				validInput = (number > 0);
				if (!validInput) {
					System.out.println("Invalid input. Please enter a positive number.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.next();
			}
		}

		return number;
	}
}

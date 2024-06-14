/*  
 
Day: 01
Assignment No: 14

Write a Fibonacci program to display the first 20 Fibonacci numbers F(n), where
F(n)=F(n–1)+F(n–2) and F(1)=F(2)=1. Also compute their average.
 
 */
package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			int n = getValidInput("Enter the number of Fibonacci numbers to generate: ", scanner);

			System.out.println("First " + n + " Fibonacci numbers:");
			int[] fibonacciNumbers = generateFibonacciNumbers(n);
			displayFibonacciNumbers(fibonacciNumbers);

			double average = computeAverage(fibonacciNumbers);
			System.out.println("Average of the first " + n + " Fibonacci numbers: " + average);

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}

	private static int[] generateFibonacciNumbers(int n) {
		int[] fibonacciNumbers = new int[n];
		fibonacciNumbers[0] = 1;
		fibonacciNumbers[1] = 1;

		for (int i = 2; i < n; i++) {
			fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
		}

		return fibonacciNumbers;
	}

	private static void displayFibonacciNumbers(int[] fibonacciNumbers) {
		for (int number : fibonacciNumbers) {
			System.out.print(number + " ");
		}
		System.out.println();
	}

	private static double computeAverage(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum = sum + number;
		}
		return (double) sum / numbers.length;
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

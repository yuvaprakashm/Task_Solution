/*

DAY : 03
ASSIGNMENT : 04

Write a SumDigits program to sum up the individual digits of a positive integer,
given in the command line.
Output should look like the following.
> java SumDigits 12345
The sum of digits = 1 + 2 + 3 + 4 + 5 = 15
 
 
 */

package net.texala.main;

public class SumDigit {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No input provided. Please provide a positive integer as a command-line argument.");
			return;
		}

		String input = args[0];
		if (isValidPositiveInteger(input)) {
			int number = Integer.parseInt(input);
			int sum = sumDigits(number);

			System.out.println("Input number: " + number);
			System.out.println("Sum of digits: " + sum);
		} else {
			System.out.println("Invalid input. Please provide a valid positive integer.");
		}
	}

	private static boolean isValidPositiveInteger(String input) {
		return input.matches("\\d+") && !input.startsWith("0");
	}

	private static int sumDigits(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
}

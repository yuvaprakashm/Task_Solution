
/*

DAY : 04
ASSIGNMENT NO : 09

Write a program called NumberConversion, which prompts the user for an input
number, an input radix, and an output radix, and displays the converted number.
Output should look like the following.
Enter a number and radix: A1B2
Enter the input radix: 16
Enter the output radix: 2
"A1B2" in radix 16 is "1010000110110010" in radix 2.



 */
package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberConversion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput = 0;

		do {
			System.out.println("Enter a number:");
			String inputnumber = scanner.next();

			int inputradix = 0;
			int outputradix = 0;

			try {
				inputradix = readValidRadix("Enter the input radix:", scanner);
				outputradix = readValidRadix("Enter the output radix:", scanner);
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid integer.");
				scanner.nextLine();
				continue;
			}

			String result = toRadix(inputnumber, inputradix, outputradix);
			System.out.printf("\"%s\" in radix %d is \"%s\" in radix %d.%n", inputnumber, inputradix, result,
					outputradix);

			System.out.println("Do you want to run again? (y/n):");
			userinput = scanner.next().charAt(0);

		} while (userinput == 'y' || userinput == 'Y');

		scanner.close();
	}

	public static int readValidRadix(String message, Scanner scanner) {
		int radix = 0;

		while (true) {
			try {
				System.out.println(message);
				radix = scanner.nextInt();
				validateRadix(radix);
				break;
			} catch (InputMismatchException | IllegalArgumentException e) {
				System.out.println("Invalid radix. " + e.getMessage());
				scanner.nextLine();
			}
		}

		return radix;
	}

	public static void validateRadix(int radix) {
		if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
			throw new IllegalArgumentException(
					"Radix must be between " + Character.MIN_RADIX + " and " + Character.MAX_RADIX + ".");
		}
	}

	public static String toRadix(String inputnumber, int inputradix, int outputradix) {
		try {
			int decimalvalue = Integer.parseInt(inputnumber, inputradix);
			return Integer.toString(decimalvalue, outputradix);
		} catch (NumberFormatException e) {
			return "Invalid input! Please enter a valid number.";
		}
	}
}

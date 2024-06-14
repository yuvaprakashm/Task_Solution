/*

DAY : 04
ASSIGNMENT NO : 08

Write a method called toRadix() which converts a positive integer from one radix
into another. The method has the following header.


 */

package net.texala.main;

import java.util.Scanner;

public class Radix {
	public static void main(String[] args) {
		char userinput;

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Enter the number: ");
			String inputNumber = scanner.nextLine();

			System.out.print("Enter the input radix: ");
			int inputRadix = scanner.nextInt();

			System.out.print("Enter the output radix: ");
			int outputRadix = scanner.nextInt();

			String result = toRadix(inputNumber, inputRadix, outputRadix);
			System.out.println("Converted number is " + result);

			System.out.println("Do you want to run again (y/n):");
			userinput = scanner.next().charAt(0);
			scanner.nextLine();
		} while (userinput == 'y' || userinput == 'Y');

		scanner.close();
	}

	public static String toRadix(String input, int inputRadix, int outputRadix) {
		try {
			long decimalValue = Long.parseLong(input, inputRadix);
			return Long.toString(decimalValue, outputRadix);
		} catch (NumberFormatException e) {
			return "Invalid input ! Please enter a valid number.";
		}
	}
}
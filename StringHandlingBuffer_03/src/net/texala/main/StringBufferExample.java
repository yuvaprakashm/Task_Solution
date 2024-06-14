/*
  
DAY : 8
ASSIGNMENT NO : 03  
  
1.Write a program in Java for String handling which perform the following tasks.
2.Checks the capacity of StringBuffer objects.
3.Reverses the contents of a string given on console and converts the resultant
string in upper case.
4.Reads a string from console and appends it to the resultant string of ii.

*/

package net.texala.main;

import java.util.Scanner;

public class StringBufferExample {
	public static void main(String[] args) {
		char userinput = 0;

		Scanner scanner = new Scanner(System.in);

		do {
			StringBuffer stringBuffer = new StringBuffer();
			System.out.println("Initial Capacity of StringBuffer: " + stringBuffer.capacity());

			System.out.println("Enter a string to reverse and convert to upper case:");
			String inputString = scanner.nextLine();

			if (containsNumber(inputString)) {
				System.out.println("Invalid input. Please enter a string without numbers.");
				continue;
			}

			stringBuffer.append(inputString).reverse().toString();

			String reversedUpperCaseString = stringBuffer.toString().toUpperCase();

			System.out.println("Reversed and Upper Case String: " + reversedUpperCaseString);

			System.out.println("Enter a string to append:");
			String appendString = scanner.nextLine();

			if (containsNumber(appendString)) {
				System.out.println("Invalid input. Please enter a string without numbers.");
				continue;
			}

			stringBuffer.append(appendString);

			System.out.println("Final String after appending: " + stringBuffer.toString());

			System.out.println("Do you want to execute again (y/n) ? :");
			userinput = scanner.next().charAt(0);
			scanner.nextLine();
		} while (userinput == 'y' || userinput == 'Y');

		scanner.close();
	}

	private static boolean containsNumber(String input) {
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
}
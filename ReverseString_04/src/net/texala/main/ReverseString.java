/*

Day : 02
ASSIGNMENT : 04

Write a ReverseString program, which prompts the user for a String, and prints the reverse of the String. Also, find the vowels and consonants.
For example,
If the entered string is abcdef, then the reverse of this string will be fedcba.

 */
package net.texala.main;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char userinput;
		do {
			System.out.print("Enter a string: ");
			String inputString = scanner.nextLine();

			while (!isValidInput(inputString)) {
				System.out.println("Invalid input. Please enter alphabets only.");
				System.out.print("Enter a string: ");
				inputString = scanner.nextLine();
			}

			String reversedString = reverseString(inputString);

			System.out.println("Reversed String: " + reversedString);

			int vowelsCount = countVowels(inputString);
			int consonantsCount = countConsonants(inputString);

			System.out.println("Number of vowels: " + vowelsCount);
			System.out.println("Number of consonants: " + consonantsCount);

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
			scanner.nextLine();  

		} while (userinput == 'y' || userinput == 'Y');

		scanner.close();
	}

	private static boolean isValidInput(String str) {
		return str.matches("[a-zA-Z]+");
	}

	private static String reverseString(String str) {
		StringBuilder reversed = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			reversed.append(str.charAt(i));
		}
		return reversed.toString();
	}

	private static int countVowels(String str) {
		int count = 0;
		String vowels = "aeiouAEIOU";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (vowels.indexOf(ch) != -1) {
				count++;
			}
		}

		return count;
	}

	private static int countConsonants(String str) {
		int count = 0;
		String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (consonants.indexOf(ch) != -1) {
				count++;
			}
		}

		return count;
	}
}

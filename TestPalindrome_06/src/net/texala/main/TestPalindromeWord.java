/*

Day : 02
ASSIGNMENT : 06

A word that reads the same backward as well as forward is called a palindrome. For example, mom, dad, race car, madam, and Radar (case-insensitive).
Write a TestPalindromicWord program that prompts the user for a word and prints "xxx" is|is not a palindrome.


 */
package net.texala.main;

import java.util.Scanner;

public class TestPalindromeWord {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char userinput;
		do {
			String inputWord;
			do {
				System.out.print("Enter a word: ");
				inputWord = scanner.next().toLowerCase();

				if (!isValidInput(inputWord)) {
					System.out.println("Invalid input. Please enter alphabets only.");
				}
			} while (!isValidInput(inputWord));

			if (isPalindrome(inputWord)) {
				System.out.println("'" + inputWord + "' is a palindrome.");
			} else {
				System.out.println("'" + inputWord + "' is not a palindrome.");
			}

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);

		} while (userinput == 'y' || userinput == 'Y');

		scanner.close();
	}

	private static boolean isValidInput(String str) {
		return str.matches("[a-zA-Z]+");
	}

	private static boolean isPalindrome(String word) {
		int length = word.length();
		for (int i = 0; i < length / 2; i++) {
			if (word.charAt(i) != word.charAt(length - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}

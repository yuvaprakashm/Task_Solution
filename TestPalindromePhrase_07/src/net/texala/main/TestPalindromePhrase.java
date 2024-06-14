/*

Day : 02
ASSIGNMENT : 07
 
A phrase that reads the same backward as well as forward is also called a palindrome. For example, “Madam, I'm Adam”, "A man, a plan, a canal - Panama!" 
 (Ignore punctuation and capitalization). Modify your program (called TestPalindromicPhrase) to test palindromic phrase.
 */
package net.texala.main;

import java.util.Scanner;

public class TestPalindromePhrase {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			String inputPhrase;
			do {
				System.out.print("Enter a phrase: ");
				inputPhrase = scanner.nextLine().toLowerCase().replaceAll("[^a-z]", "");

				if (!isValidInput(inputPhrase)) {
					System.out.println("Invalid input. Please enter alphabets only.");
				}
			} while (!isValidInput(inputPhrase));

			if (isPalindrome(inputPhrase)) {
				System.out.println("'" + inputPhrase + "' is a palindrome.");
			} else {
				System.out.println("'" + inputPhrase + "' is not a palindrome.");
			}

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
			scanner.nextLine();
		} while (userinput == 'y' || userinput == 'Y');

		scanner.close();
	}

	private static boolean isValidInput(String str) {
		return str.matches("[a-z]+");
	}

	private static boolean isPalindrome(String phrase) {
		int length = phrase.length();
		for (int i = 0; i < length / 2; i++) {
			if (phrase.charAt(i) != phrase.charAt(length - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}

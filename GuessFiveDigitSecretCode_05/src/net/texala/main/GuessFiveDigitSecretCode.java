/*
Day : 02
ASSIGNMENT : 05

Write a secret five-digit code program for a simple game of guessing. When the user enters a guess at the code, the program will return two values.
 The number of digits in the guess those are in correct position. And
 The sum of those digits.
For example, if the secret code is 53840, and the user guesses 83241, the digits 3 and 4 are in the correct position. Thus, the program should return the values as 2 
(number of digits in the guess those are in correct position) and 7 (sum of those digits). Allow the user to guess a fixed number of times. In this case allow the user to make 10 guesses.

note:Use charAt() function


*/
package net.texala.main;

import java.util.Scanner;

public class GuessFiveDigitSecretCode {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;

		String secretCode = generateSecretCode();
		do {
			System.out.println("Welcome to Guess the Five-Digit Secret Code Game!");
			System.out.println("Try to guess the secret code.");

			for (int attempt = 1; attempt <= 10; attempt++) {

				System.out.print("Enter your guess (5 digits): ");
				String userGuess = scanner.next();

				if (userGuess.length() != 5) {
					System.out.println("Invalid input. Please enter a 5-digit guess.");
					attempt--;
					continue;
				}

				int[] correctPositions = new int[5];
				int sumOfDigits = 0;

				for (int i = 0; i < 5; i++) {
					char secretDigit = secretCode.charAt(i);
					char userDigit = userGuess.charAt(i);

					if (secretDigit == userDigit) {
						correctPositions[i] = i + 1;
					}

					sumOfDigits += Character.getNumericValue(userDigit);
				}

				System.out.print("Feedback: Correct Positions = ");
				for (int position : correctPositions) {
					if (position != 0) {
						System.out.print(position + " ");
					}
				}
				System.out.println(", Sum of Digits = " + sumOfDigits);

				if (correctPositions[0] != 0 && correctPositions[1] != 0 && correctPositions[2] != 0
						&& correctPositions[3] != 0 && correctPositions[4] != 0) {
					System.out.println("Congratulations! You guessed the secret code.");
					break;
				}

				System.out.println("Remaining attempts: " + (10 - attempt));
			}

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'y' || userinput == 'Y');

		scanner.close();
	}

	private static String generateSecretCode() {
		StringBuilder code = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			code.append((int) (Math.random() * 10));
		}
		return code.toString();
	}
}
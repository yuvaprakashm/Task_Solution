/*

DAY:09
ASSIGNMENT NO :08

A certain drug loses 4% of its effectiveness every month in its storage. When its
effectiveness is below 50%, it is considered expired and must be discarded. Write a program
that determines that for how many months the drug can remain in storage.
Output should be like as given below.
Month 0: effectiveness: 100.0
Month 1: effectiveness: calc
Month 2: effectiveness: 92.16
Month 3: effectiveness: 88.47359999999999
Month 4: effectiveness: 84.93465599999999
Month 5: effectiveness: 81.53726975999999
Month 6: effectiveness: 78.27577896959998
Month 7: effectiveness: 75.14474781081599
Month 8: effectiveness: 72.13895789838334
Month 9: effectiveness: 69.253399582448
Month 10: effectiveness: 66.48326359915008
Month 11: effectiveness: 63.82393305518407
Month 12: effectiveness: 61.27097573297671
Month 13: effectiveness: 58.82013670365764
Month 14: effectiveness: 56.46733123551133
Month 15: effectiveness: 54.20863798609088
Month 16: effectiveness: 52.04029246664724
Month 17: effectiveness: 49.95868076798135 DISCARDED

*/
package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DrugExpiration {

	public static void main(String[] args) {
		char userInput;

		Scanner scanner = new Scanner(System.in);
		do {
			int initialEffectiveness = 100;

			double monthlyDecay = getNumericInput("Enter monthly decay (in decimal form, e.g., 0.04 for 4%): ");
			double expirationThreshold = getNumericInput("Enter expiration effectiveness: ");

			double currentEffectiveness = initialEffectiveness;
			int month = 0;

			while (currentEffectiveness >= expirationThreshold) {
				System.out.printf("Month %d: effectiveness: %.5f%n", month, currentEffectiveness);
				currentEffectiveness = currentEffectiveness * (1 - monthlyDecay);
				month++;
			}

			System.out.printf("Month %d: effectiveness: %.5f DISCARDED%n", month, currentEffectiveness);
			System.out.println("Do you want to execute again (y/n) ? :");
			userInput = scanner.next().charAt(0);
		} while (Character.toLowerCase(userInput) == 'y');

		scanner.close();
	}

	private static double getNumericInput(String message) {
		Scanner scanner = new Scanner(System.in);
		double value = 0.0;
		boolean validInput = false;

		while (!validInput) {
			try {
				System.out.print(message);
				value = scanner.nextDouble();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid numeric value.");
				scanner.next();
			}
		}

		return value;
	}
}

/*

Day: 01
Assignment No: 12


 Write a ComputePI program to compute the value of ?, using the following series
expansion. You have to decide on the termination criterion used in the computation
(such as the number of terms used or the magnitude of an additional term). Is this
series suitable for computing ??
JDK maintains the value of ? in double constant called Math.PI. Compare the
values obtained and the Math.PI, in percents of Math.PI.
 
 
 */

package net.main.texala;

import java.util.Scanner;

public class ComputePi {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			System.out.println("Choose an option:");
			System.out.println("1. Use Math class PI value");
			System.out.println("2. Use approximate value of pi");

			int choice = getValidInput("Enter your choice (1 or 2): ", scanner);

			double piValue;
			if (choice == 1) {
				piValue = Math.PI;
			} else if (choice == 2) {
				piValue = approximatePi();
			} else {
				System.out.println("Invalid choice. Exiting.");
				return;
			}

			System.out.println("Selected value of pi: " + piValue);

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}

	private static double approximatePi() {
		double sum = 0;
		int maxDenom = 10000000;
		for (int denom = 1; denom <= maxDenom; denom = denom + 2) {
			if (denom % 4 == 1) {
				sum += 1.0 / denom;
			} else if (denom % 4 == 3) {
				sum -= 1.0 / denom;
			} else {
				System.out.println("The computer has gone crazy?!");
			}
		}

		return 4 * sum;
	}

	private static int getValidInput(String message, Scanner scanner) {
		int number = 0;
		boolean validInput = false;

		while (!validInput) {
			try {
				System.out.print(message);
				number = scanner.nextInt();
				validInput = (number == 1 || number == 2);
				if (!validInput) {
					System.out.println("Invalid input. Please enter 1 or 2.");
				}
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter 1 or 2.");
				scanner.next(); // Consume the invalid input
			}
		}

		return number;
	}
}

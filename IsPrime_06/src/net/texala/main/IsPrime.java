/*

DAY:07
ASSIGNMENT NO:06

Write a method called isPrime(int posInt) that takes a positive
integer and returns true if the number is a prime.

*/
package net.texala.main;

import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			int number = getUserInput(scanner);

			System.out.println(number + " is prime: " + isPrime(number));
			System.out.println("Do you want to execute again (y/n) ? :");
			userinput = scanner.next().charAt(0);

		} while (userinput == 'Y' || userinput == 'y');
		scanner.close();
	}

	static int getUserInput(Scanner scanner) {
		int number = -1;
		boolean isValidInput = false;

		while (!isValidInput) {
			System.out.print("Enter a positive integer: ");

			if (scanner.hasNextInt()) {
				number = scanner.nextInt();

				if (number > 0) {
					isValidInput = true;
				} else {
					System.out.println("Please enter a positive integer greater than 0.");
				}
			} else {
				System.out.println("Invalid input. Please enter a valid positive integer.");
				scanner.next();
			}
		}

		return number;
	}

	static boolean isPrime(int posInt) {

		if (posInt <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(posInt); i++) {
			if (posInt % i == 0) {

				return false;
			}
		}

		return true;
	}
}

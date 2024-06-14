/*
 Day: 01
Assignment No: 03
 
Write a PrintNumberInWord program which prints ONE, TWO, ..., NINE, or OTHER if the int variable number is 1, 2, ..., 9, or other, respectively.
 Use the following.
1.a "nested-if" statement
2.a "switch-case" statement
 
 */

package net.texala.main;

import java.util.Scanner;

public class PrintNumberInWord {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			int number = getValidNumber(scanner);
			
		/*	if (number == 1) {
				System.out.println("ONE");
			} else if (number == 2) {
				System.out.println("TWO");
			} else if (number == 3) {
				System.out.println("THREE");

			} else if (number == 4) {
				System.out.println("FOUR");
			} else if (number == 5) {
				System.out.println("FIVE");

			} else if (number == 6) {
				System.out.println("SIX");
			} else if (number == 7) {
				System.out.println("SEVEN");
			} else if (number == 8) {
				System.out.println("EIGHT");
			}
			
			*/
			switch (number) {
			case 1:
				System.out.println("ONE");
				break;
			case 2:
				System.out.println("TWO");
				break;
			case 3:
				System.out.println("THREE");
				break;
			case 4:
				System.out.println("FOUR");
				break;
			case 5:
				System.out.println("FIVE");
				break;
			case 6:
				System.out.println("SIX");
				break;
			case 7:
				System.out.println("SEVEN");
				break;
			case 8:
				System.out.println("EIGHT");
				break;
			case 9:
				System.out.println("NINE");
				break;
			default:
				System.out.println("Please enter a valid number from 1 to 9");
			}

			System.out.println("Do you want to execute again (y/n) ? :");
			userinput = scanner.next().charAt(0);

		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}

	private static int getValidNumber(Scanner scanner) {
		int number;
		while (true) {
			System.out.print("Enter a number 1 to 9: ");
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				if (number >= 1 && number <= 9) {
					break;
				} else {
					System.out.println("Please enter a valid number from 1 to 9");
				}
			} else {
				System.out.println("Invalid input. Please enter a valid numeric value.");
				scanner.next();
			}
		}
		return number;
	}
}

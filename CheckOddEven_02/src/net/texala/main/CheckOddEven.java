/*
Day: 01
Assignment No: 02

Write a CheckOddEven program which prints Odd Number if the int variable number is odd else Even Number in case the int variable number is an even number 

*/

package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckOddEven {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			try {
				System.out.print("Enter a number: ");
				final int number = scanner.nextInt();

				if (number % 2 == 0) {
					System.out.println("The number " + number + " is even number");
				} else {
					System.out.println("The number " + number + " is odd number");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid integer.");
			} finally {
				scanner.nextLine();
				System.out.println("Do you want to execute again (y/n) ? :");
				userinput = scanner.next().charAt(0);
			}
		} while (userinput == 'Y' || userinput == 'y');
		scanner.close();
	}
}

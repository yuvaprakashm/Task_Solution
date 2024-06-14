/*

Day: 01
Assignment No: 13

Write a CozaLozaWoza program which will print the numbers from 1 to 110, and
there should be 11 numbers printed per line. The program shall print Coza in place
of the numbers which are multiples of 3, Loza for multiples of 5, Woza for multiples
of 7, CozaLoza for multiples of 3 and 5, and so on.

*/
package net.texala.main;

import java.util.Scanner;

public class CozaLoza {
	public static void main(String[] args) {
		int lowerBound = 1;
		int upperBound = 110;

		char userinput;
		Scanner scanner = new Scanner(System.in);

		do {
			printCozaLozaWoza(lowerBound, upperBound);
			System.out.println("\nDo you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);

		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}

	private static void printCozaLozaWoza(int lowerBound, int upperBound) {
		for (int i = lowerBound; i <= upperBound; i++) {

			boolean isMultipleOf3 = i % 3 == 0;
			boolean isMultipleOf5 = i % 5 == 0;
			boolean isMultipleOf7 = i % 7 == 0;

			if (isMultipleOf3 && isMultipleOf5 && isMultipleOf7) {
				System.out.print("CozaLozaWoza ");
			} else if (isMultipleOf3 && isMultipleOf5) {
				System.out.print("CozaLoza ");
			} else if (isMultipleOf3 && isMultipleOf7) {
				System.out.print("CozaWoza ");
			} else if (isMultipleOf5 && isMultipleOf7) {
				System.out.print("LozaWoza ");
			} else if (isMultipleOf3) {
				System.out.print("Coza ");
			} else if (isMultipleOf5) {
				System.out.print("Loza ");
			} else if (isMultipleOf7) {
				System.out.print("Woza ");
			} else {
				System.out.print(i + " ");
			}

			if (i % 11 == 0) {
				System.out.println();
			}
		}
	}
}

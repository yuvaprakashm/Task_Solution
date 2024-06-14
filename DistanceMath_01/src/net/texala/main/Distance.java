/*

DAY : 04
ASSIGNMENT NO : 01

write a program that prompts the user to enter two points (x1, y1) and (x2, y2).
Calculate and display their distance using the following formulae.


 */

package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Distance {
	public static void main(String[] args) {
		char userinput;
		Scanner scanner = new Scanner(System.in);
		do {
			int x1, y1, x2, y2;

			while (true) {
				try {
					System.out.print("Enter x1: ");
					x1 = scanner.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input enter a valid integer.");
					scanner.nextLine();
				}
			}

			while (true) {
				try {
					System.out.print("Enter y1: ");
					y1 = scanner.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input enter a valid integer.");
					scanner.nextLine();
				}
			}

			while (true) {
				try {
					System.out.print("Enter x2: ");
					x2 = scanner.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input enter a valid integer.");
					scanner.nextLine();
				}
			}

			while (true) {
				try {
					System.out.print("Enter y2: ");
					y2 = scanner.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter a valid integer.");
					scanner.nextLine();
				}
			}

			double dis = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

			System.out.println("Distance Between two points = " + dis);

			scanner.nextLine();
			System.out.println("Do you want to run again (y/n):");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'y' || userinput == 'Y');

		scanner.close();
	}
}

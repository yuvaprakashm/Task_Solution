/*
 
Day: 01
Assignment No: 04

 write a PrintDayInWord program which prints Sunday, Monday, ...,Saturday if the int variable day is 0, 1, ..., 6, respectively. Else it should print – Not
a valid day.

 */
package net.texala.main;

import java.util.Scanner;

public class PrintDayInWorld {

	public static void main(String[] args) {
		char userinput;

		Scanner scanner = new Scanner(System.in);
		do {
			int day = 0;
			boolean validInput = false;

			do {
				System.out.print("Enter the Number (1 - 7) : ");

				/*
				 * if (number == 1) { System.out.println("SUNDAY"); } else if (number == 2) {
				 * System.out.println("MONDAY"); } else if (number == 3) {
				 * System.out.println("TUESDAY");
				 * 
				 * } else if (number == 4) { System.out.println("WEDNESDAY"); } else if (number
				 * == 5) { System.out.println("THURSDAY");
				 * 
				 * } else if (number == 6) { System.out.println("FRIDAY"); } else if (number ==
				 * 7) { System.out.println("SATURDAY"); } else if (number == 8) {
				 * System.out.println("SUNDAY"); }
				 * 
				 */

				if (scanner.hasNextInt()) {
					day = scanner.nextInt();
					if (day >= 1 && day <= 7) {
						validInput = true;
					} else {
						System.out.println("Please enter a valid day (1 - 7).");
					}
				} else {
					System.out.println("Please enter a numeric value.");
					scanner.next();
				}

			} while (!validInput);

			switch (day) {
			case 1:
				System.out.println("SUNDAY");
				break;
			case 2:
				System.out.println("MONDAY");
				break;
			case 3:
				System.out.println("TUESDAY");
				break;
			case 4:
				System.out.println("WEDNESDAY");
				break;
			case 5:
				System.out.println("THURSDAY");
				break;
			case 6:
				System.out.println("FRIDAY");
				break;
			case 7:
				System.out.println("SATURDAY");
				break;
			default:
				System.out.println("NOT VALID DAY");
			}

			System.out.println("Do you want to execute again (y/n) ? :");
			userinput = scanner.next().charAt(0);

		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}
}

/*
Day : 02
ASSIGNMENT : 01


This program requests information on passenger's luggage and determines whether their luggage is acceptable or not for air travel.
Maximum Dimensions of Carry-on Luggage: 115 linear centimeters
Maximum weight of carry-on luggage: 7 Kilograms
Maximum weight of checked luggage: 20 Kilograms
Enter carry on length: 30 centimeters
Enter carry on width: 40 centimeters
Enter carry on height: 20 centimeters
Enter carry on weight: 8 Kilograms
Enter checked bag weight: 19 Kilograms
Output should be one of the following.
 Carry on too heavy
 Checked bag acceptable

*/
package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PassengerLuggage {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final double MAX_CARRY_ON_DIMENSION = 115.0;
		final double MAX_CARRY_ON_WEIGHT = 7.0;
		final double MAX_CHECKED_WEIGHT = 20.0;
		char userinput;
		do {
			try {
				System.out.print("Enter carry on length (in centimeters): ");
				double length = scanner.nextDouble();

				System.out.print("Enter carry on width (in centimeters): ");
				double width = scanner.nextDouble();

				System.out.print("Enter carry on height (in centimeters): ");
				double height = scanner.nextDouble();

				System.out.print("Enter carry on weight (in kilograms): ");
				double carryOnWeight = scanner.nextDouble();

				System.out.print("Enter checked bag weight (in kilograms): ");
				double checkedBagWeight = scanner.nextDouble();

				double linearDimensions = length + width + height;

				if (linearDimensions <= MAX_CARRY_ON_DIMENSION && carryOnWeight <= MAX_CARRY_ON_WEIGHT) {
					System.out.println("Carry on acceptable");
				} else {
					System.out.println("Carry on too heavy");
				}

				if (checkedBagWeight <= MAX_CHECKED_WEIGHT) {
					System.out.println("Checked bag acceptable");
				} else {
					System.out.println("Checked bag too heavy");
				}

			} catch (InputMismatchException e) {
				System.out.println("Error: Invalid input. Please enter numeric values.");
				scanner.nextLine();
			}
			System.out.println("Do you want to execute again (y/n) ? : ");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'y' || userinput == 'Y');
		scanner.close();
	}
}

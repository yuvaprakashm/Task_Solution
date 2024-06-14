/*
Day: 01
Assignment No: 08

Write a SumAndAverage program to produce the sum of 1, 2, 3, ..., to an
upperbound (for example, 100). Also compute and display the average up to 2 digit
decimal places.


*/

package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SumAndAverageFromRange {
	public static void main(String[] args) {
		int start;
		int end;
		int sum = 0;
		int count = 0;
		char userinput;
		Scanner scanner = new Scanner(System.in);

		do {
			while (true) {
				try {
					System.out.println("Enter the start value: ");
					start = scanner.nextInt();

					System.out.println("Enter the end value: ");
					end = scanner.nextInt();

					if (start > end) {
						throw new IllegalArgumentException("Start value must be less than or equal to end value.");
					}

					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter valid numbers.");
					scanner.next();
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}

			for (int number = start; number <= end; number++) {
				sum += number;
				count++;
			}

			double average = (double) sum / count;
			System.out.println("The sum is : " + sum);
			System.out.println("The average is : " + average);
			System.out.println("The Count is : " + count);

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}
}

/* 

Day: 01
Assignment No: 06

Write a SumAndAverage program to produce the sum of 1, 2, 3, ..., to anupperbound (for example, 100). Also compute and display the average up to 2 digitdecimal places

Modify the program to use a do-while loop.
int number = lowerbound;
int sum = 0;
do {
sum += number;
number++;
} while (number <= upperbound); 


*/

package net.texala.main;

import java.util.Scanner;

public class SumAndAverageDoWhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char userinput;

		do {
			double average;
			final int lowerbound = 1;

			double upperbound;
			while (true) {
				System.out.print("Enter the upper bound: ");
				String input = scanner.next();
				try {
					upperbound = Double.parseDouble(input);
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a valid numeric value.");
				}
			}

			int number = lowerbound;
			int sum = 0;

			do {
				sum += number;
				number++;
			} while (number <= upperbound);

			average = sum / upperbound;

			System.out.println("The sum is " + sum);
			System.out.println("The average is " + average);

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}
}

/*

Day : 02
ASSIGNMENT : 02

Write a FileScanner program to read an int numbers form a text file called in.txt, and calculate the sum of square of each number. Also, find the average.
The integer read is 12 13 15 17 ……………………………
Square of number and find average
package net.texala.main;


*/
package net.texala.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner {
	public static void main(String[] args) {
		char userinput;
		Scanner scanner = new Scanner(System.in);
		String relativeFilePath = "file\\in.txt";
		do {
			processFile(relativeFilePath);
			System.out.println("Do you want to execute again (y/n) ? : ");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'y' || userinput == 'Y');
		scanner.close();
	}

	private static void processFile(String filepath) {
		try {
			File file = new File(filepath);
			Scanner scanner = new Scanner(file);
			int sum = 0;
			int count = 0;
			while (scanner.hasNextInt()) {
				int number = scanner.nextInt();
				int square = number * number;
				sum += square;
				count++;
			}
			scanner.close();
			double average = (double) sum / count;
			System.out.println("Sum of squares: " + sum);
			System.out.println("Average: " + average);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());

		}
	}
}
	
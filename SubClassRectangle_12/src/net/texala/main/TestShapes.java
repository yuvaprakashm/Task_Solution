package net.texala.main;

import java.util.Scanner;

public class TestShapes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			double sideLength = getValidDoubleInput(scanner, "Enter the side length of the square:");

			Square square = new Square(sideLength);

			System.out.println(square.toString());
			System.out.println("Area: " + square.getArea());
			System.out.println("Perimeter: " + square.getPerimeter());

			System.out.println("Do you want to execute again (y/n) ? :");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'Y' || userinput == 'y');
		scanner.close();
	}

	private static double getValidDoubleInput(Scanner scanner, String prompt) {
		double input;
		while (true) {
			System.out.println(prompt);
			if (scanner.hasNextDouble()) {
				input = scanner.nextDouble();
				break;
			} else {
				System.out.println("Invalid input. Please enter a valid numeric value.");
				scanner.next();
			}
		}
		return input;
	}
}

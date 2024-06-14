package net.texala.main;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char userinput;

		do {
			double circleRadius, cylinderRadius;

			circleRadius = getValidDoubleInput("Enter the radius of the Circle: ", sc);

			cylinderRadius = getValidDoubleInput("Enter the radius of the Cylinder: ", sc);
			Circle circle = new Circle(circleRadius);
			Cylinder cylinder = new Cylinder(cylinderRadius);

			System.out.println("\nCircle Information:");
			System.out.println("Radius: " + circle.getRadius());
			System.out.println("Area: " + circle.getArea());
			System.out.println(circle);

			System.out.println("\nCylinder Information:");
			System.out.println("Radius: " + cylinder.getRadius());
			System.out.println("Height: " + cylinder.getHeight());
			System.out.println("Area: " + cylinder.getArea());
			System.out.println(cylinder);

			System.out.println("Do you want to execute again (y/n) ? :");
			userinput = sc.next().charAt(0);

		} while (userinput == 'Y' || userinput == 'y');

		sc.close();
	}

	private static double getValidDoubleInput(String prompt, Scanner scanner) {
		double value;

		while (true) {
			try {
				System.out.print(prompt);
				value = Double.parseDouble(scanner.next());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid number.");
			}
		}

		return value;
	}
}

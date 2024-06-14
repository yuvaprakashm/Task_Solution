/*
DAY : 10
ASSIGNMENT NO:09

The Circle and Cylinder Classes In this exercise, a subclass called Cylinder is derived from the superclass Circle
as shown in the class diagram above (where an arrow is pointing up from the subclass
to its superclass). Study, how the subclass Cylinder invokes the superclass
constructors (via super() and super(radius)) and inherits the variables and
methods from the superclass Circle.
You can reuse the Circle class that you have created in the previous exercise. Make
sure that you keep Circle.class in the same directory.
 
*/
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

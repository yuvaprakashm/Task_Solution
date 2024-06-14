/*

DAY : 10
ASSIGNMENT NO :02

Create a class circle which will have the following variables and method.
Create a Java program by which you can print circle radius and area.

*/

package net.texala.main;

import java.util.Scanner;

public class Circle {
	private double radius;

	public Circle() {
		this.radius = 1.0;
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public double calculateArea() {
		return Math.PI * radius * radius;
	}

	public static void main(String[] args) {
		char userInput;

		Scanner scanner = new Scanner(System.in);
		do {
			double radius1;

			while (true) {
				System.out.print("Enter the radius for Circle : ");
				if (scanner.hasNextDouble()) {
					radius1 = scanner.nextDouble();
					break;
				} else {
					System.out.println("Invalid input. Please enter a valid number for the radius.");
					scanner.next();
				}
			}

			Circle circle1 = new Circle(radius1);

			System.out.println("Circle  - Radius: " + circle1.getRadius());
			System.out.println("Circle  - Area: " + circle1.calculateArea());

			System.out.print("Do you want to execute again (y/n) ? : ");
			userInput = scanner.next().charAt(0);

		} while (userInput == 'Y' || userInput == 'y');

		scanner.close();
	}
}
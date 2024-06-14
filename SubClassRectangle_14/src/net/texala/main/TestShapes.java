/*
 
DAY : 10
ASSIGNMENT NO : 13
 
 
Write a class called Square, as a subclass of Rectangle. Convince yourself that
Square can be modelled as a subclass of Rectangle. Square has no instance
variable, but inherits the instance variables width and length from its superclass
Rectangle.
Provide the appropriate constructors (as shown in the above class diagram).
Hint:
public Square(double side) {
super(side, side); // Call superclass Rectangle(double,
double)
}
·Override the toString() method to return A Square with side=xxx,
which is a subclass of yyy, where yyy is the output of the toString()
method from the superclass.
·Do you need to override the getArea() and getPerimeter()? Try them out.
·Override the setLength() and setWidth() to change both the width and
length, so as to maintain the square geometry.

*/

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

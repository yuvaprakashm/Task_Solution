/*

DAY : 06
ASSIGNMENT NO : 4

Define a class which contains the method DisplayColor which takes one character as
argument. Raise an error if the character is not an alphabet. If the alphabet is a color
of the rainbow, display the color name. If it is any other alphabet, report an error.
Note: Use assertions.


*/
package net.texala.main;

import java.util.Scanner;

public class DisplayColor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			System.out.print("Enter a color alphabet: ");
			char userColor = scanner.next().charAt(0);

			if (Character.isAlphabetic(userColor)) {
				try {
					displayColor(userColor);
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid Input: " + e.getMessage());
				} catch (AssertionError e) {
					System.out.println("Invalid Input: " + e.getMessage());
				}
			} else {
				System.out.println("Please enter an alphabet !");
			}

			System.out.println("Do you want to execute again? (y/n): ");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'y' || userinput == 'Y');
		scanner.close();
	}

	public static void displayColor(char alphabet) {
		char uppercaseAlphabet = Character.toUpperCase(alphabet);
		switch (uppercaseAlphabet) {
		case 'R':
			System.out.println("Color: Red");
			break;
		case 'O':
			System.out.println("Color: Orange");
			break;
		case 'Y':
			System.out.println("Color: Yellow");
			break;
		case 'G':
			System.out.println("Color: Green");
			break;
		case 'B':
			System.out.println("Color: Blue");
			break;
		case 'I':
			System.out.println("Color: Indigo");
			break;
		case 'V':
			System.out.println("Color: Violet");
			break;
		default:
			assert false : "Please Enter a Valid Input !!!";
		}
	}
}

/*
   
 DAY : 8
ASSIGNMENT NO : 1

Write a program in Java to create a String object. Initialize this object with your
name. Find the length of your name using the appropriate String method. Find
whether the character a is there in your name or not; if yes find the number of times a
appears in your name. Print the location of the occurrences of a .Try the same for
different string objects.
Hint: Read each line of the file into a string array (in the usual way). Now use the
charAt() method in a loop to access the characters one by one.

*/

package net.texala.main;

import java.util.Scanner;

public class StringHandling {
	public static void main(String[] args) {
		char userinput;
		Scanner scr = new Scanner(System.in);

		do {
			String name;
			do {
				System.out.println("Enter your name:");
				name = scr.nextLine();

				if (!isValidName(name)) {
					System.out.println("Invalid input! Please enter a valid name with alphabets only.");
				}
			} while (!isValidName(name));

			int nameLength = name.length();
			System.out.println("Length of your name: " + nameLength);

			boolean containsA = name.toLowerCase().contains("a");
			System.out.println("Does your name contain 'a'? : " + (containsA ? "Yes" : "No"));

			if (containsA) {
				int countA = 0;
				System.out.println("Position of 'a' in your name:");
				for (int i = 0; i < nameLength; i++) {
					if (name.charAt(i) == 'a' || name.charAt(i) == 'A') {
						countA++;
						System.out.println((i + 1) + " ");
					}
				}
				System.out.println("The number of times 'a' appears in your name: " + countA);
			} else {
				System.out.println("'a' not found in your name!");
			}

			System.out.println("Do you want to execute again (y/n)? :");
			userinput = scr.next().charAt(0);
			scr.nextLine();
		} while (userinput == 'y' || userinput == 'Y');

		scr.close();
	}

	private static boolean isValidName(String name) {
		return name.matches("[a-zA-Z]+");
	}
}

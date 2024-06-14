/*
   
DAY : 8
ASSIGNMENT NO : 2

Write a program that determines the number of consonants, vowels, punctuation
characters, and spaces in an input line.
Hint: Read each line of the file into a string array (in the usual way). Now use the
charAt() method in a loop to access the characters one by one. Use a switch statement to
increment the appropriate variables based on the current character. After processing the line,
print out the results.

*/

package net.texala.main;

import java.util.Scanner;

public class StringArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			System.out.print("Enter a line of text: ");
			String inputLine = scanner.nextLine();

			int vowels = 0;
			int consonants = 0;
			int punctuation = 0;
			int spaces = 0;

			for (int i = 0; i < inputLine.length(); i++) {
				char ch = inputLine.charAt(i);

				switch (Character.toLowerCase(ch)) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					vowels++;
					break;
				case ' ':
					spaces++;
					break;
				case ',':
				case '.':
				case '!':
				case '?':
				case ';':
				case ':':
					punctuation++;
					break;
				default:
					if (Character.isLetter(ch)) {
						consonants++;
					}
				}
			}

			System.out.println("Vowels: " + vowels);
			System.out.println("Consonants: " + consonants);
			System.out.println("Punctuation: " + punctuation);
			System.out.println("Spaces: " + spaces);
			System.out.println("Do you want to execute again (y/n) ? :");
			userinput = scanner.next().charAt(0);
			scanner.nextLine();

		} while (userinput == 'Y' || userinput == 'y');

		scanner.close();
	}
}
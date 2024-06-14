/*
Day : 02
ASSIGNMENT : 08

Write a Bin2Octal program to convert an input binary string into its equivalent decimal number.
Output should look like the following.
Enter a Binary string: 1011
The Octal number that is equivalent to binary 1011 is 13.
Enter a Binary string: 1234
Error: Invalid Binary String 1234
 
 */
package net.texala.main;

import java.util.Scanner;

public class BinaryToOctal {

	public static String binToOctal(String binaryStr) {
		try {

			int decimalNum = Integer.parseInt(binaryStr, 2);

			String octalNum = Integer.toOctalString(decimalNum);

			return octalNum;
		} catch (NumberFormatException e) {

			return null;
		}
	}

	private static boolean isValidBinaryInput(String str) {
		return str.matches("[01]+");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;

		do {

			String binaryInput;
			do {
				System.out.print("Enter a Binary string: ");
				binaryInput = scanner.nextLine();

				if (isValidBinaryInput(binaryInput)) {
					break;
				} else {
					System.out.println("Error: Invalid Binary String " + binaryInput);
				}
			} while (true);

			String octalOutput = binToOctal(binaryInput);

			if (octalOutput != null) {
				System.out.println("The Octal number equivalent to binary " + binaryInput + " is " + octalOutput + ".");
			} else {
				System.out.println("Error: Invalid Binary String " + binaryInput);
			}

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
			scanner.nextLine();

		} while (userinput == 'y' || userinput == 'Y');

		scanner.close();
	}
}

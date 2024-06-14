/*

Day : 02
ASSIGNMENT : 09


Write a Hex2Dec program to convert an input hexadecimal string into its equivalent decimal number.
Output should look like the following.
Enter a Hexadecimal string: 1a
The equivalent decimal number for hexadecimal 1a is 26
Enter a Hexadecimal string: 1y3
Error: Invalid Hexadecimal String 1y3

*/

package net.texala.main;

import java.util.Scanner;

public class HexadecimalToDecimal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;

		do {
			String hexStr;
			int decimalNum;

			while (true) {
				System.out.print("Enter a Hexadecimal string: ");
				hexStr = scanner.nextLine();

				try {
					decimalNum = convertHexToDecimal(hexStr);
					break;
				} catch (NumberFormatException e) {
					System.out.println("Error: Invalid hexadecimal string. Please enter a valid hexadecimal string.");
				}
			}

			System.out.println("The equivalent decimal number for hexadecimal " + hexStr + " is " + decimalNum);

			System.out.println("Do you want to execute again (y/n)?");
			userinput = scanner.next().charAt(0);
			scanner.nextLine();

		} while (userinput == 'y' || userinput == 'Y');

		scanner.close();
	}

	private static int convertHexToDecimal(String hexStr) {
		int decimalNum = 0;

		for (int i = 0; i < hexStr.length(); i++) {
			char hexChar = hexStr.charAt(i);

			int digitValue;

			if (hexChar >= '0' && hexChar <= '9') {
				digitValue = hexChar - '0';
			} else if (hexChar >= 'a' && hexChar <= 'f') {
				digitValue = hexChar - 'a' + 10;
			} else if (hexChar >= 'A' && hexChar <= 'F') {
				digitValue = hexChar - 'A' + 10;
			} else {
				throw new NumberFormatException();
			}

			decimalNum = decimalNum * 16 + digitValue;
		}

		return decimalNum;
	}
}

/*

DAY : 03
ASSIGNMENT NO : 02

Write a Hex2Decimal program to convert a hexadecimal string into its equivalent
binary string.
Output should look like the following.
Enter a Hexadecimal string: 1abc
The equivalent Decimal for hexadecimal 1abc is 0001101010111100

 
 */

package net.texala.main;

import java.util.Scanner;

public class HexadecimalToDecimalArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char userInput;

        String[] hexBits = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010",
                "1011", "1100", "1101", "1110", "1111"};

        do {
            String hexString;
            boolean invalidHex;

            do {
                System.out.print("Enter a Hexadecimal string: ");
                hexString = scanner.nextLine().toUpperCase();
                invalidHex = false;

                for (int i = 0; i < hexString.length(); i++) {
                    char hexChar = hexString.charAt(i);

                    if (!(Character.isDigit(hexChar) || (hexChar >= 'A' && hexChar <= 'F'))) {
                        System.out.println("Invalid hexadecimal digit: " + hexChar);
                        invalidHex = true;
                        break;
                    }
                }
            } while (invalidHex);

            StringBuilder binaryString = new StringBuilder();

            for (int i = 0; i < hexString.length(); i++) {
                char hexChar = hexString.charAt(i);
                int digitValue;

                if (Character.isDigit(hexChar)) {
                    digitValue = Character.getNumericValue(hexChar);
                } else {
                    digitValue = hexChar - 'A' + 10;
                }

                binaryString.append(hexBits[digitValue]);
            }

            System.out.println("The equivalent Decimal for hexadecimal " + hexString + " is " + binaryString.toString());

            System.out.println("Do you want to run again? (y/n) :");
            userInput = scanner.next().charAt(0);
            scanner.nextLine();   

        } while (userInput == 'y' || userInput == 'Y');
        
        scanner.close();
    }
}

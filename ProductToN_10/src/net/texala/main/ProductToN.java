/*
 
Day: 01
Assignment No: 10

Write a Product1ToN program to compute the product of integers 1 to 10 (that is,
1×2×3×...×10). Try computing the product from 1 to 11, 1 to 12, 1 to 13 and 1 to 14.
Write down the product obtained and explain the results.


 */

package net.texala.main;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductToN {
    public static void main(String[] args) {
        char userinput;

        Scanner scanner = new Scanner(System.in);
        do {
            int start = getValidInput("Enter the starting number: ", scanner);
            int end = getValidInput("Enter the ending number: ", scanner);

            BigInteger product = computeProduct(start, end);

            System.out.println("Product of integers from " + start + " to " + end + ": " + product);

            System.out.println("Do you want to execute again (y/n)?");
            userinput = scanner.next().charAt(0);
        } while (userinput == 'Y' || userinput == 'y');

        scanner.close();
    }

    private static int getValidInput(String message, Scanner scanner) {
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(message);
                number = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        return number;
    }

    private static BigInteger computeProduct(int start, int end) {
        BigInteger product = BigInteger.ONE;
        for (int i = start; i <= end; i++) {
            product = product.multiply(BigInteger.valueOf(i));
        }
        return product;
    }
}

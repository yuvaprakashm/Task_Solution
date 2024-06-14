/*

DAY : 04
ASSIGNMENT NO : 07

the factorials that can be
expressed as an int (that is, 32-bit signed integer). Output should look like the
following.
The factorial of 1 is 1
The factorial of 2 is 2
...
The factorial of 12 is 479001600
The factorial of 13 is out of range
 
 
 
 */

package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FactorialIntN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char userinput;
        do {
            int inputNumber;

            
            while (true) {
                try {
                    System.out.print("Enter a number to calculate factorial: ");
                    inputNumber = scanner.nextInt();
                    break; 
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine();  
                }
            }

            for (int n = 1; n <= inputNumber; n++) {
                try {
                    int factorial = computeFactorial(n);
                    System.out.println("The factorial of " + n + " is " + factorial);
                } catch (ArithmeticException e) {
                    System.out.println("The factorial of " + n + " is out of range");
                    break;
                }
            }
            System.out.println("Do you want to run again? (y/n) :");
            userinput = scanner.next().charAt(0);
        } while (userinput == 'y' || userinput == 'Y');

        scanner.close();
    }

    private static int computeFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            if (result > Integer.MAX_VALUE / i) {
                throw new ArithmeticException("Overflow occurred for Factorial(" + (n + 1) + ")");
            }
            result = result * i;
        }

        return result;
    }
}


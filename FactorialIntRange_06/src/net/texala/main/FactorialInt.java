/*

DAY : 04
ASSIGNMENT NO : 06

Write a Factorial1to10 program to compute the factorial of n, for 1?n?10.
Output should look like the following.
The factorial of 1 is 1
The factorial of 2 is 2
...
The factorial of 10 is 3628800
 
 
 */

package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FactorialInt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char userinput;

		do {
			int n1;
			 
			while (true) {
				try {
					System.out.println("Enter a number to calculate factorial: ");
					n1 = sc.nextInt();
					if (n1 < 0) {
						System.out.println("Please enter a valid non-negative number.");
						continue;
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter a valid integer.");
					sc.nextLine();
				}
			}

			for (int n = 1; n <= n1; n++) {
				long factorial = computeFactorial(n);
				System.out.println("The factorial of " + n + " is " + factorial);
			}

			System.out.println("Do you want to execute again (y/n):");
			sc.nextLine();
			userinput = sc.next().charAt(0);

		} while (userinput == 'y' || userinput == 'Y');

		sc.close();
	}

	private static long computeFactorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		long result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}

		return result;
	}
}

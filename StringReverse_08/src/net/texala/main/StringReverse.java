/*

DAY : 03
ASSIGNMENT NO : 08 

Write a reverseArray() method with the following signature.
public static void reverseArray(int[] intArray)
The method accepts an int array, and reverses its order.
For example, if the input array is {12, 56, 34, 79, 26}, the reversal is {26,
79, 34, 56, 12}. You MUST NOT use another array in your method (but you
need a temporary variable to do the swap).


 */

package net.texala.main;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		char userinput;
		Scanner scanner = new Scanner(System.in);
		do {
			int size = getValidNumber(scanner, "Enter the size of the array: ");

			int[] intArray = new int[size];

			System.out.println("Enter numbers for the array:");
			for (int i = 0; i < size; i++) {
				intArray[i] = getValidNumber(scanner, "Element " + (i + 1) + ": ");
			}

			System.out.println("Original Array: " + Arrays.toString(intArray));

			reverseArray(intArray);

			System.out.println("Reversed Array: " + Arrays.toString(intArray));

			System.out.println("Do you want to execute (y/n) ? : ");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'Y' || userinput == 'y');
		scanner.close();
	}

	public static void reverseArray(int[] intArray) {
		int start = 0;
		int end = intArray.length - 1;

		while (start < end) {

			int temp = intArray[start];
			intArray[start] = intArray[end];
			intArray[end] = temp;

			start++;
			end--;
		}
	}

	private static int getValidNumber(Scanner scanner, String prompt) {
		int number;
		while (true) {
			try {
				System.out.print(prompt);
				number = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Error: Please enter a valid number.");
				scanner.nextLine();
			}
		}
		return number;
	}
}

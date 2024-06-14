/*
DAY : 03
ASSIGNMENT NO : 09

Take an input of number array where length of the array is even and is more than
two. Write a method which returns an array of middle two numbers.

makeMiddle({1,2,3,4})?{2,3}
makeMiddle({7,1,2,3,4,9})?{2,3}
makeMiddle({1, 2}) ? {1, 2}
]


 */

package net.texala.main;

import java.util.Arrays;
import java.util.Scanner;

public class EvenArray {
	public static void main(String[] args) {
		char userInput;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Enter the array:");
			String input = scanner.nextLine();
			String[] strArray = input.split(" ");

			try {
				int[] array = Arrays.stream(strArray).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();      //Array.stream - convert array into stream 
																															//filter(s -> !s.isEmpty()) - check whether string is empty
				int[] result = makeMiddle(array);																			//mapToInt(Integer::parseInt) - convert empty string into integer
				System.out.println("The result for array = " + Arrays.toString(result));									//.toArray() - collect parsed integer into integer
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter valid integers.");
			}

			System.out.println("Do you want to run again? (y/n) :");
			userInput = scanner.next().charAt(0);

			scanner.nextLine();

		} while (userInput == 'y' || userInput == 'Y');
	}

	public static int[] makeMiddle(int[] nums) {
		try {
			if (nums.length % 2 == 0 && nums.length > 2) {
				int middleIndex = nums.length / 2 - 1;
				int[] result = { nums[middleIndex], nums[middleIndex + 1] };
				return result;
			} else {
				throw new IllegalArgumentException("Array length must be even and greater than 2.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return new int[0];
		}
	}
}

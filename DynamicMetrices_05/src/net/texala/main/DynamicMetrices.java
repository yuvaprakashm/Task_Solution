/*

 DAY : 03
ASSIGNMENT : 05

Create dynamic metrics by taking the input from the command line argument, sort
them and add the diagonal metrics.
2 3 5
3 3 7
8 3 9


 */

package net.texala.main;

import java.util.Arrays;

public class DynamicMetrices {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No input provided. Please provide a matrix as command-line arguments.");
			return;
		}

		int n = (int) Math.sqrt(args.length);
		if (n * n != args.length) {
			System.out.println("Invalid matrix input. Number of elements should be a perfect square.");
			return;
		}

		int[][] matrix = new int[n][n];
		int[] sortedElements = new int[args.length];

		for (int i = 0; i < args.length; i++) {
			matrix[i / n][i % n] = Integer.parseInt(args[i]);
			sortedElements[i] = matrix[i / n][i % n];
		}

		Arrays.sort(sortedElements);

		System.out.println("Original Matrix:");
		printMatrix(matrix);

		System.out.println("\nSorted Elements:");
		printArray(sortedElements);

		int diagonalSum = addDiagonalElements(matrix);

		System.out.println("\nSum of Diagonal Elements: " + diagonalSum);
	}

	private static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	private static void printArray(int[] array) {
		for (int element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	private static int addDiagonalElements(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][i];
		}
		return sum;
	}
}

/*

DAY : 04
ASSIGNMENT NO : 02

write a Matrix library that supports matrix operations (such
as addition, subtraction, multiplication) via 2D arrays. The operations shall support
both doubles and int. Also write a test class to exercise all the operations
programmed.


 */

package net.texala.main;

import java.util.Scanner;

public class Matrix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			Matrix aMatrix = new Matrix();

			System.out.println("Enter Matrix A:");
			int[][] a = aMatrix.readMatrix(scanner);
			aMatrix.printMatrix(a);

			System.out.println("Enter Matrix B:");
			int[][] b = aMatrix.readMatrix(scanner);
			aMatrix.printMatrix(b);

			if (aMatrix.haveSameDimension(a, b)) {
				System.out.println("Add matrix A and B:");
				aMatrix.printMatrix(aMatrix.add(a, b));

				System.out.println("\nSubtract matrix A from B:");
				aMatrix.printMatrix(aMatrix.subtract(b, a));

				System.out.println("\nMultiply matrix A and B:");
				aMatrix.printMatrix(aMatrix.multiply(a, b));
			} else {
				System.out.println("Matrices must have the same dimensions for addition, subtraction, and multiplication.");
			}
			System.out.println("Do you want to run again ? (y/n) :");
			userinput = scanner.next().charAt(0);

		} while (userinput == 'y' || userinput == 'Y');
	}

	public int[][] readMatrix(Scanner scanner) {
		System.out.print("Enter number of rows: ");
		int rows = scanner.nextInt();

		System.out.print("Enter number of columns: ");
		int cols = scanner.nextInt();

		int[][] matrix = new int[rows][cols];

		System.out.println("Enter matrix elements:");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("Enter element at position (%d, %d): ", i + 1, j + 1);
				matrix[i][j] = scanner.nextInt();
			}
		}

		return matrix;
	}

	public void printMatrix(int[][] m) {
		for (int[] row : m) {
			for (int aInt : row) {
				System.out.printf("%4d ", aInt);
			}
			System.out.println();
		}
	}

	public static boolean haveSameDimension(int[][] m1, int[][] m2) {
		if (m1.length != m2.length) {
			return false;
		}
		for (int i = 0; i < m1.length; i++) {
			if (m1[i].length == m2[i].length) {
				continue;
			}
			return false;
		}
		return true;
	}

	public boolean haveAllowedDimension(int[][] m1, int[][] m2) {
		int maxLengthM1 = getMaxRowLength(m1);
		int maxLengthM2 = getMaxRowLength(m2);

		for (int i = 0; i < m1.length; i++) {
			if (m1[i].length == maxLengthM1) {
				continue;
			}
			return false;
		}

		for (int i = 0; i < m2.length; i++) {
			if (m2[i].length == maxLengthM2) {
				continue;
			}
			return false;
		}

		return m1[0].length == m2.length;
	}

	private int getMaxRowLength(int[][] matrix) {
		int maxLength = 0;
		for (int[] row : matrix) {
			maxLength = Math.max(maxLength, row.length);
		}
		return maxLength;
	}

	public int[][] multiply(int[][] m1, int[][] m2) {
	    int rowsA = m1.length;
	    int colsA = m1[0].length;
	    int rowsB = m2.length;
	    int colsB = m2[0].length;

	    if (colsA != rowsB) {
	        System.out.println("Matrices A and B cannot be multiplied due to incompatible dimensions.");
	        return null;   
	    }

	    int[][] result = new int[rowsA][colsB];

	    for (int i = 0; i < rowsA; i++) {
	        for (int j = 0; j < colsB; j++) {
	            for (int k = 0; k < colsA; k++) {
	                result[i][j] += m1[i][k] * m2[k][j];
	            }
	        }
	    }

	    return result;
	}


	public int[][] add(int[][] m1, int[][] m2) {
		int[][] result = new int[m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				result[i][j] = m1[i][j] + m2[i][j];
			}
		}
		return result;
	}

	public int[][] subtract(int[][] m1, int[][] m2) {
		int[][] result = new int[m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				result[i][j] = m2[i][j] - m1[i][j];
			}
		}
		return result;
	}
}

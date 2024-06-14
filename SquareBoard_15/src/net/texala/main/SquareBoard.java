/*
Day: 01
Assignment No: 15

Write a SquareBoard program that displays the following n×n (n=5) pattern using
two nested for-loops.
******
** **
** **
** **
** **
*****

 */
package net.texala.main;

public class SquareBoard {
	public static void main(String[] args) {
		int n = 6;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 || i == n || j == 1 || j == n || j < n / 2 || j == 5) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}

			System.out.println();
		}

	}
}

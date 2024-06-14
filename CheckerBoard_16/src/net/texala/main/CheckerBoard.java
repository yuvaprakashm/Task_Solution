/*

 Day: 01
Assignment No: 16

Write a CheckerBoard program that displays the following n×n (n=7) in
checkerboard pattern using two nested for-loops.

1 0 1 0 1 0 1
0 1 0 1 0 1 0
1 0 1 0 1 0 1
0 1 0 1 0 1 0
1 0 1 0 1 0 1
0 1 0 1 0 1 0
1 0 1 0 1 0 1


 */

package net.texala.main;

public class CheckerBoard {
	public static void main(String[] args) {
		int n = 7;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i + j) % 2 == 0) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println("\t");
		}
	}
}

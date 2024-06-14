/*
 DAY : 05
ASSIGNMENT : 2c


        1
       1 1
      1 2 1
     1 3 3 1
    1 4 6 4 1
   1 5 10 10 5 1
  1 6 15 20 15 6 1

*/
package net.texala.main;


public class PascalTriangleB {

	static int factorial(int n) {
		int f;

		for (f = 1; n > 1; n--) {
			f *= n;
		}
		return f;
	}

	static int ncr(int n, int r) {
		return factorial(n) / (factorial(n - r) * factorial(r));
	}

	public static void main(String args[]) {
		System.out.println();
		int n, i, j;
		n = 6;

		for (i = 0; i <= n; i++) {
			for (j = 0; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (j = 0; j <= i; j++) {
				System.out.print(" " + ncr(i, j));
			}
			System.out.println();
		}
	}
}

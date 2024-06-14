/*
  DAY : 05
ASSIGNMENT : 2a

                 1
               1 2 1
             1 2 4 2 1
           1 2 4 8 4 2 1
         1 2 4 8 16 8 4 2 1
       1 2 4 8 16 32 16 8 4 2 1
     1 2 4 8 16 32 64 32 16 8 4 2 1
   1 2 4 8 16 32 64 128 64 32 16 8 4 2 1

   
*/
package net.texala.main;

public class PowerOfTriangle {
	public static void main(String[] args) {
		int i, j, k, l, a;

		int rows = 8;
		a = rows;

		int length = ("" + rows).length();
		String str = " %" + length + "s";

		for (i = 1; i <= rows; i++) {
			for (j = a; j > 0; j--) {
				System.out.printf(str, " ");
			}

			for (j = 1; j <= (2 * rows); j++) {
				if (j == (rows + 1)) {
					continue;
				}

				if (j < (rows + 1)) {
					k = j;
				} else {
					k = ((2 * rows) - j + 1);
				}

				if (k >= (rows + 1 - i)) {
					l = (int) Math.pow(2, (i + k - rows - 1));
					String str1 = "" + l;
					System.out.printf(str, str1);
				}
			}
			a--;
			System.out.println();
		}
	}
}

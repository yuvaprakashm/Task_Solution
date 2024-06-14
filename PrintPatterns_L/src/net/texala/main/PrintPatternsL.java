/*
  DAY : 05
ASSIGNMENT : L

              1 
            2 3 2 
          3 4 5 4 3 
        4 5 6 7 6 5 4 
      5 6 7 8 9 8 7 6 5 
    6 7 8 9 0 1 0 9 8 7 6 
  7 8 9 0 1 2 3 2 1 0 9 8 7 
8 9 0 1 2 3 4 5 4 3 2 1 0 9 8 

*/
package net.texala.main;

public class PrintPatternsL {
	public static void main(String[] args) {
		int rows = 8;

		for (int i = 1; i <= rows; i++) {

			for (int j = 1; j <= rows - i; j++) {
				System.out.print("  ");
			}

			for (int k = i; k <= 2 * i - 1; k++) {
				int num = k % 10;
				System.out.print(num + " ");
			}

			for (int l = 2 * i - 2; l >= i; l--) {
				int num = l % 10;
				System.out.print(num + " ");
			}

			System.out.println();
		}
	}
}

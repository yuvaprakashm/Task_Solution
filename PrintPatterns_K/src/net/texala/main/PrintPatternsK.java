/*
DAY : 05
ASSIGNMENT : K 

1                           1 
1 2                       2 1 
1 2 3                   3 2 1 
1 2 3 4               4 3 2 1 
1 2 3 4 5           5 4 3 2 1 
1 2 3 4 5 6       6 5 4 3 2 1 
1 2 3 4 5 6 7   7 6 5 4 3 2 1 
1 2 3 4 5 6 7 8 7 6 5 4 3 2 1 


*/
package net.texala.main;

public class PrintPatternsK {
	public static void main(String[] args) {

		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 2 * 8; j++) {
				if (j % (8 + 1) == 0) {
					continue;
				} else if ((j <= 8) && (j > i)) {
					System.out.print(" ");
				} else if ((j > 8 + 1) && (j < 2 * 8 - i + 1)) {
					System.out.print(" ");
				} else if (j <= 8) {
					System.out.print(j % (8 + 1));
				} else {
					System.out.print(2 * 8 - j + 1);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
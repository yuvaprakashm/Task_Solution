/*
 
DAY : 05
ASSIGNMENT : A

  
0  
1 0  
0 1 0  
1 0 1 0 
0 1 0 1 0  
1 0 1 0 1 0  
0 1 0 1 0 1 0  
1 0 1 0 1 0 1 0
  
 */

package net.texala.main;

public class PrintPatternsA {
	public static void main(String[] args) {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print((i + j) % 2 + " ");

			}
			System.out.println();
		}
	}
}

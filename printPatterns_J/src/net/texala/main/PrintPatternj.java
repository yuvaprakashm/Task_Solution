/*

DAY : 05
ASSIGNMENT : J

1 2 3 4 5 6 7 8 7 6 5 4 3 2 1   
  1 2 3 4 5 6 7 6 5 4 3 2 1     
    1 2 3 4 5 6 5 4 3 2 1       
      1 2 3 4 5 4 3 2 1         
        1 2 3 4 3 2 1           
          1 2 3 2 1             
            1 2 1               
              1 
              
 */

package net.texala.main;

public class PrintPatternj {
	public static void main(String[] args) {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 2 * 8; j++) {
				if (j <= 8 && j >= i) {
					System.out.print((j - i + 1));
				} else if (j > 8 && j < 2 * 8 - i + 1) {
					System.out.print(8 - (j + i - 1) % 8);
				} else {
					System.out.print(" ");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
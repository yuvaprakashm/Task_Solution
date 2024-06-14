/*

DAY : 05
ASSIGNMENT : I

8 7 6 5 4 3 2 1 
  7 6 5 4 3 2 1 
    6 5 4 3 2 1 
      5 4 3 2 1 
        4 3 2 1 
          3 2 1 
            2 1 
              1  
              
*/
package net.main.texala;

public class PrintPatternI {
	public static void main(String[] args) {

		for (int i = 8; i >= 1; i--) {

			for (int k = 8; k > i; k--) {
				System.out.print("  ");
			}

			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}

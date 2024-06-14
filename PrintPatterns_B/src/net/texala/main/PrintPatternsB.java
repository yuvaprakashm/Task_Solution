/*
  
DAY : 05
ASSIGNMENT : B
 
#
# #
# # #
# # # #
# # # # #
# # # # # #
# # # # # # #
# # # # # # # #

 */

package net.texala.main;

public class PrintPatternsB {
	public static void main(String[] args) {
		for (int i = 8; i >= 1; i--) {
			for (int j = 1; j <= 8; j++) {
				if (j >= i) {
					System.out.print("# ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}

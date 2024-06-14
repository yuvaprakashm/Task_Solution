/*
DAY : 05
ASSIGNMENT : E
 
# # # # # # # 
# #       # # 
#   #   #   # 
#     #     # 
#   #   #   # 
# #       # # 
# # # # # # # 


*/

package net.texala.main;

public class PrintPatternE {
	public static void main(String[] args) {
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				if ((i % 7 <= 1) || (j % 7 <= 1) || (i == j) || (i + j == 7 + 1)) {
					System.out.print("# ");
					continue;
				}
				System.out.print("  ");
			}
			System.out.println();
		}
	}
}

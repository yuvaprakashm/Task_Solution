/*
 
DAY : 05
ASSIGNMENT : C 

# # # # # # # 
#     #     # 
#     #     # 
# # # # # # # 
#     #     # 
#     #     # 
# # # # # # # 


 */

package net.texala.mian;

public class PrintPatternsC {
	public static void main(String[] args) {

		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				if (i % 7 <= 1 || j % 7 <= 1 || j == 8 / 2 || i == 8 / 2) {
					System.out.print("# ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}

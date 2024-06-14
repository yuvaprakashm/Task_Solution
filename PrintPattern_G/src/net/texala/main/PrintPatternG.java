/*

DAY : 05
ASSIGNMENT : G

# # # # # # # # # # # # # # 
          # # # 
        # # # # # 
      # # # # # # # 
    # # # # # # # # # 
  # # # # # # # # # # # 
# # # # # # # # # # # # # 
# # # # # # # # # # # # # # 
# # # # # # # # # # # # # 
  # # # # # # # # # # # 
    # # # # # # # # # 
      # # # # # # # 
        # # # # # 
          # # # 
# # # # # # # # # # # # # # 


*/

package net.texala.main;

public class PrintPatternG {

	public static void main(String[] args) {
		int n = 0;
		while (n <= 2 * 7) {
			int i = Math.abs(7 - n);
			if (i == 0 || i == 7) {

				for (int k = 1; k <= 2 * 7; k++) {
					System.out.print("# ");
				}
			} else {
				for (int j = 1; j <= 2 * 7 - i; j++) {
					if (j >= i) {
						System.out.print("# ");
						continue;
					}
					System.out.print("  ");
				}
			}
			System.out.println();
			n++;
		}
	}
}
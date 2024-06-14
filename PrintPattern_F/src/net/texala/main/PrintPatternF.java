/*


DAY : 05
ASSIGNMENT : F

# # # # # # # # # # # # # 
  # # # # # # # # # # # 
    # # # # # # # # # 
      # # # # # # # 
        # # # # # 
          # # # 
            # 


*/

package net.texala.main;

public class PrintPatternF {
	public static void main(String[] args) {

		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 2 * 7 - i; j++) {
				if (j >= i) {
					System.out.print("# ");
					continue;
				}
				System.out.print("  ");
			}
			System.out.println();
		}

	}
}

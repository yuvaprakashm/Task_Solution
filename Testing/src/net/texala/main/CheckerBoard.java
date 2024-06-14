package net.texala.main;

public class CheckerBoard {
	public static void main(String[] args) {
		int n = 7;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i + j) % 2 == 0) {
					System.out.print("1 ");
				} else {

					if (i % 2 != 0)
						System.out.print(" ");
					System.out.print("0 ");
				}
			}
			System.out.println("\t");
		}
	}
}

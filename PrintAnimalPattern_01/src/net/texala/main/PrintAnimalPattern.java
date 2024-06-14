package net.texala.main;

class PrintAnimalPattern {
	public static void main(String[] args) {
		int n = 6;
		String str = "TEXALA";
		for (int i = 0; i < str.length(); i++)
			System.out.println(str.charAt(i) + " ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || i + j == n - 1)

					System.out.print("*" + " ");

				else
					System.out.print(" " + " ");
			}
			System.out.println();
		}
		
	}
}
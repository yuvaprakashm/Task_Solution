package codesheat.main;

public class main {
	public static void main(String[] args) {
		int n = 25479;
		String s = Integer.toString(n);
		int fd = s.charAt(0) - '0';
		int ld = s.charAt(s.length()- 1) - '0';
		System.out.println("Firstdigit" +fd);
		System.out.println("Firstdigit" +ld);
		
		
	}
}

package codesheat.main;

public class demo {
	public static int fn(int n) {
		while(n>=10)
			n=n/10;
		return n;
	}
public static int ln(int n) {
		return (n%10);
	}
public static void main(String[] args) {
	int n=456456;
	System.out.println(fn(n));
	System.out.println(ln(n));
}
}

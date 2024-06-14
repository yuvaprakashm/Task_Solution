package codesheat.main;

//public class Demos {
//	public static void main(String[] args) {
//		int n=456547;
//		countDigit(n);
//	}
//
//	private static void countDigit(int n) {
//		 String num =Integer.toString(n);
//		 System.out.println(+num.length());
//		
//	}
//}
public class Demos{
	

	private static int count(long n) {
		 int count =0;
		 while(n!=0) {
			n=n/10;
			++count;
		 }
		 return count;
	}
	public static void main(String[] args) {
		long n = 536456454;
		System.out.println("the no of digits :"+count(n));
	}
	}

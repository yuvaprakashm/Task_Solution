/*
 
DAY : 06
ASSIGNMENT NO : 7

Write a program for generating two (2) threads, one for printing even numbers and
other for printing odd numbers.

*/
package net.texala.main;

public class ThreadsEvenOrOdd extends Thread {
	public static void main(String[] args) {
		odd o = new odd();
		Thread t1 = new Thread(o);
		t1.start();
		even e = new even();
		Thread t2 = new Thread(e);
		t2.start();
	}
}

class odd extends Thread {
	public void run() {
		for (int i = 0; i < 11; i++) {
			if (i % 2 == 1)
				System.out.println("It displays all the ODD Threads : "+i);
		}
	}
}

class even extends Thread {
	public void run() {
		for (int i = 0; i < 11; i++) {
			if (i % 2 == 0)
				System.out.println("It displays all the EVEN Threads :"+i);
		}

	}
}
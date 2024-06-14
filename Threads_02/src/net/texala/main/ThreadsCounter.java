/*
 
DAY : 06
ASSIGNMENT NO : 6

Write a program to launch ten (10) threads. Each thread increments a counter
variable. Run the program with synchronization.

 */
package net.texala.main;

public class ThreadsCounter {
	private static int counter = 0;

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			Thread thread = new Thread(new CounterIncrementer(), "Thread-" + i);
			thread.start();
		}
	}

	private synchronized static void incrementCounter() {		// it is declared as synchronized to avoid race condition which means at a time only one thread can access a single thread 
		counter++;
		System.out.println(Thread.currentThread().getName() + ": Counter = " + counter);
	}

	private static class CounterIncrementer implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				incrementCounter();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

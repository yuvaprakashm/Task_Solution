/*

DAY : 06
ASSIGNMENT NO : 5

Write a Java program to create five threads with different priorities. Send two
threads of the highest priority to sleep state. Check the aliveness of the threads and
mark which thread is long lasting.
Hint: Use Thread.setPriority(5);
And Thread.sleep(1000);

*/
package net.texala.main;

public class FiveThreads extends Thread {
	public void run() {
		try {
			Thread.sleep(1000);

			System.out.println("Is run() method is alive : " + Thread.currentThread().isAlive());
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FiveThreads t1 = new FiveThreads();
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();

		FiveThreads t2 = new FiveThreads();
		t2.setPriority(Thread.MAX_PRIORITY);
		t2.start();

		FiveThreads t3 = new FiveThreads();
		t3.setPriority(Thread.NORM_PRIORITY);
		t3.start();

		FiveThreads t4 = new FiveThreads();
		t4.setPriority(Thread.MIN_PRIORITY);
		t4.start();

		FiveThreads t5 = new FiveThreads();
		t5.setPriority(Thread.MIN_PRIORITY);
		t5.start();

		System.out.println("Before starting thread is alive :" + t1.isAlive());

		try {
			t1.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("After making t1 sleep, thread is alive: " + t1.isAlive());
		System.out.println("Before starting thread t5 is alive: " + t5.isAlive());

		try {
			t5.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String longLastingThread = (t1.isAlive() ? "t1 is long-lasting"
				: (t5.isAlive() ? "t5 is long-lasting" : "No thread is long-lasting"));
		System.out.println(longLastingThread);

	}

}
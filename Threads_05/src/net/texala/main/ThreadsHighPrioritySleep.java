/*
 DAY : 06
ASSIGNMENT NO : 9
Write a Java program that demonstrates a high-priority thread using sleep to give
lower- priority thread a chance to run.

*/
package net.texala.main;

public class ThreadsHighPrioritySleep {

	public static void main(String[] args) {

		Thread highPriorityThread = new Thread(new PriorityTask(), "HighPriorityThread");
		highPriorityThread.setPriority(Thread.MAX_PRIORITY);
		highPriorityThread.start();

		Thread lowPriorityThread = new Thread(new PriorityTask(), "LowPriorityThread");
		lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
		lowPriorityThread.start();
	}

	static class PriorityTask extends Thread {
		public void run() {
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + ": Count " + i);

				try {

					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
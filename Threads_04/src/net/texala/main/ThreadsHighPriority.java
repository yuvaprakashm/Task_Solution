/*
 DAY : 06
ASSIGNMENT NO : 8

 Write a Java program to demonstrate that when a high-priority thread executes, it
will delay the execution of all the lower-priority threads. 

 */
package net.texala.main;

public class ThreadsHighPriority {

	public static void main(String[] args) {

		Thread lowPriorityThread = new Thread(new MyRunnable(), "LowPriorityThread");
		Thread normalPriorityThread = new Thread(new MyRunnable(), "NormalPriorityThread");
		Thread highPriorityThread = new Thread(new MyRunnable(), "HighPriorityThread");

		lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
		normalPriorityThread.setPriority(Thread.MIN_PRIORITY);

		highPriorityThread.setPriority(Thread.MAX_PRIORITY);

		lowPriorityThread.start();
		normalPriorityThread.start();
		highPriorityThread.start();
	}

	static class MyRunnable implements Runnable {
		@Override
		public void run() {
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + " - Count: " + i);

				try {

					if (Thread.currentThread().getPriority() != Thread.MAX_PRIORITY) {
						Thread.sleep(3000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

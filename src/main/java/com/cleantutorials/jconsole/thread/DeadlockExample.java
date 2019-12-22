package com.cleantutorials.jconsole.thread;

/**
 * DeadlockExample's main method demonstrates a very simple deadlock situation.
 */
public class DeadlockExample {

	public static void main(String[] args) {

		// Objects created just for acquiring lock for the deadlock example.
		Object object1 = new Object();
		Object object2 = new Object();

		/**
		 * Thread 1 acquires lock of Object 1 and sleeps for a second before
		 * attempting to acquire the lock on Object 2. 
		 */
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (object1) {
					sleep();
					synchronized (object2) {
						System.out. println("Won't print because of the deadlock.");
					}
				}
			}
		});

		/**
		 * Thread 2 acquires the lock of Object 2 and sleeps for a second before
		 * attempting to acquire the lock on Object 1.
		 */
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (object2) {
					sleep();
					synchronized (object1) {
						System.out. println("Won't print because of the deadlock.");
					}
				}
			}
		});

		thread1.start();
		thread2.start();
	}

	/**
	 * Sleep for 1 second.
	 */
	static void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

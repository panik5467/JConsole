package com.cleantutorials.jconsole.thread;

import java.util.Set;

/**
 * Creates multiple threads and starts them for demonstrating the state of the
 * thread. If you plan to run the example, please manually kill the process as there 
 * is no graceful exit in the program.
 */
public class ThreadState {

	public static void main(String[] args) throws InterruptedException {
		RunnableThread runnable = new RunnableThread();
		TimedWaitingThread timedWaiting = new TimedWaitingThread();
		WaitingThread waiting = new WaitingThread();

		runnable.setName("RUNNABLE Example");
		runnable.start();
		
		waiting.setName("WAITING Example");
		waiting.start();
		
		timedWaiting.setName("TIMED_WAITING Example");
		timedWaiting.start();
				
		printStackTrace();
		
	}
	
	/**
	 * Prints the stack trace of all the threads.
	 */
	public static void printStackTrace() {
		
		// Get all threads in Java.
		Set<Thread> threads = Thread.getAllStackTraces().keySet();
		 
		for (Thread thread : threads) {
			// Print the thread name and current state of thread.
			System.out.println("Thread Name:" + thread.getName());
			System.out.println("Thread State:" + thread.getState());

			// Get the stack trace for the thread and print it.
			StackTraceElement[] stackTraceElements = thread.getStackTrace();
			for (StackTraceElement stackTraceElement : stackTraceElements) {
				System.out.println("\t" + stackTraceElement);
			}
			System.out.println("\n");
		}
	}
}

/**
 * RunnableThread represents a thread that is in state RUNNABLE
 */
class RunnableThread extends Thread {
	@Override
	public void run() {
		while (true) {
		}
	}
}

/**
 * WaitingThread represents a thread in WAITING state.
 */
class WaitingThread extends Thread {
	@Override
	public void run() {
		synchronized (this) {
			try {
				// Thread waits forever.
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * TimedWaitingThread represents a thread that is in TIMED_WAITING state.
 */
class TimedWaitingThread extends Thread {
	@Override
	public void run() {
		try {
			// Timed waiting using sleep.
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
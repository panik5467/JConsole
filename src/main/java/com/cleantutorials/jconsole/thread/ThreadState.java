package com.cleantutorials.jconsole.thread;

import java.util.Set;

/**
 * Creates multiple threads and starts them for demonstrating the state of the
 * thread. If you plan to run the example, please manually kill the process as
 * there is no graceful exit in the program.
 */
public class ThreadState {

	public static void main(String[] args) throws InterruptedException {
		
		RunnableThread runnable = new RunnableThread();
		runnable.setName("RUNNABLE Example");
		runnable.start();

		WaitingThread waiting = new WaitingThread();
		waiting.setName("WAITING Example");
		waiting.start();

		TimedWaitingThread timedWaiting = new TimedWaitingThread();
		timedWaiting.setName("TIMED_WAITING Example");
		timedWaiting.start();

		Lock lock = new Lock();
		lock.setName("Helper thread");
		lock.start();

		Blocked blocked = new Blocked();
		blocked.setName("BLOCKED Example");
		blocked.start();

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

/**
 * Blocked represents a thread in BLOCKED state.
 */
class Blocked extends Thread {
	@Override
	public void run() {
		synchronized (Lock.class) {
		}
	}
}

/**
 * Lock is a helper thread that helps demonstrate Blocked state.
 */
class Lock extends Thread {
	@Override
	public void run() {
		synchronized (Lock.class) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

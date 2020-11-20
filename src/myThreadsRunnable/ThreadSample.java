package myThreadsRunnable;

/**
 * 
 * @author VinodAkkepalli
 *
 *	Program to demonstrate how threads are created and executed out of Runnable objects
 */


public class ThreadSample {

	public static void main(String[] args) {

		//instantiating Runnable classes
		ThreadA	tA = new ThreadA();
		ThreadB tB = new ThreadB();
		
		//passing Runnable objects to Thread objects as paramertes
		Thread tAThread = new Thread(tA);
		Thread tBThread = new Thread(tB);
		
		tAThread.start();
		tBThread.start();
		
	}

}

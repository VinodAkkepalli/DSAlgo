package myThreads;

/**
 * 
 * @author VinodAkkepalli
 *
 *	Program to demonstrate threads behavior
 *	ThreadSample class is calling two thread objects named ThreadA & ThreadB
 */

public class ThreadSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ThreadA tA = new ThreadA();
		ThreadB tB = new ThreadB();
		
		tA.start();
		tB.start();

	}

}

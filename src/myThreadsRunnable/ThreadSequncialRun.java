package myThreadsRunnable;

/** 
 * @author VinodAkkepalli
 *
 *	This is a program to demonstrate how we can make a first thread wait for the execution of second thread to complete its execution
 *	This can be used to impose an execution sequence sequence among threads
 *
 *	Try removing the join() statement to see the difference of output
 */

public class ThreadSequncialRun {

	public static void main(String[] args) {
		
		ThreadForSequence tfs1 = new ThreadForSequence("First", 10000);
		Thread t1 = new Thread(tfs1);
		t1.start();
		
		//The join() method below waits for the thread t1 to complete its execution before continuing to further execution
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ThreadForSequence tfs2 = new ThreadForSequence("second", 1000);
		Thread t2 = new Thread(tfs2);
		t2.start();
		
		ThreadForSequence tfs3 = new ThreadForSequence("third", 100);
		Thread t3 = new Thread(tfs3);
		t3.start();
	}

}

class ThreadForSequence implements Runnable{

	String name;
	int waitTime;
	public ThreadForSequence(String tName, int wTime) {
		this.name = tName;
		this.waitTime = wTime;
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread = " + name);
		
		
	}
	
}
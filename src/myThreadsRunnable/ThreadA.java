package myThreadsRunnable;

public class ThreadA implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i< 50; i++){
			System.out.println("ThreadA count: " + i);
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){}
		}
	}


}

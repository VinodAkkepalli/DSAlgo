package myThreadsRunnable;

public class ThreadB implements Runnable{

	@Override
	public void run() {
		
		for(int i = 50; i> 0; i--){
			System.out.println("ThreadB count: " + i);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){}
		}
	}

}

package myThreads;

public class ThreadA extends Thread{
	
	public void run(){
		for(int i = 0; i< 50; i++){
			System.out.println("ThreadA count: " + i);
			try{
				sleep(500);
			}catch(InterruptedException e){}
		}
	}
}

package myThreads;

public class ThreadB extends Thread{
	
	public void run(){
		for(int i = 50; i> 0; i--){
			System.out.println("ThreadB count: " + i);
			try{
				sleep(500);
			}catch(InterruptedException e){}
		}
	}
}

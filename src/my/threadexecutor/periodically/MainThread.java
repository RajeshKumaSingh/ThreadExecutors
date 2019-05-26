package my.threadexecutor.periodically;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainThread {

	public static void main(String[] args) {
		ScheduledExecutorService executor= (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
		// 1 thread in thread pool
		System.out.println("Main starting at "+new Date());
		Task task = new Task("Task");
		
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
		// 1 - delay
		// 2 - repeat
		for(int i=0;i<10;i++) {
			System.out.println("Main: Delay: "+result.getDelay(TimeUnit.SECONDS));
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main: Finished AT "+ new Date());
	}

}

class Task implements Runnable{
	private String name;
	public Task(String name) {
		this.name=name;
	}
	@Override
	public void run() {
		System.out.println(name+" starting at "+new Date());
	}
	
}

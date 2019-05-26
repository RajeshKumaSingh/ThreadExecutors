package my.threadexecutor.delay;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainThread {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor= (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
		// 1 thread in thread pool
		System.out.println("Main starting at "+new Date());
		for(int i=0;i<5;i++) {
			Task task = new Task("Task-"+i);
			executor.schedule(task, i+1, TimeUnit.SECONDS);  // starting delay by i+1 seconds
		}
		executor.shutdown();
		try {
			executor.awaitTermination(10, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Task implements Callable<String>{
	private String name;
	public Task(String name) {
		this.name=name;
	}
	@Override
	public String call() throws Exception {
		System.out.println(name+" starting at "+new Date());
		return "Hello World\n";
	}
	
}

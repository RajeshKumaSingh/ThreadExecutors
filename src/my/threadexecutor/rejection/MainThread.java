package my.threadexecutor.rejection;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainThread {

	public static void main(String[] args) {
		RejectTaskController controller = new RejectTaskController();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		executor.setRejectedExecutionHandler(controller);
		System.out.println("Main: Starting");
		for(int i=0;i<3;i++) {
			Task task = new Task("task-"+i);
			executor.submit(task);
		}
		System.out.println("Main: Shutting down the Executor.");
		executor.shutdown();
		
		System.out.println("Main: Sending one more task");
		Task task = new Task("RejectdTask");
		executor.submit(task);
		System.out.println("Main: End");
		
	}

}

class Task implements Runnable{
	private String name;
	public Task(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println("Task: "+name+" starting");
		long duration = (long)(Math.random()*10);
		System.out.println("Task: "+name+": ReportGenerator: Generating a report during "+duration+" seconds");
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task: "+name+" Ending");
	}
	
	public String toString() {
		return name;
	}
	
}

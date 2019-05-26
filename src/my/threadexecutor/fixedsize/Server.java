package my.threadexecutor.fixedsize;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
	
	private ThreadPoolExecutor executor;
	
	public Server() {
		executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	}
	
	public void executeTask(Task task) {
		System.out.println("Server: A new task has arrived");
		executor.execute(task);
		System.out.println("Server: Task count: "+executor.getTaskCount());
		System.out.println("Server: Active size: "+executor.getActiveCount());
		System.out.println("Server: Completed task: "+executor.getCompletedTaskCount());
	}
	
	public void endServer() {
		executor.shutdown();
	}
}

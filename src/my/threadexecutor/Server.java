package my.threadexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
	
	private ThreadPoolExecutor executor;
	
	public Server() {
		executor= (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}
	
	public void executeTask(Task task) {
		System.out.println("Server: A new task has arrived");
		executor.execute(task);
		System.out.println("Server: Pool size: "+executor.getPoolSize());
		System.out.println("Server: Active size: "+executor.getActiveCount());
		System.out.println("Server: Completed task: "+executor.getCompletedTaskCount());
	}
	
	public void endServer() {
		executor.shutdown();
	}
}

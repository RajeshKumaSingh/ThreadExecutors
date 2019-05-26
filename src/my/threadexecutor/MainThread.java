package my.threadexecutor;

public class MainThread {

	public static void main(String[] args) {
		Server server= new Server();
		for(int i=0;i<10;i++) {
			Task task = new Task("Task-"+i);
			server.executeTask(task);
		}
		server.endServer();
		
		server.executeTask(new Task("RejectedExecutionException Task"));
		
		/*
		After you call the shutdown() method,
		if you try to send another task to the executor, it will be rejected and the executor will
		throw a RejectedExecutionException exception
		*/
	}

}

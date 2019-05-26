package my.threadexecutor.allresult;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MainThread {

	public static void main(String[] args) {
		List<Task> taskList = Arrays.asList(new Task("T1"), new Task("T2"),new Task("T3"), new Task("T4"));
		ExecutorService executor = Executors.newCachedThreadPool();
		List<Future<String>>  resultList = null;
		
		try {
			resultList = executor.invokeAll(taskList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
		executor.shutdown();
		System.out.println("Printing the results: ");
		for(int i=0;i<resultList.size();i++) {
			Future<String> future = resultList.get(i);
			String result = null;
			try {
				 result = future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			
			System.out.println(result);
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
		long duration = (long) (Math.random()*10);
		TimeUnit.SECONDS.sleep(duration);
		return name+"_"+duration;
	}
	
}

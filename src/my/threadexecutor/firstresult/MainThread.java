package my.threadexecutor.firstresult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {

	public static void main(String[] args) {
		String userName = "Test";
		String password = "Test";
		
		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("DB");
		
		TaskValidator ldapTask = new TaskValidator(ldapValidator, userName, password);
		TaskValidator dbTask = new TaskValidator(dbValidator, userName, password);
		
		List<TaskValidator> taskList = new ArrayList<>();
		taskList.add(ldapTask);
		taskList.add(dbTask);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		String result = null;
		
		try {
			result = executor.invokeAny(taskList);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		System.out.println("Main: End of execution "+result);
	}
	/*
	The invokeAny() method of the
	ThreadPoolExecutor class receives a list of tasks, launches them, and returns the result
	of the first task that finishes without throwing an exception. This method returns the same
	data type that the call() method of the tasks you launch returns. In this case, it returns a
	String value.
	*/

}

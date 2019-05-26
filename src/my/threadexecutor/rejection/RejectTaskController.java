package my.threadexecutor.rejection;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectTaskController implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
		System.out.println("RejectTaskController: The task "+runnable.toString()+" has been rejected");
		System.out.println("RejectTaskController: "+executor.toString());
		System.out.println("RejectTaskController: Terminating: "+executor.isTerminating());
		System.out.println("RejectTaskController: Terminated: "+executor.isTerminated());
	}

}

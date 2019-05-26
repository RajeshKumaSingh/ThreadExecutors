package my.threadexecutor.returnresult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainThread {

	public static void main(String[] args) {
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		List<Future<Integer>> resultList = new ArrayList<>();
		Random random = new Random();
		for(int i=0;i<10;i++) {
			Integer number = random.nextInt(10);
			FactorialCalculator factorialCalculator = new FactorialCalculator(number);
			Future<Integer> result = executor.submit(factorialCalculator);
			resultList.add(result);
		}
		
		do {
			System.out.println("Main: Number of completed task: "+executor.getCompletedTaskCount());
			for(int i=0;i<resultList.size();i++) {
				Future<Integer> result = resultList.get(i);
				System.out.println("Main: Task "+i+"  "+result.isDone());
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(executor.getCompletedTaskCount()<resultList.size());
		
		executor.shutdown();
	}

}

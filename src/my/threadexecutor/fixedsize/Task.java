package my.threadexecutor.fixedsize;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private String name;
	private Date initDate;

	public Task(String name) {
		super();
		this.name = name;
		this.initDate = new Date();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": Task " + name + "Creadted on " + initDate);
		System.out.println(Thread.currentThread().getName() + ": Task Started on " + new Date());

		Long duration = (long) (Math.random() * 10);
		System.out.println(
				Thread.currentThread().getName() + ": Task " + name + " Doing a task during " + duration + " seconds");
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": Task " + name + " Finshed on " + new Date());
	}

}

package my.threadexecutor.firstresult;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
	private String name;
	
	public String getName() {
		return this.name;
	}

	public UserValidator(String name) {
		super();
		this.name = name;
	}
	
	public boolean validate(String name, String password) {
		Random random = new Random();
		
		long duration = (long)(Math.random()*10);
		System.out.println("Valodator: "+name+": Validating a user during "+duration+" seconds");
		
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		
		return random.nextBoolean();
	}
}

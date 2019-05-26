package my.threadexecutor.firstresult;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {
	private UserValidator userValidator;
	private String name;
	private String password;
	
	public TaskValidator(UserValidator userValidator, String name, String password) {
		super();
		this.userValidator = userValidator;
		this.name = name;
		this.password = password;
	}

	@Override
	public String call() throws Exception {
		if(!userValidator.validate(name, password)) {
			System.out.println(userValidator.getName()+": The user has not been found ");
			throw new Exception("Error validating user");
		}
		System.out.println(userValidator.getName()+": Thes user has been found");
		return userValidator.getName();
	}

}

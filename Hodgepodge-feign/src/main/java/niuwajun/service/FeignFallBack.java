package niuwajun.service;

import org.springframework.stereotype.Component;

import niuwajun.domain.User;

@Component
public class FeignFallBack implements FeignService{

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "error";
	}

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "error";
	}

	@Override
	public User hello(String name, Integer age) {
		User user = new User();
		user.setName("error");
		return user;
	}

	@Override
	public String hello(User user) {
		// TODO Auto-generated method stub
		return "error";
	}

}

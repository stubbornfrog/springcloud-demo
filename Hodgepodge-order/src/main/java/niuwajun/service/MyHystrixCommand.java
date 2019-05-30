package niuwajun.service;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * 自己实现熔断和服务降级
 * @author Administrator
 *
 */
public class MyHystrixCommand extends HystrixCommand<String>{

	private RestTemplate restTemplate;
	
	public MyHystrixCommand(String commandGroupKey,RestTemplate restTemplate) {
		super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
		this.restTemplate = restTemplate;
	}

	@Override
	protected String run() throws Exception {
		String body = "";
		try {
			body = restTemplate.getForEntity("http://service-member/getUserList", String.class).getBody();
		} catch (Exception e) {
			throw e;
		}
		return body;
	}

	@Override
    protected String getFallback() {
        return "error";
    }
}

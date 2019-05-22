package niuwajun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SuppressWarnings("unchecked")
@Service
public class MemberService {
	@Autowired
	RestTemplate restTemplate;

//	public List<String> getOrderByUserList() {
//		return restTemplate.getForObject("http://service-member/getUserList", List.class);
//	}
	@HystrixCommand(fallbackMethod = "helloFallBack")
	public List<String> getOrderByUserList() {
		return restTemplate.getForObject("http://service-member/getUserList", List.class);
	}
	
	
    public List<String> helloFallBack(){
    	return new ArrayList<String>();
    }
}
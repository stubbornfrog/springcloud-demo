package niuwajun.action;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import niuwajun.service.MemberService;
import niuwajun.service.MyHystrixCommand;

@RestController
public class MemberController {
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/getUserList")
	public List<String> getUserList() throws ExecutionException, InterruptedException {
		return memberService.getOrderByUserList();
	}
	
	//以下是自定义熔断器
	
	@Autowired
    private  RestTemplate restTemplate;
	
	@RequestMapping("/getUserListHys")
	public String getUserListHys() throws ExecutionException, InterruptedException {
		MyHystrixCommand command = new MyHystrixCommand("getUserListHys",restTemplate);
	    String result = command.execute();
	    return result;
	}
	

}

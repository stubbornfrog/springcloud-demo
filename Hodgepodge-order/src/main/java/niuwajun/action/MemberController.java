package niuwajun.action;

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
	
//	@RequestMapping("/getUserList")
//	public List<String> getUserList() throws ExecutionException, InterruptedException {
//		return memberService.getOrderByUserList();
//	}
	
	@Autowired
    private  RestTemplate restTemplate;
	
	@RequestMapping("/getUserList")
	public String getUserList() throws ExecutionException, InterruptedException {
		MyHystrixCommand command = new MyHystrixCommand("getUserList",restTemplate);
	    String result = command.execute();
	    return result;
	}
	

}

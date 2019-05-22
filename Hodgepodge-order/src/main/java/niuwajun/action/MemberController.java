package niuwajun.action;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import niuwajun.service.MemberService;

@RestController
public class MemberController {
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/getUserList")
	public List<String> getUserList() throws ExecutionException, InterruptedException {
		return memberService.getOrderByUserList();
	}

}

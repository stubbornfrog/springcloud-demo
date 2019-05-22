package niuwajun.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	@RequestMapping("/getUserList")
	public List<String> getUserList() {
		List<String> listUser = new ArrayList<String>();
		listUser.add("member2");
		listUser.add("member2");
		listUser.add("member2");
		return listUser;
	}

}

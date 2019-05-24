package niuwajun.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import niuwajun.domain.User;

@RestController
public class MemberController {

	@RequestMapping("/getUserList")
	public List<String> getUserList() {
		List<String> listUser = new ArrayList<String>();
		listUser.add("member1");
		listUser.add("member1");
		listUser.add("member1");
		return listUser;
	}

	@RequestMapping("/hello")
    public String hello(){
        System.out.println("访问来1了......");
        return "hello1";
    }

    @RequestMapping("/hjcs")
    public List<String> laowangs(String ids){
        List<String> list = new ArrayList<>();
        list.add("laowang1");
        list.add("laowang2");
        list.add("laowang3");
        return list;
    }

    //新增的方法
    @RequestMapping(value = "/hellol", method= RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method= RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello (@RequestBody User user) {
        return "Hello "+ user. getName () + ", " + user. getAge ();
    }
	
}

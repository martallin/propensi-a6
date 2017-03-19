package mosing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mosing.model.UserAdmisiModel;
import mosing.service.UserAdmisiService;

@Controller
public class PageController {
	@Autowired
	UserAdmisiService userDAO;
	
	@RequestMapping("/")
	public String login(Model model){
		UserAdmisiModel user = userDAO.selectUser();
		model.addAttribute("user", user);
		if(user!=null){
		return "home";
		} else {
			return "login";
		}
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
<<<<<<< HEAD
	}
=======
	}	

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
	

//	@RequestMapping("/")
//	public String home(Model model){
//		UserAdmisiModel user = userDAO.selectUser();
//		model.addAttribute("user", user);
//		return "home";
////		if(user.getRole().equals("ROLE_PEND"))
////			return "home";
////		else if(user.getRole().equals("ROLE_KPMB"))
////			return "home2";
////		else
////			return "home3";
//	}
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String selectUser(@RequestParam(value ="username", required = false) String username){
//		UserAdmisiModel userAdmisi = userDAO.selectUser(username);
//		
//		if(userAdmisi.getRole().equals("ROLE_KPMB")){
//			return "kpmb";
//		} else if(userAdmisi.getRole().equals("ROLE_PEND")){
//			return "home";
//		} else {
//			return "login";
//		}
//	}


>>>>>>> refs/remotes/origin/master
=======
>>>>>>> branch 'master' of https://github.com/propensi2017/a6.git
	@RequestMapping("/done")
	public String done() {
		return "done";
	}
}
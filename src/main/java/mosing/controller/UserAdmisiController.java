package mosing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mosing.model.UserAdmisiModel;
import mosing.service.UserAdmisiService;

@Controller
public class UserAdmisiController {

	@Autowired
	UserAdmisiService userDAO;
	
	@RequestMapping("/register")
	public String add()
	{
		return "form-registrasi1";
	}
	
	
	@RequestMapping("/register/submit")
	public String addSubmit(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "email", required = false) String email)
	{
		UserAdmisiModel userAdmisi = new UserAdmisiModel(username, password, email, "ROLE_PEND");
		userDAO.addUser(userAdmisi);
		return "success-registration";
	}
	
//	@RequestMapping("/pendaftar/register/next")
//	public String addUser(Model model,
//			@RequestParam(value = "username", required = false) String username,
//			@RequestParam(value = "password", required = false) String password,
//			@RequestParam(value = "email", required = false) String email)
//	{
//		UserAdmisiModel userAdmisi = new UserAdmisiModel(username, password, email, "ROLE_PEND");
//		userDAO.addUser(userAdmisi);
//		UserAdmisiModel user = userDAO.selectUser(username);
//		model.addAttribute("user", user);
//		return "form-registrasi2";
//	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String selectUser(@RequestParam(value ="username", required = false)String username){
//		UserAdmisiModel userAdmisi = userDAO.selectUser(username);
//		
//		if(userAdmisi.getRole().equals("KPM")){
//			return "kpmb";
//		}
//		else {
//			return "error";
//		}
//	}
}

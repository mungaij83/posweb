package main.java;

import main.java.dao.LoginUserDao;
import main.java.forms.LoginForm;
import main.java.models.LoginUser;
import main.java.service.SecurityService;
import main.java.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * Handle user authentication and access control.
 * Functions:
 * 	1. Register user
 * 	2. Login 
 * 	3. Update password.
 * @author njoroge
 *
 */
@Controller
public class UserAuthentication {
	@Autowired
	UserService userDetails;
	@Autowired
	SecurityService securityService;
	@Autowired
	LoginUserDao userDao;
	@GetMapping("/register")
	public String register() {
		return "auth/register";
	}

	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}
	/**
	 * Create user account 
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping("/register")
	public ModelAndView register(LoginUser form) {
		ModelAndView model = new ModelAndView();
		try{
			if(userDao.findByUsername(form.getUsername())!=null){
				model.addObject("error", "User with the given username already exists");
				model.setViewName("auth/register");
			}else{
				userDetails.save(form);
				model.setViewName("auth/view");
			}
		}catch(Exception ex){
			model.addObject("error", "Could not create user account: \n"+ex.getMessage());
			model.setViewName("auth/register");
		}
		return model;
	}
	/**
	 * Process login request
	 * @param form
	 * @return
	 */
	@PostMapping("/login")
	public ModelAndView login(LoginForm form) {
		ModelAndView model = new ModelAndView();
		try{
			securityService.autologin(form.getUsername(), form.getPassword());
			model.setViewName("redirect:/home");
		}catch(Exception ex){
			model.setViewName("login");
			model.addObject("message", "Username or password incorrect");
			
		}
		return model;
	}

	@GetMapping("/change-password")
	public String changePassword() {
		return "auth/change-password";
	}

	@PostMapping("/change-password/{id}")
	public ModelAndView changePassword(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView();
		
		return model;
	}
}

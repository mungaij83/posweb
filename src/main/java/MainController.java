package main.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {
	//@Autowired
	//SessionRegistry registry;
	
	/**
	 * List active Users/POS
	 * 
	 * @param mdoe
	 
	public void terminals(Model mdoe){
		final List<Object> allPrincipals = registry.getAllPrincipals();

        for (final Object principal : allPrincipals) {
            if (principal instanceof Employee) {
                final SecurityUser user = (SecurityUser) principal;

                List<SessionInformation> activeUserSessions =
                        sessionRegistry.getAllSessions(principal,
                                 false); // Should not return null;

                if (!activeUserSessions.isEmpty()) {
                    // Do something with user
                    System.out.println(user);
                }
            }
        }
	}
	*/
	@RequestMapping("/hello")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
		Greeting g=new Greeting();
		g.setName(name);
		g.setId("90");
		return g;
	}
	@RequestMapping(value={"/","/home"},method=RequestMethod.GET)
	public String home(Model model){
		model.addAttribute("message", "Welcome here");
		return "home";
	}
}

package main.java.controllers;

import main.java.dao.RolesDao;
import main.java.models.Roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/roles")
public class RolesController {
	
	@Autowired
	RolesDao rolesDao;
	
	/**
	 * Return add role form
	 * @return
	 */
	@RequestMapping(path="/add",method=RequestMethod.GET)
	public String addRole(){
		return "employee/role-add";
	}
	
	/**
	 * Add a new role to database
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(path="/add",method=RequestMethod.POST)
	public ModelAndView addRole(@RequestBody Roles role){
		ModelAndView model=new ModelAndView();
		Roles r=rolesDao.save(role);
		if(r!=null){
			model.addObject("message", "Role added successfully");
			model.addObject("role",r);
		}else{
			model.addObject("error", "Role not added");
			model.addObject("role", role);
		}
		model.setViewName("employee/role-add");		
		return model;
	}
	
	/**
	 * View available Roles
	 * 
	 * @return
	 */
	@RequestMapping(path="/view", method=RequestMethod.GET)
	public ModelAndView viewRoles(){
		ModelAndView model=new ModelAndView();
		model.setViewName("employee/role-view");
		Iterable<Roles> roles=rolesDao.findAll();
		model.addObject("roles", roles);
		return model;
	}
}

package main.java.controllers;

import main.java.dao.EmployeeDao;
import main.java.models.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String addEmployee() {
		return "employee/employee-add";
	}

	/**
	 * Add an employee
	 * 
	 * @param emp
	 * @return
	 */
	@RequestMapping(path = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView addEmployee(Employees emp) {
		ModelAndView model = new ModelAndView();
		try {
			Employees e = employeeDao.save(emp);
			if (e == null) {
				model.addObject("error", "Could not save record");
				model.addObject("employee", emp);
				model.setViewName("employee/employee-add");
			} else {
				model.addObject("message", "Record created successfully");
				model.setViewName("employee/employee-view");
			}
		} catch (Exception ex) {
			model.setViewName("employee/employee-add");
			model.addObject("error", "Error: " + ex.getMessage());
		}
		return model;
	}

	/**
	 * View All Employees
	 * 
	 * @return
	 */
	@RequestMapping(path = "/view", method = RequestMethod.GET)
	public ModelAndView viewEmployees() {
		ModelAndView model = new ModelAndView();
		Iterable<Employees> employees = employeeDao.findAll();
		model.addObject("employees", employees);
		model.setViewName("employee/employee-view");
		return model;
	}

	/**
	 * View employee By ID
	 * 
	 * @return
	 */
	@RequestMapping(path = "/view/{id}", method = RequestMethod.GET)
	public ModelAndView ViewEmployee(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView();
		Employees emp = employeeDao.findOne(id);
		if (emp == null) {
			model.addObject("error", "Record does not exists");
		}
		model.addObject("employee", emp);
		model.setViewName("employee/employee-view");

		return model;
	}
}

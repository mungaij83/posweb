package main.java.controllers;

import java.util.ArrayList;
import java.util.List;

import main.java.dao.CustomerDao;
import main.java.models.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerDao customerDao;
	/**
	 * Add customer
	 * @return
	 */
	@RequestMapping(path="/add",method=RequestMethod.GET)
	public String addCustomer(){
		return "customer/customer-add";
	}
	/**
	 * Add customer to database
	 * @param customer
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView addCustomer(Customer customer){
		ModelAndView model=new ModelAndView();
		try{
			System.out.print(customer);
		Customer c=customerDao.save(customer);
		if(c!=null){
			model.addObject("customer", c);
			model.setViewName("customer/customer-view");
		}else{
			model.addObject("customer", customer);
			model.setViewName("customer/customer-add");
		}
		}catch(Exception ex){
			model.addObject("customer", customer);
			model.setViewName("customer/customer-add");
			model.addObject("error", "Error adding customer: "+ex.getMessage());
		}
		return model;
	}
	/**
	 * View customer by ID
	 * @param id
	 * @return
	 */
	@RequestMapping(path="/view/{id}",method=RequestMethod.GET)
	public ModelAndView viewCustomer(@PathVariable("id") Long id){
		Customer c=customerDao.findOne(id);
		ModelAndView model=new ModelAndView();
		model.setViewName("customer/customers");
		if(c==null){
			model.addObject("error", "Record does not exist");
		}else{
			model.addObject("customer", c);
		}
		return model;
	}
	/**
	 * View All customers from the database
	 * @return
	 */
	@RequestMapping(path="/view",method=RequestMethod.GET)
	public ModelAndView viewCustomers(){
		ModelAndView model=new ModelAndView();
		List<Customer> customers=new ArrayList<>();
		Iterable<Customer> cs=customerDao.findAll();
		for(Customer c:cs){
			customers.add(c);
		}
		model.addObject("customers",customers);
		model.setViewName("customer/customers");
		
		return model;
	}
}

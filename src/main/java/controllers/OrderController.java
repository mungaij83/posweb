package main.java.controllers;

import main.java.dao.OrderDao;
import main.java.dao.OrderItemDao;
import main.java.models.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItemDao itemsDao;
	
	/**
	 * View orders
	 * @return
	 */
	@RequestMapping(path="/view",method=RequestMethod.GET)
	public ModelAndView viewOrders(){
		ModelAndView model=new ModelAndView();
		Iterable<Order> orders=orderDao.findAll();
		model.addObject("orders", orders);
		model.setViewName("sales/orders");
		
		return model;
	}
	/**
	 * View Order by its ID
	 * @param id
	 * @return
	 */
	@RequestMapping(path="/view/{id}",method=RequestMethod.GET)
	public ModelAndView viewOrder(@PathVariable("id") Long id){
		ModelAndView model=new ModelAndView();
		Order o=orderDao.findOne(id);
		if(o!=null){
			model.addObject("order", o);
		}else{
			model.addObject("error", "Record does not exists");
		}
		model.setViewName("sales/order-view");
		return model;
	}
}

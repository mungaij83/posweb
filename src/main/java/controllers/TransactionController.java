package main.java.controllers;

import main.java.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	PaymentTransactionDao transDao;
	@GetMapping("/view")
	public ModelAndView getTransactions(){
		ModelAndView model=new ModelAndView();
		model.setViewName("sales/transactions");
		try{
			model.addObject("transactions",transDao.findAll());
		}catch(Exception ex){
			model.addObject("error", "Error retrieving transactions: "+ex.getMessage());
		}
		return model;
	}
}

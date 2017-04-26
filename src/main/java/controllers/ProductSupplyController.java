package main.java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import main.java.dao.ProductSupliesDao;
import main.java.models.ProductSupplies;
@Controller
@RequestMapping("/supply")
public class ProductSupplyController {
	@Autowired
	ProductSupliesDao psDao;
	@GetMapping("/view")
	public void viewSupplies(){
		ModelAndView model=new ModelAndView();
		model.setViewName("supply/product-supplies-view");
		try{
			model.addObject("supplies",psDao.findAll());
		}catch(Exception e){
			model.addObject("error", "Error retrieving details: "+e.getMessage());
			
		}
	}
	@GetMapping("/view/{id}")
	public void viewSupplies(@PathVariable("id") Long id){
		ModelAndView model=new ModelAndView();
		model.setViewName("supply/product-supplies-view");
		try{
			model.addObject("supply",psDao.findOne(id));
		}catch(Exception e){
			model.addObject("error", "Error retrieving details: "+e.getMessage());
			
		}
	}
	
	@GetMapping("/recent")
	public void viewRecent(){
		ModelAndView model=new ModelAndView();
		model.setViewName("supply/product-supply-history");
		try{
			model.addObject("supplies",psDao.findAll());
		}catch(Exception e){
			model.addObject("error", "Error retrieving details: "+e.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteSupply(@PathVariable("id") Long id){
		
	}
	
	@GetMapping("/confirm/{id}")
	public void confirmSupply(@PathVariable("id") Long id){
		ModelAndView model=new ModelAndView();
		model.setViewName("supply/product-supplies-view");
		try{
			ProductSupplies ps=psDao.findOne(id);
			ps.setConfirmed(true);
			psDao.save(ps);
			model.addObject("supply",ps);
		}catch(Exception e){
			model.addObject("error", "Error retrieving details: "+e.getMessage());
			
		}
	}
}

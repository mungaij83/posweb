package main.java.controllers;

import main.java.dao.SuplierDao;
import main.java.models.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	SuplierDao suplierDao;
	
	@GetMapping("/add")
	public String addSupplier(){
		return "supply/supplier-add";
	}
	
	@PostMapping("/add")
	public ModelAndView addSupllier(Supplier supplier){
		ModelAndView model=new ModelAndView();
		try{
			Supplier s=suplierDao.save(supplier);
			if(s!=null){
				model.addObject("supplier",s);
				model.setViewName("supply/supplier-view");
			}else{
				model.addObject("message", "Could not add supplier");
				model.addObject("supplier",supplier);
				model.setViewName("supply/supplier-add");
			}
		}catch(Exception ex){
			model.addObject("error", "Error adding supplier:"+ex.getMessage());
			model.addObject("supplier",supplier);
			model.setViewName("supply/supplier-view");
		}
		return model;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteSuplier(@PathVariable("id") Long id){
		
	}
	@PutMapping("/update/{id}")
	public void updateSuplier(Supplier suplier){
		
	}
	@GetMapping("/view/{id}")
	public ModelAndView viewHistory(@PathVariable("id") Long id){
		ModelAndView model=new ModelAndView();
		model.setViewName("supply/supplier-view");
		try{
			model.addObject("suplier",suplierDao.findOne(id));
		}catch(Exception ex){
			model.addObject("error", "Error retrieving suplier ["+id+"]: "+ex.getMessage());
		}
		return model;
	}
	@GetMapping("/view")
	public ModelAndView viewSuppliers(){
		ModelAndView model=new ModelAndView();
		model.setViewName("supply/supplier-view");
		try{
			model.addObject("supliers",suplierDao.findAll());
		}catch(Exception ex){
			model.addObject("error", "Error retrieving supliers: "+ex.getMessage());
		}
		return model;
	}
}

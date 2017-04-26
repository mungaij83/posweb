package main.java.controllers;

import main.java.dao.ProductDao;
import main.java.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addProduct(){
		return "product/product-add";
	}
	/**
	 * Add a new product
	 * @param product
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView addProduct(Product product){
		ModelAndView model=new ModelAndView();
		try{
			Product p=productDao.save(product);
			if(p!=null){
				model.setViewName("redirect:/product/view");
			}else{
				model.addObject("product", product);
				model.addObject("message", "Record could not be saved, please edit and try again");
			}
		}catch(Exception ex){
			model.addObject("error", "Error adding product: "+ex.getMessage());
		}
		return model;
	}
	
	/**
	 * View all products
	 * @return
	 */
	@RequestMapping(path="/view",method=RequestMethod.GET)
	public ModelAndView viewProducts(){
		ModelAndView model=new ModelAndView();
		Iterable<Product> products=productDao.findAll();
		model.addObject("products", products);
		model.setViewName("product/product-view");
		
		return model;
	}
	/**
	 * View product By ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path="/view/{id}",method=RequestMethod.GET)
	public ModelAndView viewProduct(@PathVariable("id") Long id){
		ModelAndView model=new ModelAndView();
		Product product=productDao.findOne(id);
		model.addObject("product", product);
		model.setViewName("product/product-view");
		
		return model;
	}
}

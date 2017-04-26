package main.java.controllers.api;

import main.java.dao.ProductDao;
import main.java.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
@RequestMapping("/api/product")
public class POSProducstController extends WebMvcConfigurerAdapter{
	@Autowired
	ProductDao productDao;
	
	/**
	 * View Product
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/view/{id}")
	public Product getProduct(@PathVariable("id") Long id){
		try{
		Product p=productDao.findOne(id);
		return p;
		}catch(Exception e){
			
		}
		return null;
	}
	/**
	 * Add product 
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product){
		Product p=productDao.save(product);
		return p;
	}
	/**
	 * Update product
	 * 
	 * @param id
	 * @param product
	 * @return
	 */
	@PutMapping("/update/{id}")
	public Product updateProducte(@PathVariable("id") Long id,@RequestBody Product product){
		if(productDao.exists(id)){
			Product p=productDao.save(product);
			return p;
		}
		return null;
	}
	/**
	 * Delete product from database
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public Product deleteProduct(@PathVariable("id") Long id){
		if(productDao.exists(id)){
			Product p=productDao.findOne(id);
			productDao.delete(id);
			return p;
		}
		return null;
	}
	/**
	 * Find Product by BarCode or code
	 * @param code
	 * @return
	 */
	@GetMapping("/check/{code}")
	public Product getProductCode(@PathVariable("code") String code){
		try{
			Product p=productDao.findByProductCode(code);
			return p;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}

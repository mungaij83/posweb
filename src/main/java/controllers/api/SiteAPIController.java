package main.java.controllers.api;

import main.java.models.*;
import main.java.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/api/site")
public class SiteAPIController {
	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryDao categotyDao;
	//==============PRODUCTS============
	/**
	 * Update product
	 */
	@PutMapping("/product")
	public Product updateProduct(Product product){
		try{
			return productDao.save(product);
		}catch(Exception ex){
			return null;
		}
	}
	/**
	 * Delete product from store
	 */
	public void deleteProduct(){
		
	}
	//===============CUSTOMERS========
	public void updateCustomer(){
		
	}
	public void deleteCustomer(){
		
	}
	//================Categories==========
	@DeleteMapping("/category/{id}")
	public Category deleteCategory(@PathVariable("id") Long id){
		try{
			Category c=categotyDao.findOne(id);
			categotyDao.delete(id);
			return c;
		}catch(Exception ex){
			return null;
		}
	}
	@PutMapping("/category/{id}")
	public Category updateategory(@PathVariable("id")Long catId,Category cat){
		try{
			//categotyDao.update(catId,cat.getName(),cat.getDescription());
			return categotyDao.findOne(catId);
		}catch(Exception ex){
			return null;
		}
	}
	//=============PRODUCT SUPLY==========
	public void confirmSuply(){
		
	}
	public void deleteSupply(){
		
	}
	//============ROLES===========
	public void deleteRole(){
		
	}
	//=========SUPPLIER==========
	public void updateSupplier(){
		
	}
	public void deleteSuplier(){
		
	}
	//========TRANSACTION=======
	public void deleteTransaction(){
		
	}
	public void updateTransaction(){
		
	}
}

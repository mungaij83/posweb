package main.java.controllers.api;

import main.java.dao.ProductSupliesDao;
import main.java.dao.SuplierDao;
import main.java.models.ProductSupplies;
import main.java.models.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/suply")
public class POSProducSupplyController {
	@Autowired
	ProductSupliesDao supplyDao;
	@Autowired
	SuplierDao supplierDao;
	/**
	 * Add a supply to the list
	 * @param suply
	 * @return
	 */
	@PostMapping("/add")
	public ProductSupplies addSuply(ProductSupplies suply){
		try{
			ProductSupplies p=supplyDao.save(suply);
			return p;
		}catch(Exception ex){
			
		}
		return null;
	}
	/**
	 * Get list of available suppliers
	 * @return
	 */
	@GetMapping("/suppliers")
	public Iterable<Supplier> getSupliers(){
		try{
			return supplierDao.findAll();
		}catch(Exception ex){
			
		}
		return null;
	}
}

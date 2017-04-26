package main.java.dao;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;

import main.java.models.Product;
@Transactional
public interface ProductDao extends CrudRepository<Product,Long>{
	public Product findByProductCode(String code);
	
}

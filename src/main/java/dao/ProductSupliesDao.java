package main.java.dao;

import main.java.models.ProductSupplies;

import org.springframework.data.repository.CrudRepository;

public interface ProductSupliesDao extends CrudRepository<ProductSupplies, Long> {

}

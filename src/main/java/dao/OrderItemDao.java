package main.java.dao;

import main.java.models.OrderItems;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemDao extends CrudRepository<OrderItems, Long> {
	
}

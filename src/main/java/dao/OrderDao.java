package main.java.dao;

import main.java.models.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order, Long> {

}

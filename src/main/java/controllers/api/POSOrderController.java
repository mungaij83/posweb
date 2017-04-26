package main.java.controllers.api;

import java.util.List;

import main.java.dao.OrderDao;
import main.java.dao.OrderItemDao;
import main.java.dao.ProductDao;
import main.java.models.Order;
import main.java.models.OrderItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/order")
public class POSOrderController {

	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItemDao itemsDao;
	
	@Autowired
	ProductDao productDao;
	/**
	 * Create an order from  post data
	 * 
	 * @method 1 for Cash 2 for credit card
	 */
	@PostMapping("/add/{method}")
	@Transactional
	public Order placeOrder(@PathVariable("method") int method, @RequestBody List<OrderItems> items){
		Order order=new Order();
		orderDao.save(order);
		double total=0;
		for(OrderItems itm:items){
			if(itm.getQuantity()>0){
				itm.setOrderId(order);
				total+=itm.getQuantity()*itm.getProduct().getSellingPrice();
				itemsDao.save(itm);
			}
		}
		//Charge credit card via QBO
		if(method==2){
			
			return order;
		}else{ //Cash confirmed by cashier
			order.setTotal(total);
			order.setCompleted(true);
			orderDao.save(order);
			return order;
		}
	}
	/**
	 * Delete order and order items, reverse placeOrder
	 * @param id
	 */
	@DeleteMapping("/delete/{id}")
	public void removeOrder(@PathVariable("id")Long id){
		
	}
	/**
	 * Get order details
	 * 
	 * @param id
	 */
	@GetMapping("/view/{id}")
	public Order viewOrder(@PathVariable("id") Long id){
		try{
			Order order=orderDao.findOne(id);
			return order;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}

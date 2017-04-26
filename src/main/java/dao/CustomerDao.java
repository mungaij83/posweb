package main.java.dao;

import main.java.models.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Long>{
	
	/**
	@Modifying
    @Query("update customers t SET t.first_name=:fname, "
    		+ "t.last_name=:lname,t.address=:address,t.csv=:csv, "
    		+ "t.credit_card=:card, t.expire_date=:expire, t.phone_number=:phone WHERE t.customer_id=:id")
    public void update(
    		@Param("id") Long id, 
    		@Param("fname") String firstName, 
    		@Param("lname") String lname,
    		@Param("address") String address,
    		@Param("phone") String phoneNumber,
    		@Param("csv")int csv, 
    		@Param("expire") String expire,
    		@Param("card")String card
    		);
    	*/
}

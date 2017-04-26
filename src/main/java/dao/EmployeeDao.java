package main.java.dao;

import main.java.models.Employees;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employees, Long> {
	
	/**
	@Modifying
    @Query("update employees t SET t.first_name=:fname, "
    		+ "t.last_name=:lname,t.address=:address,t.csv=:csv, "
    		+ "t.phone_number=:phone, t.email=:email, t.role=:role WHERE t.employee_id=:id")
    public void update(
    		@Param("id") Long id, 
    		@Param("fname") String firstName, 
    		@Param("lname") String lname,
    		@Param("address") String address,
    		@Param("phone")String phone, 
    		@Param("email") String email,
    		@Param("role") int role
    		);
    	*/
}

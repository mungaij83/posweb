package main.java.dao;

import main.java.models.LoginUser;

import org.springframework.data.repository.CrudRepository;

public interface LoginUserDao extends CrudRepository<LoginUser,Long>{
	public LoginUser findByUsername(String username);
}

package main.java.service;

import main.java.models.LoginUser;


public interface UserService {
	 void save(LoginUser user);
	 LoginUser findByUsername(String username);
}

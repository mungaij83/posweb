package main.java.service;

import main.java.dao.LoginUserDao;
import main.java.models.LoginUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private LoginUserDao loginUserDao;
	@Autowired
	PasswordEncoder bCrypt;
	
	@Override
	public void save(LoginUser user) {
		user.setPassword(bCrypt.encode(user.getPassword()));
		loginUserDao.save(user);
	}

	@Override
	public LoginUser findByUsername(String username) {
		return loginUserDao.findByUsername(username);
	}

}

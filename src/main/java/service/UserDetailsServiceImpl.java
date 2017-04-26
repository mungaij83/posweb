package main.java.service;

import java.util.HashSet;
import java.util.Set;

import main.java.models.LoginUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UserService userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("Username: "+username);
		LoginUser user=userDao.findByUsername(username);
		
		System.out.println("User: "+user);
		if(user==null){
			throw new UsernameNotFoundException("Username or password invalid");
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (String role : user.getSetRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
		return new User(user.getUsername(),user.getPassword(), grantedAuthorities);
	}
}

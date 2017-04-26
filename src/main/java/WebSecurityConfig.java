package main.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Restrict access to specific pages.
 * 
 * @author njoroge
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

	http.authorizeRequests().antMatchers("/login", "/logout").permitAll()
		.anyRequest().authenticated().and().formLogin()
		.usernameParameter("username").passwordParameter("password")
		.loginPage("/login").permitAll().and().logout()
		.logoutUrl("/logout").permitAll().and().csrf();

    }
    /**
     * BCCrypt password encrypt
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	return encoder;
    }
    /**
     * Set database DAO authentication provider
     * @return
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	authenticationProvider.setUserDetailsService(userDetailsService);
	authenticationProvider.setPasswordEncoder(passwordEncoder());
	return authenticationProvider;
    }
}

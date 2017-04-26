package main.java.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="login_user")
public class LoginUser {
	@Id
	String username;
	String password;
	@OneToOne
	Employees employee;
	@Temporal(TemporalType.TIMESTAMP)
	Date created;
	@ManyToOne
	Roles roles;
	boolean active;
	public Set<String> getSetRoles(){
		Set<String> s=new HashSet<>();
		s.add("admin");
		s.add("user");
		s.add("cashear");
		s.add("supervisor");
		s.add("manager");
		return s;
	}	
	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employees getEmployee() {
		return employee;
	}
	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}

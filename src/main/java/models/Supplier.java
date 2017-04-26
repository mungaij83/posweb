package main.java.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="suplier")
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long supplierId;
	@Column(name="first_name",nullable=false)
	String firstName;
	@Column(name="last_name",nullable=false)
	String lastName;
	String address;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_registered")
	Date dateRegistered;
	String phoneNumber;
	String description;
	
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long suplierId) {
		this.supplierId = suplierId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

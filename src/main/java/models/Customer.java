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
@Table(name="Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long customerId;
	@Column(name="customer_email",nullable=true,length=150)
	String customerEmail;
	@Column(name="first_name",nullable=false,length=15)
	String firstName;
	@Column(name="last_name",nullable=false,length=15)
	String lastName;
	@Column(name="phone_number",nullable=true,length=15)
	String phoneNumber;
	@Column(name="address",nullable=true,length=45)
	String address;
	@Column(name="date_registered")
	@Temporal(TemporalType.TIMESTAMP)
	Date registered;
	@Column(name="credit_card",nullable=false,unique=true)
	String creditCard;
	String expireDate;
	int csv;
	
	boolean deleted;
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegistered() {
		return registered;
	}
	public void setRegistered(Date registered) {
		this.registered = registered;
	}
	@Override
	public String toString(){
		return "Email:"+this.customerEmail+",FirstName:"+firstName;
	}
	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the creditCard
	 */
	public String getCreditCard() {
		return creditCard;
	}
	/**
	 * @param creditCard the creditCard to set
	 */
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	/**
	 * @return the expireDate
	 */
	public String getExpireDate() {
		return expireDate;
	}
	/**
	 * @param expireDate the expireDate to set
	 */
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	/**
	 * @return the csv
	 */
	public int getCsv() {
		return csv;
	}
	/**
	 * @param csv the csv to set
	 */
	public void setCsv(int csv) {
		this.csv = csv;
	}
}

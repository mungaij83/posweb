package main.java.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="products")
public class Product {
	long quantity;
	String name;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long entryId;
	@Column(name="product_code",unique=true,nullable=false)
	String productCode;
	String location;
	@ManyToOne
	Category category;
	@ManyToOne
	SubCategory subCategory;
	@Column(name="date_added")
	@Temporal(TemporalType.TIMESTAMP)
	Date dateAdded;
	@Column(name="last_updated")
	@Temporal(TemporalType.TIMESTAMP)
	Date lastUpdated;
	@Column(name="buying_price",nullable=false)
	Double buyingPrice;
	@Column(name="selling_price",nullable=false)
	Double sellingPrice;
	
	
	public Double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(Double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public Long getEntryId() {
		return entryId;
	}
	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}
	
}

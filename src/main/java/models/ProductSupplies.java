package main.java.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_suply")
public class ProductSupplies {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long entryId;
	@ManyToOne
	Product product;
	@ManyToOne
	Supplier suplier;
	Date dateSuplied;
	double buyingPrice;
	int quantity;
	boolean confirmed;
	/**
	 * @return the confirmed
	 */
	public boolean isConfirmed() {
		return confirmed;
	}
	/**
	 * @param confirmed the confirmed to set
	 */
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	/**
	 * @return the entryId
	 */
	public Long getEntryId() {
		return entryId;
	}
	/**
	 * @param entryId the entryId to set
	 */
	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	/**
	 * @return the suplier
	 */
	public Supplier getSuplier() {
		return suplier;
	}
	/**
	 * @param suplier the suplier to set
	 */
	public void setSuplier(Supplier suplier) {
		this.suplier = suplier;
	}
	/**
	 * @return the dateSuplied
	 */
	public Date getDateSuplied() {
		return dateSuplied;
	}
	/**
	 * @param dateSuplied the dateSuplied to set
	 */
	public void setDateSuplied(Date dateSuplied) {
		this.dateSuplied = dateSuplied;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the buyingPrice
	 */
	public double getBuyingPrice() {
		return buyingPrice;
	}
	/**
	 * @param buyingPrice the buyingPrice to set
	 */
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	
}

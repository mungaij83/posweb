package main.java.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sub_category")
public class SubCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id",length=80)
	Long categoryId;
	@ManyToOne
	Category category;
	@Column(name="category_name",nullable=false,length=45)
	String name;
	@Column(nullable=true,length=256)
	String description;
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

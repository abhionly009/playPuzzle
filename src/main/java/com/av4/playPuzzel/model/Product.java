package com.av4.playPuzzel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Product {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long pId;
	
	private String brand;
	
	private String  name ;
	
	@Column(columnDefinition="TEXT")
	private String description;
	
	private Long price;
	
	private Long discount;

	private String imageUrl; 
	
//	@JsonIgnore()
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","description","code"})
	@OneToOne(fetch=FetchType.LAZY)
	private Category category;
	
			
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", discount=" + discount + ", category=" + category + "]";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}

package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="pro_name")
	private String Pro_Name;
	
	@ManyToOne
	@JoinColumn(name = "cat_id")
	private Category category;
	  
	public Product() 
	{
		 
	}
	public Product(String pro_Name) {
		 
		Pro_Name = pro_Name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPro_Name() {
		return Pro_Name;
	}

	public void setPro_Name(String pro_Name) {
		Pro_Name = pro_Name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return   Pro_Name;
	}
 	
	
}

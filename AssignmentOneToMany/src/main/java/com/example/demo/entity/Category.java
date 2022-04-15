package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorys")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "Cat_name")
	private String Name;
	 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CaProId" ,referencedColumnName = "id")
	List<Product> prouct = new ArrayList<>();

	public Category() {
		
	}	

	public Category(String name) {
		 
		Name = name;
		 
	}
 
	public Category(long id, String name, List<Product> prouct) {
		this.id = id;
		Name = name;
		 
		this.prouct = prouct;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) 
	{
		Name = name;
	}
 

	public List<Product> getProuct() {
		return prouct;
	}

	public void setProuct(List<Product> prouct) {
		this.prouct = prouct;
	}

	@Override
	public String toString() {
		return Name;
	}

}

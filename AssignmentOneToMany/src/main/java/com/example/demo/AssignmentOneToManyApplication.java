package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepo;

@SpringBootApplication
public class AssignmentOneToManyApplication  
{
	public static void main(String[] args) 
	{
		SpringApplication.run(AssignmentOneToManyApplication.class, args);
	}

	@Autowired
	private CategoryRepo categoryRepo;
	 
}

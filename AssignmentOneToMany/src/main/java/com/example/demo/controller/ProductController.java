package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.ProductRepo;

@Controller
public class ProductController 
{
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	@GetMapping("/products")
	public String listCategories(Model model)
	{
		List<Product> listProducts = productRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		return "product";
	}
	
	
	 
	  @GetMapping("/products/new")
	   public String showCreateNewProductForm(Model model) 
	  {
		 List<Category> listCategories= categoryRepo.findAll();
	   model.addAttribute("listCategories", listCategories);
	   model.addAttribute("product", new Product());
	   
	   return "product_form";
	   }
	   
	   @PostMapping("/product/save")
	   public String saveProduct(Product product)
	   {
		  productRepo.save(product);
		   return "redirect:/";
	    }
	  @GetMapping("/product/edit/{id}")
	  public String showEditProductForm(@PathVariable("id")Long id,Model model)
	  {
		Product product=  productRepo.findById(id).get();
		model.addAttribute("product", product);
		
		 List<Category> listCategories= categoryRepo.findAll();
		   model.addAttribute("listCategories", listCategories);
		    
		
		return "product_form";
	  }
	
	  @GetMapping("/product/delete/{id}")
	  public String deleteProduct(@PathVariable("id")Long id,Model model)
	  {
		  productRepo.deleteById(id);
		  return "redirect:/products";
	  }
}

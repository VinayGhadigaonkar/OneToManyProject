package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	public String listProdcuts(Model model)
	{
		return finds(1, model);
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
	  
	  
	  @GetMapping("/pagess/{pageNos}")
		public String finds(@PathVariable(value = "pageNos")int pageNos,Model model)
		{
			int pageSize =5;
			Page<Product> page = productRepo.finds(pageNos, pageSize);
			List<Product> listProducts = page.getContent();
			model.addAttribute("currentPage", pageNos);
			model.addAttribute("totalPages", page.getTotalPages());
			model.addAttribute("totalItems", page.getTotalElements());
			model.addAttribute("listProducts", listProducts);
			return "product";
		}
}

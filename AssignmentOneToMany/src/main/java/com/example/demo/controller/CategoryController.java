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
public class CategoryController {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ProductRepo productRepo;

	/*
	 * @GetMapping("/categories") public String listCategories(Model model) {
	 * List<Category> listCategories = categoryRepo.findAll();
	 * model.addAttribute("listCategories", listCategories); return "categories"; }
	 */

	@GetMapping("/categories/new")
	public String showCategoryNewForm(Model model) {
		List<Product> listProducts = productRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("category", new Category());
		return "category_form";
	}

	@PostMapping("/category/save")
	public String saveCategory(Category category) {
		categoryRepo.save(category);
		return "redirect:/categories";
	}
	
	@GetMapping("/categories")
	public String listCategory(Model model)
	{
		List<Category> listCategory = categoryRepo.findAll();
		model.addAttribute("listCategory", listCategory);
		return "categories";
	}
	
	@GetMapping("/category/edit/{id}")
	public String showEditBrandForm(@PathVariable("id") Long id,Model model)
	{
		List<Product> listProducts = productRepo.findAll();

		Category category =categoryRepo.findById(id).get(); 
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("category",category);
 
	 
	 return "category_form";
	}

}

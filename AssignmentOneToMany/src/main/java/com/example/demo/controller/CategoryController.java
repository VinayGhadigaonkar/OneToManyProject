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
	
	//show contact handler
	//per page 5
	//current page = 0[page]
	
	@GetMapping("/categories")
	public String listCategory(Model model)
	{
		return findPaginated(1, model);
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
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo")int pageNo,Model model)
	{
		int pageSize =5;
		Page<Category> page = categoryRepo.findPaginated(pageNo, pageSize);
		List<Category> listCategory = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listCategory", listCategory);
		return "categories";
	}
	
}

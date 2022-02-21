package com.codingdojo.categoriesproducts.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.categoriesproducts.models.Category;
import com.codingdojo.categoriesproducts.models.Product;
import com.codingdojo.categoriesproducts.services.CategoryService;
import com.codingdojo.categoriesproducts.services.ProductService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryServ;
	
	@Autowired
	private ProductService productServ;
	
	@GetMapping("/categories")
	public String index(Model model, @ModelAttribute("category") Category category) {
		List<Category> categories = categoryServ.allCategories();
        model.addAttribute("categories", categories);
		return "/categories/index.jsp";
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {	
		categoryServ.createCategory(category);
		return "redirect:/categories";
	}
	
	@RequestMapping("/categories/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Category category = categoryServ.findCategory(id);
		List<Product> products = productServ.findProductsByCategoriesNotContains(category);
		model.addAttribute("category", category);
		model.addAttribute("products", products);		
		return "/categories/show.jsp";
	}
	
	@RequestMapping(value="/categories/{id}/addProduct", method = RequestMethod.POST)
	public String addCategory(Model model, @PathVariable("id") Long id, @RequestParam(value="product_id") Long product_id) {
		//Product product = productServ.findProduct(id);
		categoryServ.addProductToCategory(id,product_id);
		return "redirect:/categories/"+id;
	}
	
}

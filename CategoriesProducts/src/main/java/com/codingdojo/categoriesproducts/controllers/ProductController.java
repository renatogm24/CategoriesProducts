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
public class ProductController {

	@Autowired
	private ProductService productServ;
	
	@Autowired
	private CategoryService categoryServ;
	
	@GetMapping("/products")
	public String index(Model model, @ModelAttribute("product") Product product) {
		List<Product> products = productServ.allProducts();
        model.addAttribute("products", products);
		return "/products/index.jsp";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {	
		productServ.createProduct(product);
		return "redirect:/products";
	}
	
	@RequestMapping("/products/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Product product = productServ.findProduct(id);
		List<Category> categories = categoryServ.findCategoriesByProductsNotContains(product);
		System.out.println(categories);
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);		
		return "/products/show.jsp";
	}
	
	@RequestMapping(value="/products/{id}/addCategory", method = RequestMethod.POST)
	public String addCategory(Model model, @PathVariable("id") Long id, @RequestParam(value="category_id") Long category_id) {
		//Product product = productServ.findProduct(id);
		productServ.addCategoryToProduct(category_id, id);
		return "redirect:/products/"+id;
	}
	
}

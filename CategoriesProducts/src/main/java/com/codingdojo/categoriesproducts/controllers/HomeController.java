package com.codingdojo.categoriesproducts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.categoriesproducts.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productServ;
	
	/*@GetMapping("/")
	public String index(Model model) {

		Long product_id = 1L;
		Long category_id = 1L;
		
		productServ.addProductToCategory(category_id, product_id);

		return "Ok";

	}*/
	
	@GetMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}

}

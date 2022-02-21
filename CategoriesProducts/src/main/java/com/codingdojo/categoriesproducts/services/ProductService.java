package com.codingdojo.categoriesproducts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.categoriesproducts.models.Category;
import com.codingdojo.categoriesproducts.models.Product;
import com.codingdojo.categoriesproducts.repositories.CategoryRepository;
import com.codingdojo.categoriesproducts.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Product> allProducts() {
        return productRepo.findAll();
    }
   
    public Product createProduct(Product b) {
        return productRepo.save(b);
    }
    
    public Product updateProduct(Product b) {
        return productRepo.save(b);
    }
    
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }    
    
    public List<Product> findProductsByCategoriesNotContains(Category category) {
        return productRepo.findByCategoriesNotContains(category);
    }  
	
	public Product addCategoryToProduct(Long categoryId, Long productId) {
		Category thisCategory = categoryRepo.findCategoryById(categoryId);
		Product thisProduct = productRepo.findProductById(productId);
		thisProduct.getCategories().add(thisCategory);		
		return productRepo.save(thisProduct);
    }
	
	
}

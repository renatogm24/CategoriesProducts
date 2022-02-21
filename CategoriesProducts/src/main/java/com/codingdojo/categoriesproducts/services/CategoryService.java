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
public class CategoryService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Category> allCategories() {
        return categoryRepo.findAll();
    }
   
    public Category createCategory(Category b) {
        return categoryRepo.save(b);
    }
    
    public Category updateCategory(Category b) {
        return categoryRepo.save(b);
    }
    
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
    public List<Category> findCategoriesByProductsNotContains(Product product) {
        return categoryRepo.findByProductsNotContains(product);
    }    
	
	
	public Category addProductToCategory(Long categoryId, Long productId) {
		Category thisCategory = categoryRepo.findCategoryById(categoryId);
		Product thisProduct = productRepo.findProductById(productId);
		thisCategory.getProducts().add(thisProduct);		
		return categoryRepo.save(thisCategory);
    }

}

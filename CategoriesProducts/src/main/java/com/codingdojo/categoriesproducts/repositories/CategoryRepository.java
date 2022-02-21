package com.codingdojo.categoriesproducts.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.categoriesproducts.models.Category;
import com.codingdojo.categoriesproducts.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

	List<Category> findAll();
	
	Category findCategoryById(Long id);
	
	List<Category> findByProductsNotContains(Product product);
	
}

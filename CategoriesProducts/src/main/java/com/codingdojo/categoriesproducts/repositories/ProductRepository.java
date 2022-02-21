package com.codingdojo.categoriesproducts.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.categoriesproducts.models.Category;
import com.codingdojo.categoriesproducts.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

	List<Product> findAll();
	
	Product findProductById(Long id);
	
	List<Product> findByCategoriesNotContains(Category category);
	
}

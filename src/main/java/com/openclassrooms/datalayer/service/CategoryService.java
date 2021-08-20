package com.openclassrooms.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.datalayer.model.Category;
import com.openclassrooms.datalayer.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired 
	CategoryRepository categoryRepository;
	
	public Iterable<Category> getCategories() {
		return categoryRepository.findAll();
	}
	
	public Optional<Category> getCategoryById(int id) {
		return categoryRepository.findById(1);
	}
	
	public Category AddCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}
	
	// search by the name of the categorie
	public Iterable<Category> getCategoriesByName(String name){
		return categoryRepository.findByName(name);
	}
	
	// search by the name of a product of the categorie
	public Iterable<Category> getCategoriesByNameOfProduct(String name){
		return categoryRepository.findByProductsName(name);
	}
} 

package com.av4.playPuzzel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av4.playPuzzel.model.Category;
import com.av4.playPuzzel.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;

	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public List<Category> retrieveAllCategory(){
		return categoryRepo.findAll();
	}
	
	public long getCategoryCount() {
		return categoryRepo.count();
	}
}

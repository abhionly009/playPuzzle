package com.av4.playPuzzel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.av4.playPuzzel.model.Category;
import com.av4.playPuzzel.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/create")
	public Category createCategory( @RequestBody Category category) {
		return categoryService.saveCategory(category);
	}
	
	@GetMapping("/all")
	public List<Category> getAllCategory(){
		
		return categoryService.retrieveAllCategory();
	}
}

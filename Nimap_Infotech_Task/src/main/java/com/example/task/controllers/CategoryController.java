package com.example.task.controllers;

import com.example.task.Entities.Category;
import com.example.task.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
		return categoryService.getAllCategories(PageRequest.of(page, 10, Sort.by("id")));
	}

	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
		Optional<Category> category = categoryService.getCategoryById(id);
		return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
		Category updatedCategory = categoryService.updateCategory(id, category);
		return ResponseEntity.ok(updatedCategory);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
}
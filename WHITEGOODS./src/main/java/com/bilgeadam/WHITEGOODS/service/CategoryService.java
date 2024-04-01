package com.bilgeadam.WHITEGOODS.service;

import com.bilgeadam.WHITEGOODS.DTO.CategoryDTO;
import com.bilgeadam.WHITEGOODS.entity.Category;
import com.bilgeadam.WHITEGOODS.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category getCategoryByID(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.isEmpty() ? null : optionalCategory.get();
    }

    public Category saveCategory (CategoryDTO dto) {
        Category category = new Category();
        category.setId(dto.getCategoryId());
        return categoryRepository.save(category);
    }
    public Category updateCategory(CategoryDTO dto) {
        Optional<Category> optionalCategory = categoryRepository.findById(dto.getCategoryId());
        if (optionalCategory.isEmpty()) return null;
        Category category = optionalCategory.get();
        category.setId(dto.getCategoryId());
        return categoryRepository.save(category);
    }
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}


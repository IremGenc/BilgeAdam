package com.bilgeadam.WHITEGOODS.controller;

import com.bilgeadam.WHITEGOODS.DTO.CategoryDTO;
import com.bilgeadam.WHITEGOODS.entity.Category;
import com.bilgeadam.WHITEGOODS.service.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Category getCategoryByID(@PathVariable("id") Integer id) {
        return categoryService.getCategoryByID(id);
    }
    @PostMapping(path ="/add" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Category saveCategory(@RequestBody CategoryDTO dto) {
        return categoryService.saveCategory(dto);
    }

    @PutMapping(path ="/update" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Category updateCategory(@RequestBody CategoryDTO dto) throws Exception {
        return categoryService.updateCategory(dto);
    }
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteCategory(@PathVariable("id") Integer id) throws Exception {
        categoryService.deleteCategory(id);
        return "Silme İşlemi Başarılı.";
    }
}


package edu.famous.E_Commerce_Product_Search.product_service.service;

import edu.famous.E_Commerce_Product_Search.product_service.dto.request.CategoryRequestDto;
import edu.famous.E_Commerce_Product_Search.product_service.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    // Define methods for category operations
    void addCategory(CategoryRequestDto category);
    void updateCategory(CategoryRequestDto category);
    void deleteCategory(Long id);
    String getCategoryById(Long id);
    String getCategoryByName(String name);
    List<CategoryResponseDto> getAllCategories();
    List<String> getAllCategoryNames();
}

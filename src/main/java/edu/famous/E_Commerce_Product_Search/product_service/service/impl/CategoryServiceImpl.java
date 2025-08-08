package edu.famous.E_Commerce_Product_Search.product_service.service.impl;

import edu.famous.E_Commerce_Product_Search.product_service.dto.request.CategoryRequestDto;
import edu.famous.E_Commerce_Product_Search.product_service.dto.response.CategoryResponseDto;
import edu.famous.E_Commerce_Product_Search.product_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Override
    public void addCategory(CategoryRequestDto category) {

    }

    @Override
    public void updateCategory(CategoryRequestDto category) {

    }

    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public String getCategoryById(Long id) {
        return "";
    }

    @Override
    public String getCategoryByName(String name) {
        return "";
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return List.of();
    }

    @Override
    public List<String> getAllCategoryNames() {
        return List.of();
    }
}

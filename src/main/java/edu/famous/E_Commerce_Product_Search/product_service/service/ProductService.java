package edu.famous.E_Commerce_Product_Search.product_service.service;

import edu.famous.E_Commerce_Product_Search.product_service.dto.request.ProductRequestDto;
import edu.famous.E_Commerce_Product_Search.product_service.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    // Define methods for product operations
    void addProduct(ProductRequestDto product);
    ProductResponseDto getProductById(Long id);
    void updateProduct(ProductRequestDto product);
    void deleteProduct(Long id);
    ProductResponseDto getProductByName(String name);

    // Additional methods for searching, filtering, etc.
    List<ProductResponseDto> searchProducts(String query);
    List<ProductResponseDto> filterProductsByCategory(String category);
    List<ProductResponseDto> getAllProducts();
}

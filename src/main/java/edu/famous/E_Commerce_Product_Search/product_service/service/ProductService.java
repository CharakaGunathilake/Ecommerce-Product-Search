package edu.famous.E_Commerce_Product_Search.product_service.service;

import edu.famous.E_Commerce_Product_Search.common.core.response.ResponseWrapper;
import edu.famous.E_Commerce_Product_Search.product_service.dto.request.ProductRequestDto;
import edu.famous.E_Commerce_Product_Search.product_service.dto.response.ProductResponseDto;
import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    // Define methods for product operations
    ProductResponseDto addProduct(ProductRequestDto product);
    ProductResponseDto getProductById(Long id);
    ProductResponseDto updateProduct(Long id, ProductRequestDto product);
    void deleteProduct(Long id);
    ProductResponseDto getProductByName(String name);
    ProductResponseDto updateProductStatus(Long id, ProductStatus status);

    // Additional methods for searching, filtering, etc.
    Page<ProductResponseDto> searchProducts(String query, Pageable pageable);
    List<ProductResponseDto> filterProductsByCategory(String category);
    Page<ProductResponseDto> getAllProducts(Pageable pageable); // Method to get all products with pagination
    void indexProduct(Long productId); // Method to index a specific product
    void indexAllProducts(); // Method to index all products for search functionality

}

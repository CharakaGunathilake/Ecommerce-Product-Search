package edu.famous.E_Commerce_Product_Search.product_service.service.impl;

import edu.famous.E_Commerce_Product_Search.product_service.dto.request.ProductRequestDto;
import edu.famous.E_Commerce_Product_Search.product_service.dto.response.ProductResponseDto;
import edu.famous.E_Commerce_Product_Search.product_service.repository.ProductRepository;
import edu.famous.E_Commerce_Product_Search.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void addProduct(ProductRequestDto product) {

    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        return null;
    }

    @Override
    public void updateProduct(ProductRequestDto product) {

    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public ProductResponseDto getProductByName(String name) {
        return null;
    }

    @Override
    public List<ProductResponseDto> searchProducts(String query) {
        return List.of();
    }

    @Override
    public List<ProductResponseDto> filterProductsByCategory(String category) {
        return List.of();
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return List.of();
    }
}

package edu.famous.E_Commerce_Product_Search.product_service.controller;

import edu.famous.E_Commerce_Product_Search.common.core.response.ResponseWrapper;
import edu.famous.E_Commerce_Product_Search.product_service.dto.request.ProductRequestDto;
import edu.famous.E_Commerce_Product_Search.product_service.dto.response.ProductResponseDto;
import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductStatus;
import edu.famous.E_Commerce_Product_Search.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductResponseDto> getAllProducts(@PageableDefault Pageable pageable) {
        return productService.getAllProducts(pageable); // Placeholder response
    }

    @PostMapping
    public ResponseWrapper<ProductResponseDto> addProduct(@Valid @RequestBody ProductRequestDto product) {
        return ResponseWrapper.success(productService.addProduct(product)); // Placeholder for adding a product
    }

    @GetMapping("/search")
    public Page<ProductResponseDto> searchProducts(String query, @PageableDefault Pageable pageable) {
        return productService.searchProducts(query, pageable); // Placeholder for searching products
    }

    @GetMapping(params = "id")
    public ResponseWrapper<ProductResponseDto> getProductById(@RequestParam Long id) {
        return ResponseWrapper.success(productService.getProductById(id)); // Placeholder for getting a product by ID
    }

    @GetMapping(params = "name")
    public ResponseWrapper<ProductResponseDto> getProductByName(@RequestParam String name) {
        return ResponseWrapper.success(productService.getProductByName(name)); // Placeholder for getting a product by name
    }

    @PutMapping
    public ResponseWrapper<ProductResponseDto> updateProduct(@RequestParam Long id, @Valid @RequestBody ProductRequestDto product) {
        return ResponseWrapper.success(productService.updateProduct(id, product)); // Placeholder for updating a product
    }

    @PatchMapping("/status")
    public ResponseWrapper<ProductResponseDto> updateProductStatus(@RequestParam Long id, @RequestParam ProductStatus status) {
        return ResponseWrapper.success(productService.updateProductStatus(id, status));
    }

    @DeleteMapping
    public ResponseWrapper<Void> deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id); // Placeholder for deleting a product
        return ResponseWrapper.success(null); // Return success response
    }
}

package edu.famous.E_Commerce_Product_Search.product_service.search.controller;

import edu.famous.E_Commerce_Product_Search.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products/index")
@RequiredArgsConstructor
public class ProductIndexController {
    private final ProductService productService;

    @PostMapping("/all")
    public void indexAllProducts() {
        productService.indexAllProducts();
    }

    @PostMapping
    public void indexProduct(@RequestParam Long id) {
        productService.indexProduct(id);
    }
}

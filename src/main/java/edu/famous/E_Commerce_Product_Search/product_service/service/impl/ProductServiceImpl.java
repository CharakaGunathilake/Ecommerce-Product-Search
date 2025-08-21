package edu.famous.E_Commerce_Product_Search.product_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.famous.E_Commerce_Product_Search.product_service.dto.request.ProductRequestDto;
import edu.famous.E_Commerce_Product_Search.product_service.dto.response.ProductResponseDto;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Product;
import edu.famous.E_Commerce_Product_Search.product_service.repository.ProductRepository;
import edu.famous.E_Commerce_Product_Search.product_service.search.service.indexing.ProductIndexService;
import edu.famous.E_Commerce_Product_Search.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrServerException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductIndexService productIndexService;
    private final ModelMapper modelMapper;

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
    public Page<ProductResponseDto> searchProducts(String query, Pageable pageable) {
        // This method should implement the logic to search products based on the query
        return null;
    }


    @Override
    public List<ProductResponseDto> filterProductsByCategory(String category) {
        return List.of();
    }

    @Override
    @Transactional
    public Page<ProductResponseDto> getAllProducts(Pageable pageable) {
        // This method should implement the logic to retrieve all products with pagination
        log.info("Fetching all products with pagination: {}", pageable);
        return productRepository.findAll(pageable).map(product -> {
            try {
                // Convert Product entity to ProductResponseDto
                return modelMapper.map(product, ProductResponseDto.class);
            } catch (Exception e) {
                log.error("Error converting product to response DTO: {}", e.getMessage());
                throw new RuntimeException("Failed to convert product to response DTO", e);
            }
        });
    }

    @Override
    @Transactional
    public void indexProduct(Long productId) {
        // Fetch the product by ID
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        // Index the product using the ProductIndexService
        try {
            productIndexService.indexProduct(product);
        } catch (IOException | SolrServerException e) {
            log.error("Error indexing product with ID {}: {}", productId, e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error("Error indexing product with ID {}: {}", productId, e.getMessage());
            throw new RuntimeException("Failed to index product", e);
        }
        log.info("Product with ID {} indexed successfully", productId);
    }

    @Override
    @Transactional
    public void indexAllProducts() {
        // Fetch all products from the repository
        List<Product> products = productRepository.findAll();
        // Index each product using the ProductIndexService
        try {
            productIndexService.indexAllProducts(products);
        } catch (IOException | SolrServerException e) {
            log.error("Error indexing products: {}", e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error("Error indexing products: {}", e.getMessage());
            throw new RuntimeException("Failed to index products", e);
        }
        log.info("All products indexed successfully");
    }
}

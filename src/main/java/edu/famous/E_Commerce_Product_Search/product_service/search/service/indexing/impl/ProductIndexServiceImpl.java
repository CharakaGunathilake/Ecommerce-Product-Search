package edu.famous.E_Commerce_Product_Search.product_service.search.service.indexing.impl;

import edu.famous.E_Commerce_Product_Search.product_service.model.ProductDocument;
import edu.famous.E_Commerce_Product_Search.product_service.repository.ProductRepository;
import edu.famous.E_Commerce_Product_Search.product_service.repository.ProductSolrRepository;
import edu.famous.E_Commerce_Product_Search.product_service.search.service.indexing.ProductIndexService;
import edu.famous.E_Commerce_Product_Search.product_service.utils.search_utils.IndexingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductIndexServiceImpl implements ProductIndexService {

    private final ProductRepository productRepository;
    private final ProductSolrRepository productSolrRepository;

    @Override
    public void indexProduct(Long productId) {
        // Fetch the product by ID from the database
        productRepository.findById(productId).ifPresent(product -> {
            // Convert the product to a ProductDocument
            ProductDocument productDocument = IndexingUtils.convertProductToDocument(product);
            // Save the ProductDocument to Solr
            try {
                productSolrRepository.save(productDocument, Duration.ZERO);
            } catch (Exception e) {
                log.error("Error indexing product with ID: {}", productId, e);
                throw new RuntimeException("Failed to index product", e);
            }
            log.info("Indexed product with ID: {}", productId);
        });
        log.error("Product with ID: {} not found for indexing", productId);
        throw new RuntimeException("Product not found for indexing");
    }

    @Override
    public void indexAllProducts() {
        // Fetch all products from the database
        productRepository.findAll().forEach(product -> {
            // Convert each product to a ProductDocument
            ProductDocument productDocument = IndexingUtils.convertProductToDocument(product);
            // Save the ProductDocument to Solr
            try {
                productSolrRepository.save(productDocument, Duration.ZERO);
            } catch (Exception e) {
                log.error("Error indexing product with ID: {}", product.getId(), e);
                throw new RuntimeException("Failed to index product", e);
            }
            log.info("Indexed product with ID: {}", product.getId());
        });
        log.info("All products indexed successfully");
    }
}

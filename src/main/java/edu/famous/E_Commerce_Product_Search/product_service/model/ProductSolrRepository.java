package edu.famous.E_Commerce_Product_Search.product_service.model;

import org.springframework.data.solr.repository.SolrCrudRepository;

public interface ProductSolrRepository extends SolrCrudRepository<ProductDocument, String> {

    // Custom query methods can be defined here if needed
    // For example:
    // List<ProductDocument> findByCategory(String category);
    // List<ProductDocument> findByBrand(String brand);
    // List<ProductDocument> findByNameContaining(String name);
}

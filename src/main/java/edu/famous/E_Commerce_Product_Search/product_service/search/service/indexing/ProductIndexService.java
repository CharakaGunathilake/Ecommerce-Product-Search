package edu.famous.E_Commerce_Product_Search.product_service.search.service.indexing;

public interface ProductIndexService {
    public void indexProduct(Long productId);
    public void indexAllProducts();
}

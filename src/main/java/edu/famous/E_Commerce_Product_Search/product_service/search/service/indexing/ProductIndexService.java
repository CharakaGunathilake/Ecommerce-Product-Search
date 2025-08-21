package edu.famous.E_Commerce_Product_Search.product_service.search.service.indexing;

import edu.famous.E_Commerce_Product_Search.product_service.entity.Product;

import java.util.List;

public interface ProductIndexService {
    public void indexProduct(Product product) throws Exception;
    public void indexAllProducts(List<Product> products) throws Exception;
}

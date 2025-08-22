package edu.famous.E_Commerce_Product_Search.product_service.utils.indexing.persistence;

import edu.famous.E_Commerce_Product_Search.product_service.entity.Brand;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Category;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Discount;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Product;
import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductStatus;

public class ProductUtils {
    private ProductUtils() {
        // Private constructor to prevent instantiation
    }

    public static void setupNewProduct(Product product, Category category, Brand brand, Discount discount) {
        product.setStatus(ProductStatus.AVAILABLE);
        product.setNewArrival(true);
        product.setProductCode("PRD-" + System.currentTimeMillis());
        product.setCategory(category);
        product.setBrand(brand);
        product.setDiscount(discount);
    }
}

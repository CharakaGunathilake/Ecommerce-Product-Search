package edu.famous.E_Commerce_Product_Search.product_service.utils.search_utils;

import edu.famous.E_Commerce_Product_Search.product_service.entity.Product;
import edu.famous.E_Commerce_Product_Search.product_service.model.ProductDocument;

public class IndexingUtils {
    private IndexingUtils() {
        // Private constructor to prevent instantiation
    }

    private static final String PRODUCT_INDEX_NAME = "products";

    public static String getProductIndexName() {
        return PRODUCT_INDEX_NAME;
    }

    public static ProductDocument convertProductToDocument(Product product) {
        // This method converts a product entity to a ProductDocument
        return ProductDocument.builder()
                .id(product.getId().toString())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory().getName())
                .brand(product.getBrand().getName())
                .price(product.getPrice().doubleValue())
                .quantity(product.getQuantity())
                .imageUrl(product.getImageUrl())
                .bestSelling(product.getBestSelling())
                .recommended(product.getRecommended())
                .newArrival(product.getNewArrival())
                .build();

    }
}

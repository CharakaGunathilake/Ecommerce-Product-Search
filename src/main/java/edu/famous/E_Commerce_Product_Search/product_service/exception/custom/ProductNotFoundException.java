package edu.famous.E_Commerce_Product_Search.product_service.exception.custom;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

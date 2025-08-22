package edu.famous.E_Commerce_Product_Search.product_service.exception.custom;

public class ProductIndexingException extends RuntimeException {
    public ProductIndexingException(String message) {
        super(message);
    }
    public ProductIndexingException(String message, Throwable cause) {
        super(message, cause);
    }
}

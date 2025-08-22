package edu.famous.E_Commerce_Product_Search.product_service.exception.custom;

public class ProductPersistenceException extends RuntimeException {
    public ProductPersistenceException(String message) {
        super(message);
    }
    public ProductPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}

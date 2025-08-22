package edu.famous.E_Commerce_Product_Search.product_service.exception.custom;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException(String message) {
        super(message);
    }
}

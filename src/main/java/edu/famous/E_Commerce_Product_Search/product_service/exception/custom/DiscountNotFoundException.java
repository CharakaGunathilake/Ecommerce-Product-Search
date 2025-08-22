package edu.famous.E_Commerce_Product_Search.product_service.exception.custom;

public class DiscountNotFoundException extends RuntimeException {
    public DiscountNotFoundException(String message) {
        super(message);
    }
}

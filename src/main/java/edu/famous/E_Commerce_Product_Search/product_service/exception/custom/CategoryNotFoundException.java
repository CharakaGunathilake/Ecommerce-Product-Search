package edu.famous.E_Commerce_Product_Search.product_service.exception.custom;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}

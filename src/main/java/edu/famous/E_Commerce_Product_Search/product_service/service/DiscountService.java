package edu.famous.E_Commerce_Product_Search.product_service.service;

import edu.famous.E_Commerce_Product_Search.product_service.dto.request.DiscountRequestDto;

import java.util.List;

public interface DiscountService {
    // Define methods for discount operations
    void addDiscount(DiscountRequestDto discountRequestDto);
    void updateDiscount(DiscountRequestDto discountRequestDto);
    void deleteDiscount(String productId);
    double getDiscountByProductId(String productId);
    boolean isProductOnDiscount(String productId);
    double calculateDiscountedPrice(String productId, double originalPrice);
    List<DiscountRequestDto> getAllDiscounts();
}

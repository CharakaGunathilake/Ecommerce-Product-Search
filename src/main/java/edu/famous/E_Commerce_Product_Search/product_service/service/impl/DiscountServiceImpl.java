package edu.famous.E_Commerce_Product_Search.product_service.service.impl;

import edu.famous.E_Commerce_Product_Search.product_service.dto.request.DiscountRequestDto;
import edu.famous.E_Commerce_Product_Search.product_service.service.DiscountService;
import edu.famous.E_Commerce_Product_Search.product_service.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    @Override
    public void addDiscount(DiscountRequestDto discountRequestDto) {

    }

    @Override
    public void updateDiscount(DiscountRequestDto discountRequestDto) {

    }

    @Override
    public void deleteDiscount(String productId) {

    }

    @Override
    public double getDiscountByProductId(String productId) {
        return 0;
    }

    @Override
    public boolean isProductOnDiscount(String productId) {
        return false;
    }

    @Override
    public double calculateDiscountedPrice(String productId, double originalPrice) {
        return 0;
    }

    @Override
    public List<DiscountRequestDto> getAllDiscounts() {
        return List.of();
    }
}

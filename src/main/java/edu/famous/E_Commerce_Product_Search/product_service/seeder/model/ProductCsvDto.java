package edu.famous.E_Commerce_Product_Search.product_service.seeder.model;

import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductGrade;
import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductStatus;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductCsvDto(
        String name,
        String description,
        BigDecimal price,
        Integer quantity,
        ProductStatus status,
        String imageUrl,
        String productCode,
        Boolean bestSelling,
        Boolean recommended,
        Boolean newArrival,
        ProductGrade grade
) {
}

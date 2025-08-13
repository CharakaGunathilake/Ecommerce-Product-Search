package edu.famous.E_Commerce_Product_Search.product_service.seeder.model;

import edu.famous.E_Commerce_Product_Search.product_service.entity.Product;
import lombok.Builder;

import java.util.List;

@Builder
public record CategoryCsvDto(
        String name,
        String description,
        String categoryCode
) {
}

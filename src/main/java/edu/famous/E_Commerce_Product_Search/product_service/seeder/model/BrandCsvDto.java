package edu.famous.E_Commerce_Product_Search.product_service.seeder.model;

import lombok.Builder;

@Builder
public record BrandCsvDto(
        String name,
        String description,
        String logoUrl,
        String websiteUrl,
        String countryOfOrigin,
        String contactEmail,
        String contactPhone,
        String brandCode
) {
}

package edu.famous.E_Commerce_Product_Search.product_service.seeder.model;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record DiscountCsvDto(
        String code,
        Double percentage,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        String status
) {
}

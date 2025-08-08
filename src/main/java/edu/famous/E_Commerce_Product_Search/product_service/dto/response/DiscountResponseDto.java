package edu.famous.E_Commerce_Product_Search.product_service.dto.response;

import edu.famous.E_Commerce_Product_Search.product_service.enums.DiscountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountResponseDto {
    private Long id;
    private String code;
    private Double percentage;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private DiscountStatus status;
}

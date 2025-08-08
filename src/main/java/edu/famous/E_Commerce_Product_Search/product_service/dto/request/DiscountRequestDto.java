package edu.famous.E_Commerce_Product_Search.product_service.dto.request;

import edu.famous.E_Commerce_Product_Search.product_service.enums.DiscountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiscountRequestDto {
    private String code;
    private Double percentage;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private DiscountStatus status;
    private List<Long> applicableProductIds;
}

package edu.famous.E_Commerce_Product_Search.product_service.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDto {
    private String content;
    @NotNull(message = "Rating cannot be null")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    @Min(value = 1, message = "Rating must be between 1 and 5")
    private Integer rating;
    @NotNull(message = "User ID cannot be null")
    private Long productId;
}

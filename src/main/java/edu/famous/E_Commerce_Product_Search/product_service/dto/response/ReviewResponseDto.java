package edu.famous.E_Commerce_Product_Search.product_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {
    private Long id;
    private String content;
    private Integer rating;
    private Long productId;
    private Long userId;
}

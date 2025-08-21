package edu.famous.E_Commerce_Product_Search.product_service.dto.response;

import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductGrade;
import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private ProductStatus status;
    private String imageUrl;
    private String productCode;
    private CategoryResponseDto category;
    private BrandResponseDto brand;
    private ReviewResponseDto reviewId;
    private DiscountResponseDto discountId;
    private Boolean bestSelling;
    private Boolean recommended;
    private Boolean newArrival;
    private ProductGrade grade;
}

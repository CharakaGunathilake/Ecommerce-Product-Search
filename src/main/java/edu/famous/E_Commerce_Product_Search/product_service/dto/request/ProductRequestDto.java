package edu.famous.E_Commerce_Product_Search.product_service.dto.request;

import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductGrade;
import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    @NotNull(message = "Product name cannot be null")
    private String name;

    @NotNull(message = "Product description cannot be null")
    private String description;

    @NotNull(message = "Product price cannot be null")
    private BigDecimal price;

    @NotNull(message = "Product quantity cannot be null")
    private Integer quantity;

    private String imageUrl;

    @NotNull(message = "Product category cannot be null")
    private Long category;  // category id

    private Long brand;     // brand id

    private Long discount;  // discount id, optional

    private Boolean recommended;

    @NotNull(message = "Product grade cannot be null")
    private ProductGrade grade;
}

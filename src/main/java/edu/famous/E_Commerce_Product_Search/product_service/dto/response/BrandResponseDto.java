package edu.famous.E_Commerce_Product_Search.product_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandResponseDto {
    private Long id;
    private String name;
    private String description;
    private String logoUrl;
    private String websiteUrl;
    private String countryOfOrigin;
    private String contactEmail;
    private String contactPhone;
}

package edu.famous.E_Commerce_Product_Search.product_service.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandRequestDto {
    @NotNull(message = "Brand name cannot be null")
    private String name;
    @NotNull(message = "Brand description cannot be null")
    private String description;
    private String logoUrl;
    private String websiteUrl;
    @NotNull(message = "Brand country of origin cannot be null")
    private String countryOfOrigin;
    @Email(message = "Invalid email format")
    @NotNull(message = "Brand name cannot be null")
    private String contactEmail;
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
    @NotNull(message = "Brand contact phone cannot be null")
    private String contactPhone;
}

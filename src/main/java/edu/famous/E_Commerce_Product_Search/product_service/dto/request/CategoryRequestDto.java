package edu.famous.E_Commerce_Product_Search.product_service.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestDto {
    @NotNull(message = "Category name cannot be null")
    private String name;
    @NotNull(message = "Category description cannot be null")
    private String description;
    private String parentCategoryId; // Optional, if the category is a subcategory
}

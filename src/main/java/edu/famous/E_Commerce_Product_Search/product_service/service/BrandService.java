package edu.famous.E_Commerce_Product_Search.product_service.service;

import edu.famous.E_Commerce_Product_Search.product_service.dto.request.BrandRequestDto;
import edu.famous.E_Commerce_Product_Search.product_service.dto.response.BrandResponseDto;

import java.util.List;

public interface BrandService {
    //  Define methods for product operations
    void addBrand(BrandRequestDto brand);
    void updateBrand(BrandRequestDto brand);
    void deleteBrand(Long id);
    BrandResponseDto getBrandById(Long id);
    BrandResponseDto getBrandByName(String name);
    List<BrandResponseDto> getAllBrands();
}

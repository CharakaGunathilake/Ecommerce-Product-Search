package edu.famous.E_Commerce_Product_Search.product_service.service.impl;

import edu.famous.E_Commerce_Product_Search.product_service.dto.request.BrandRequestDto;
import edu.famous.E_Commerce_Product_Search.product_service.dto.response.BrandResponseDto;
import edu.famous.E_Commerce_Product_Search.product_service.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    @Override
    public void addBrand(BrandRequestDto brand) {

    }

    @Override
    public void updateBrand(BrandRequestDto brand) {

    }

    @Override
    public void deleteBrand(Long id) {

    }

    @Override
    public BrandResponseDto getBrandById(Long id) {
        return null;
    }

    @Override
    public BrandResponseDto getBrandByName(String name) {
        return null;
    }

    @Override
    public List<BrandResponseDto> getAllBrands() {
        return List.of();
    }
}

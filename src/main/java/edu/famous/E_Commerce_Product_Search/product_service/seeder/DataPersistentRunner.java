package edu.famous.E_Commerce_Product_Search.product_service.seeder;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Brand;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Category;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Discount;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Product;
import edu.famous.E_Commerce_Product_Search.product_service.repository.BrandRepository;
import edu.famous.E_Commerce_Product_Search.product_service.repository.CategoryRepository;
import edu.famous.E_Commerce_Product_Search.product_service.repository.DiscountRepository;
import edu.famous.E_Commerce_Product_Search.product_service.repository.ProductRepository;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.model.BrandCsvDto;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.model.CategoryCsvDto;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.model.DiscountCsvDto;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.model.ProductCsvDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataPersistentRunner {
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final DiscountRepository discountRepository;
    private final ProductRepository productRepository;
    private final ObjectMapper mapper;

    public void persistCsvToRepository(List<CategoryCsvDto> categoryList, List<BrandCsvDto> brandList, List<DiscountCsvDto> discountList, List<ProductCsvDto> productList) {
        try {
            final List<Brand> brands = brandRepository.saveAll(
                    brandList.stream()
                            .map(dto -> mapper.convertValue(dto, Brand.class))
                            .collect(Collectors.toList())
            );
            final List<Category> categories = categoryRepository.saveAll(
                    categoryList.stream()
                            .map(dto -> mapper.convertValue(dto, Category.class))
                            .collect(Collectors.toList())
            );
            final List<Discount> discounts = discountRepository.saveAll(
                    discountList.stream()
                            .map(dto -> mapper.convertValue(dto, Discount.class))
                            .collect(Collectors.toList())
            );
            productRepository.saveAll(
                    productList.stream()
                            .map(dto -> {
                                Random random = new Random();
                                Product product = mapper.convertValue(dto, Product.class);
                                product.setCategory(categories.get(random.nextInt(categories.size())));
                                product.setBrand(brands.get(random.nextInt(brands.size())));
                                product.setDiscount(discounts.isEmpty() ? null : discounts.get(random.nextInt(discounts.size())));
                                return product;
                            })
                            .collect(Collectors.toList())
            );
        } catch (Exception e) {
            log.error("Failed persisting data -> {}", e.getMessage(), e);
        }
    }


}

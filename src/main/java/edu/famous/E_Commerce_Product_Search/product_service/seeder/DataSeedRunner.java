package edu.famous.E_Commerce_Product_Search.product_service.seeder;

import edu.famous.E_Commerce_Product_Search.product_service.seeder.faker.BrandFakerService;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.faker.CategoryFakerService;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.faker.DiscountFakerService;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.faker.ProductFakerService;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.model.BrandCsvDto;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.model.CategoryCsvDto;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.model.DiscountCsvDto;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.model.ProductCsvDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@Profile("seed")
public class DataSeedRunner implements CommandLineRunner {

    private final CsvWriter csvWriter;
    private final BrandFakerService brandFakerService;
    private final CategoryFakerService categoryFakerService;
    private final DiscountFakerService discountFakerService;
    private final ProductFakerService productFakerService;
    private final DataPersistentRunner dataPersistentRunner;

    @Override
    public void run(String... args) throws Exception {
        final String baseOutputPath = "src/main/resources/data/";
        log.info("Starting data seeding...");

        try {
            // Generate brands
            log.info("Generating brands...");
            List<BrandCsvDto> brands = brandFakerService.generateBrands(100);
            csvWriter.writeCsv(baseOutputPath + "brands.csv", brands, BrandCsvDto.class);
            log.info("Brands data seeded successfully. Generated {} brands.", brands.size());

            // Generate categories
            log.info("Generating categories...");
            List<CategoryCsvDto> categories = categoryFakerService.generateCategories(100);
            csvWriter.writeCsv(baseOutputPath + "categories.csv", categories, CategoryCsvDto.class);
            log.info("Categories data seeded successfully. Generated {} categories.", categories.size());

            // Generate discounts
            log.info("Generating discounts...");
            List<DiscountCsvDto> discounts = discountFakerService.generateDiscounts(20);
            csvWriter.writeCsv(baseOutputPath + "discounts.csv", discounts, DiscountCsvDto.class);
            log.info("Discounts data seeded successfully. Generated {} discounts.", discounts.size());

            //Generate products (depends on brands, categories, and discounts)
            log.info("Generating products...");
            List<ProductCsvDto> products = productFakerService.generateProducts(50000);
            csvWriter.writeCsv(baseOutputPath + "products.csv", products, ProductCsvDto.class);
            log.info("Products data seeded successfully. Generated {} products.", products.size());
            dataPersistentRunner.persistCsvToRepository(categories, brands, discounts, products);
            log.info("Data seeding completed successfully!");

        } catch (Exception e) {
            log.error("Error occurred during data seeding: {}", e.getMessage(), e);
            throw e; // Re-throw to maintain the method signature
        }
    }
}

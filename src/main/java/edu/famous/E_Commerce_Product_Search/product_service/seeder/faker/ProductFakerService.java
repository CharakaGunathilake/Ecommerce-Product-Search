package edu.famous.E_Commerce_Product_Search.product_service.seeder.faker;

import com.github.javafaker.Faker;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Brand;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Category;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Discount;
import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductGrade;
import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductStatus;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.model.ProductCsvDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class ProductFakerService {

    private final Faker faker;
    private final Random random;

    public ProductFakerService() {
        this.faker = new Faker();
        this.random = new Random();
    }

    public List<ProductCsvDto> generateProducts(
            int count
    ) {
        return IntStream.range(0, count)
                .mapToObj(i -> ProductCsvDto.builder()
                        .name(faker.commerce().productName())
                        .description(faker.lorem().sentence(15))
                        .price(BigDecimal.valueOf(Double.parseDouble(faker.commerce().price(5.0, 2000.0))))
                        .quantity(random.nextInt(500) + 1)
                        .status(ProductStatus.values()[random.nextInt(ProductStatus.values().length)])
                        .imageUrl(faker.internet().image())
                        .productCode(String.format("PRD%03d", i + 1))
                        .bestSelling(random.nextBoolean())
                        .recommended(random.nextBoolean())
                        .newArrival(random.nextBoolean())
                        .grade(ProductGrade.values()[random.nextInt(ProductGrade.values().length)])
                        .build()
                )
                .toList();
    }
}

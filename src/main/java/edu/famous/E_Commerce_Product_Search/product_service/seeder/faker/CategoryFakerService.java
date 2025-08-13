package edu.famous.E_Commerce_Product_Search.product_service.seeder.faker;

import com.github.javafaker.Faker;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.model.CategoryCsvDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryFakerService {

    private final Faker faker;

    public CategoryFakerService() {
        this.faker = new Faker();
    }

    public List<CategoryCsvDto> generateCategories(int count) {
        List<CategoryCsvDto> categories = new ArrayList<>();
        int index = 0;
        while (index++ != count) {
            categories.add(
                    CategoryCsvDto.builder()
                            .name(faker.commerce().department())
                            .description(faker.lorem().sentence(10))
                            .categoryCode(String.format("CAT%03d", index))
                            .build()
            );
        }
        return categories;
    }
}

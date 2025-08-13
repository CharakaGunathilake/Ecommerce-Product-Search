package edu.famous.E_Commerce_Product_Search.product_service.seeder.faker;

import com.github.javafaker.Faker;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.model.DiscountCsvDto;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DiscountFakerService {

    private final Faker faker;

    public DiscountFakerService(){
        this.faker = new Faker();
    }

    public List<DiscountCsvDto> generateDiscounts(int count) {
        List<DiscountCsvDto> discounts = new ArrayList<>();
        int index = 0;
        while (index++ != count) {
            Date startDate = faker.date().past(30, java.util.concurrent.TimeUnit.DAYS);
            Date endDate = faker.date().future(30, java.util.concurrent.TimeUnit.DAYS);
            discounts.add(
                    DiscountCsvDto.builder()
                            .code(String.format("DISC%03d", index))
                            .description(faker.lorem().sentence(10))
                            .percentage((double) faker.number().numberBetween(5, 50))
                            .startDate(startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                            .endDate(endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                            .status("ACTIVE")
                            .build()
            );
        }
        return discounts;
    }
}

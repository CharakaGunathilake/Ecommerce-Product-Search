package edu.famous.E_Commerce_Product_Search.product_service.seeder.faker;

import com.github.javafaker.Faker;
import edu.famous.E_Commerce_Product_Search.product_service.seeder.model.BrandCsvDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandFakerService {

    private final Faker faker;

    public BrandFakerService(){
        this.faker = new Faker();
    }

    public List<BrandCsvDto> generateBrands(int count){
        List<BrandCsvDto> brands = new ArrayList<>();
        int index = 0;
        String companyName;
        while(index++ != count){
            brands.add(
                    BrandCsvDto.builder()
                            .name(companyName = faker.company().name())
                            .description(faker.company().catchPhrase())
                            .countryOfOrigin(faker.country().name())
                            .logoUrl(faker.company().logo())
                            .websiteUrl(faker.company().url())
                            .contactEmail("contact@" + companyName.toLowerCase().replaceAll("\\s+", "") + ".com")
                            .contactPhone(faker.phoneNumber().phoneNumber())
                            .brandCode(String.format("BR%03d",index))
                            .build()
            );
        }
        return brands;
    }
}

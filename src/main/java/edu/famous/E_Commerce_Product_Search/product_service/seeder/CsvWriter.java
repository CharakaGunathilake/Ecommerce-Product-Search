package edu.famous.E_Commerce_Product_Search.product_service.seeder;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Component
public class CsvWriter {
    public <T> void writeCsv(String fileName, List<T> data, Class<T> type) {
        try (Writer writer = Files.newBufferedWriter(Paths.get(fileName))) {
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer).build();
            beanToCsv.write(data);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}


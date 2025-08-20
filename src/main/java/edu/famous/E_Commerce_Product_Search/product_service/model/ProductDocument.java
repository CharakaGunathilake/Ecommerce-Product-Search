package edu.famous.E_Commerce_Product_Search.product_service.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "products")
public class ProductDocument {
    //@Field
    @Id
    private String id;

    //@Field
    private String name;

    //@Field
    private String description;

    //@Field
    private String category;

    //@Field
    private String brand;

    //@Field
    private Double price;

    //@Field
    private Integer quantity;

    //@Field
    private String imageUrl;

    //@Field
    private Boolean bestSelling;

    //@Field
    private Boolean recommended;

    //@Field
    private Boolean newArrival;
}

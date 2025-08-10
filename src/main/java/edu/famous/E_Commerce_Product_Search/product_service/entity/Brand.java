package edu.famous.E_Commerce_Product_Search.product_service.entity;

import edu.famous.E_Commerce_Product_Search.utils_common.PersistedObject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.List;

@Data
@Entity
@Table(name = "brands")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Brand extends PersistedObject {
    @Column(nullable = false, length = 100)
    private String name;
    @Lob
    @Column(nullable = false)
    private String description;
    private String logoUrl;
    @Column(name = "website_url")
    private String websiteUrl;
    @Column(name = "country_of_origin", nullable = false)
    private String countryOfOrigin;
    @Column(name = "contact_email", nullable = false, length = 100)
    private String contactEmail;
    @Column(name = "contact_phone", length = 20)
    private String contactPhone;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;
    @Column(nullable = false, unique = true)
    private String brandCode;
}

package edu.famous.E_Commerce_Product_Search.product_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    @Basic(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private String description;
    private String logoUrl;
    @Column(name = "website_url")
    private String websiteUrl;
    @Column(name = "country_of_origin", nullable = false)
    private String countryOfOrigin;
    @Column(name = "contact_email", nullable = false, length = 100)
    private String contactEmail;
    @Column(name = "contact_phone", length = 30)
    private String contactPhone;
    @JsonIgnore
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;
    @Column(nullable = false, unique = true)
    private String brandCode;
}

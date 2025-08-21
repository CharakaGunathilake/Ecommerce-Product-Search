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
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Category extends PersistedObject {
    @Column(nullable = false, length = 100)
    private String name;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, unique = true)
    private String categoryCode;
    //    @ManyToOne
//    @JoinColumn(name = "parent_id")
//    private CategoryEntity parentCategory;
//
//    @OneToMany(mappedBy = "parentCategory")
//    private List<CategoryEntity> subCategories;
    @JsonIgnore
    @Column(nullable = false)
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

}

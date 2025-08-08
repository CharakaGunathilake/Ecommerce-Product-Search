package edu.famous.E_Commerce_Product_Search.product_service.entity;

import edu.famous.E_Commerce_Product_Search.utils_common.PersistedObject;
import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductGrade;
import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends PersistedObject {
    @Column(nullable = false, length = 100)
    private String name;
    @Lob
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    private String imageUrl;
    @Column(nullable = false)
    private String productCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Long category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Long brand;
    @OneToOne
    @JoinColumn(name = "review_id")
    private Long review;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private Long discount;
    private Boolean bestSelling;
    private Boolean recommended;
    private Boolean newArrival;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductGrade grade;
}

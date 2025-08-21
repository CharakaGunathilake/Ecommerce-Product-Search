package edu.famous.E_Commerce_Product_Search.product_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.famous.E_Commerce_Product_Search.product_service.enums.DiscountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "discounts")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Discount extends PersistedObject {
    @Column(nullable = false, length = 100)
    private String code;
    @Column(nullable = false)
    private Double percentage;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String description;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DiscountStatus status;
    @JsonIgnore
    @OneToMany(mappedBy = "discount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> applicableProducts;
}

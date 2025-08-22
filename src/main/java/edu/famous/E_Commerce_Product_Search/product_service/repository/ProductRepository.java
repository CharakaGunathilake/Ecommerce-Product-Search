package edu.famous.E_Commerce_Product_Search.product_service.repository;

import edu.famous.E_Commerce_Product_Search.product_service.entity.Product;
import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByIdAndStatusNot(Long id, ProductStatus status);
}

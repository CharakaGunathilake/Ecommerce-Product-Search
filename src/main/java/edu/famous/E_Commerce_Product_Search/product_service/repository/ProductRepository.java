package edu.famous.E_Commerce_Product_Search.product_service.repository;

import edu.famous.E_Commerce_Product_Search.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

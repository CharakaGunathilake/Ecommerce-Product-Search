package edu.famous.E_Commerce_Product_Search.product_service.repository;

import edu.famous.E_Commerce_Product_Search.product_service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

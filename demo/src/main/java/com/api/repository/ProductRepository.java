package com.api.repository;

import com.api.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("UPDATE Product p SET p.productName = ?1 , p.productDesc =?2 , p.expiryDate = ?3 WHERE p.productId = ?4")
    @Modifying
    @Transactional
    void updateProduct(String productName, String productDesc, LocalDate expiryDate, Integer productId);
}

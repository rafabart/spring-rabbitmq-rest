package com.invillia.consumerspringrabbitmq.repository;

import com.invillia.consumerspringrabbitmq.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

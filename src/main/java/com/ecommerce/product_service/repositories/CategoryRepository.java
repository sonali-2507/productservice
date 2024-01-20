package com.ecommerce.product_service.repositories;

import com.ecommerce.product_service.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}

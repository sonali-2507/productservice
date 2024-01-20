package com.ecommerce.product_service.repositories;

import com.ecommerce.product_service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByTitleAndPrice_currency(String title, String currency);
    @Query(value = SqlQueries.GET_ALL_PRODUCTS_BY_TITLE,nativeQuery = true)
    Product findByTitle(String title);
    @Query(value = "select Product from Product where Product.title = :title",nativeQuery = false)
    Product findByTitle2(String title);

}

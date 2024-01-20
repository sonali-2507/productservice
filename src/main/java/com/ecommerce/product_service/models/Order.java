package com.ecommerce.product_service.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "orders")
public class Order extends BaseModel{
    @ManyToMany
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(name = "orderId"),// order id column in mapping table
            inverseJoinColumns = @JoinColumn(name = "productId") // product id column in mapping table
    )
    private List<Product>products;
}

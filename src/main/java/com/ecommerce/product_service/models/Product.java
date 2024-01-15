package com.ecommerce.product_service.models;

import jdk.jfr.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    private Category category;
    private double price;
}

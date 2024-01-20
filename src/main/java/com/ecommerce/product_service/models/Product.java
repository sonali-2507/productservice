package com.ecommerce.product_service.models;

import jakarta.persistence.*;
//import jdk.jfr.Category;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category")
   private Category category;
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}) //cascade ->if any operation is perform on product then corresponding changes should also gets apply on the price
    private Price price; //CascadeType.PERSIST-> it will insert a price first n then it will save the to product table, if we dont save the price first
//    @ManyToMany
//    private Order order;


}

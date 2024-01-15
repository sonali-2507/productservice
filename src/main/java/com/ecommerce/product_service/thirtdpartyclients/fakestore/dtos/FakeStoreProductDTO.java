package com.ecommerce.product_service.thirtdpartyclients.fakestore.dtos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String category;
    private double price;
    private String description;
    private String image;
}

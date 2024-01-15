package com.ecommerce.product_service.services;

import com.ecommerce.product_service.dtos.GenericProductDTO;
import com.ecommerce.product_service.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    public GenericProductDTO getProductById(Long id) throws NotFoundException;

    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO);

    List<GenericProductDTO> getAllProducts();

    GenericProductDTO deleteProduct(Long id);
}

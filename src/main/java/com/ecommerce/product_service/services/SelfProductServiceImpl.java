package com.ecommerce.product_service.services;

import com.ecommerce.product_service.dtos.GenericProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements  ProductService{
    @Override
    public GenericProductDTO getProductById(Long id) {
        System.out.println("Calling from self product service");
        return  null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        return null;
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDTO deleteProduct(Long id) {
        return null;
    }
}

package com.ecommerce.product_service.services;


import com.ecommerce.product_service.dtos.GenericProductDTO;
import com.ecommerce.product_service.exceptions.NotFoundException;
import com.ecommerce.product_service.thirtdpartyclients.fakestore.FakeStoreProductClient;
import com.ecommerce.product_service.thirtdpartyclients.fakestore.dtos.FakeStoreProductDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements  ProductService{
    private FakeStoreProductClient fakeStoreProductClient;

    @Autowired
    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient) {
        this.fakeStoreProductClient = fakeStoreProductClient;
    }

    public GenericProductDTO convertFakeStoreToGenericProductDto(FakeStoreProductDTO fakeStoreProductDTO){
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setId(fakeStoreProductDTO.getId());
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        return genericProductDTO;

           }
    @Override
    public GenericProductDTO getProductById(Long id) throws NotFoundException {
        return convertFakeStoreToGenericProductDto(
                fakeStoreProductClient.getProductById(id)
        );
    }
    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {

        return convertFakeStoreToGenericProductDto(fakeStoreProductClient
                .createProduct(product));
    }
   @Override
    public List<GenericProductDTO> getAllProducts(){
        List<FakeStoreProductDTO>fakeStoreProductDTOS = fakeStoreProductClient.getAllProducts();
        List<GenericProductDTO>genericProductDTOS = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){
            GenericProductDTO genericProductDTO = convertFakeStoreToGenericProductDto(fakeStoreProductDTO);
            genericProductDTOS.add(genericProductDTO);
        }
        return genericProductDTOS;
    }
    @Override
    public GenericProductDTO deleteProduct(Long id){
        return convertFakeStoreToGenericProductDto(fakeStoreProductClient
                .deleteProduct(id));
    }
}

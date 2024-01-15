package com.ecommerce.product_service.thirtdpartyclients.fakestore;

import com.ecommerce.product_service.dtos.GenericProductDTO;
import com.ecommerce.product_service.exceptions.NotFoundException;
import com.ecommerce.product_service.thirtdpartyclients.fakestore.dtos.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreProductClient {
    @Value("${fakestore.api.baseurl}")
    private  String fakeStoreApiBaseUrl;
    @Value("${fakestore.api.product}")
    private String fakeStoreProductPath;
    private final  String productPath = "/products";

    private String producturl = fakeStoreApiBaseUrl + productPath +"{id}";
    private String productRequestUrl =  fakeStoreApiBaseUrl + fakeStoreProductPath;
    private final RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder,
                                  @Value("${fakestore.api.baseurl}") String fakeStoreApiBaseUrl,
                                  @Value("${fakestore.api.product}") String fakeStoreProductPath ) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.producturl = fakeStoreApiBaseUrl + productPath +"/{id}";
        this.productRequestUrl =  fakeStoreApiBaseUrl + fakeStoreProductPath;
    }

    public FakeStoreProductDTO getProductById(Long id)throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO>response = restTemplate.getForEntity(
                producturl,FakeStoreProductDTO.class,
                id);
        FakeStoreProductDTO fakeStoreProductDto = response.getBody();

        if(fakeStoreProductDto == null){
            throw  new NotFoundException("product id  with id : "+id +" not found");

        }
        return fakeStoreProductDto;
    }

    public FakeStoreProductDTO createProduct(GenericProductDTO product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO>response = restTemplate
                .postForEntity(productRequestUrl,product, FakeStoreProductDTO.class);

        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        return fakeStoreProductDTO;
    }

    public List<FakeStoreProductDTO> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate
                .getForEntity(productRequestUrl,FakeStoreProductDTO[].class);
        FakeStoreProductDTO []fakeStoreProductDTOS = response.getBody();
        return Arrays.asList(fakeStoreProductDTOS);
    }
    public FakeStoreProductDTO deleteProduct(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO>response = restTemplate
                .exchange(producturl, HttpMethod.DELETE,null,FakeStoreProductDTO.class, id);
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        return fakeStoreProductDTO;
    }

}

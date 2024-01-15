package com.ecommerce.product_service.controllers;

import com.ecommerce.product_service.dtos.GenericProductDTO;
import com.ecommerce.product_service.exceptions.NotFoundException;
import com.ecommerce.product_service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public GenericProductDTO getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return  productService.getProductById(id);
    }
//
    @PostMapping
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO genericProductDTO){
        return productService.createProduct(genericProductDTO);
    }
    @GetMapping
    public List<GenericProductDTO> getAllProducts(){
        return  productService.getAllProducts();
    }
    @DeleteMapping({"id"})
    public ResponseEntity<GenericProductDTO> deleteProduct(@PathVariable("id")Long id){
        return  new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
}

package com.vuongtq.springdemo.controller;

import com.vuongtq.springdemo.entity.ProductEntity;
import com.vuongtq.springdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
// localhost:8002/v1/api
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ProductEntity createProduct(ProductEntity productEntity) {
        return productService.createProduct(productEntity);
    }

    @GetMapping("/product")
    public List<ProductEntity> findAllProducts() {
        return productService.findAllProducts();
    }
}

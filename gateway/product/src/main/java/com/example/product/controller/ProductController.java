package com.example.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping(value = "/product/{productId}")
    public String getProductById(@PathVariable String productId) {
        return "Query by productId：" + productId;
    }
}

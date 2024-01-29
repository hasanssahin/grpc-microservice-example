package com.hasansahin.productservice.controller;

import com.hasansahin.productservice.dto.request.CategoryCreateRequest;
import com.hasansahin.productservice.dto.request.ProductCreateRequest;
import com.hasansahin.productservice.dto.response.CategoryCreateResponse;
import com.hasansahin.productservice.dto.response.ProductCreateResponse;
import com.hasansahin.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<ProductCreateResponse> saveCategory(@Valid @RequestBody ProductCreateRequest productCreateRequest){
        return ResponseEntity.ok(productService.saveProduct(productCreateRequest));
    }

    @GetMapping
    public ResponseEntity<ProductCreateResponse> getProductByUuid(@RequestParam String uuid){
        return ResponseEntity.ok(productService.getProductByUuid(uuid));
    }
}

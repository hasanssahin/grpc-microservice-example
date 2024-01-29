package com.hasansahin.productservice.service;

import com.hasansahin.productservice.dto.converter.ProductConverter;
import com.hasansahin.productservice.dto.request.ProductCreateRequest;
import com.hasansahin.productservice.dto.response.ProductCreateResponse;
import com.hasansahin.productservice.exception.CategoryNotFoundException;
import com.hasansahin.productservice.exception.ProductNotFoundException;
import com.hasansahin.productservice.model.Category;
import com.hasansahin.productservice.model.Product;
import com.hasansahin.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final CategoryService categoryService;
    public ProductCreateResponse saveProduct(ProductCreateRequest productCreateRequest){
        Product product=productConverter.convertProductCreateRequestToProduct(productCreateRequest);
        Category category=categoryService.getCategoryByUuidProtected(productCreateRequest.categoryUuid());
        product.setCategory(category);
        Product savedProduct=productRepository.save(product);
        return productConverter.convertProductToProductCreateResponse(savedProduct);
    }
    public ProductCreateResponse getProductByUuid(String uuid){
        Product product=productRepository.findByUuid(uuid).orElseThrow(()->new ProductNotFoundException("Product not found!"));
        return productConverter.convertProductToProductCreateResponse(product);
    }
    protected Product getProductByUuidProtected(String uuid){
        return productRepository.findByUuid(uuid).orElseThrow(()-> new ProductNotFoundException("Product not found!"));
    }
}

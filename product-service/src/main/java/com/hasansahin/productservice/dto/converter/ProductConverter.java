package com.hasansahin.productservice.dto.converter;

import com.hasansahin.productservice.dto.request.CategoryCreateRequest;
import com.hasansahin.productservice.dto.request.ProductCreateRequest;
import com.hasansahin.productservice.dto.response.CategoryCreateResponse;
import com.hasansahin.productservice.dto.response.ProductCreateResponse;
import com.hasansahin.productservice.model.Category;
import com.hasansahin.productservice.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product convertProductCreateRequestToProduct(ProductCreateRequest productCreateRequest){
        return new Product(productCreateRequest.name(), productCreateRequest.description(), productCreateRequest.quantity(), productCreateRequest.price());
    }
    public ProductCreateResponse convertProductToProductCreateResponse(Product product){
        return new ProductCreateResponse(product.getName(), product.getDescription(), product.getQuantity(), product.getPrice(), product.getCategory().getName(), product.getUuid());
    }
}

package com.hasansahin.productservice.dto.converter;

import com.hasansahin.productservice.dto.request.CategoryCreateRequest;
import com.hasansahin.productservice.dto.response.CategoryCreateResponse;
import com.hasansahin.productservice.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    public Category convertCategoryCreateRequestToCategory(CategoryCreateRequest categoryCreateRequest){
        return new Category(categoryCreateRequest.name());
    }
    public CategoryCreateResponse convertCategoryToCategoryCreateResponse(Category category){
        return new CategoryCreateResponse(category.getName(), category.getUuid());
    }
}

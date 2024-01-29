package com.hasansahin.productservice.service;

import com.hasansahin.productservice.dto.converter.CategoryConverter;
import com.hasansahin.productservice.dto.request.CategoryCreateRequest;
import com.hasansahin.productservice.dto.response.CategoryCreateResponse;
import com.hasansahin.productservice.exception.CategoryNotFoundException;
import com.hasansahin.productservice.model.Category;
import com.hasansahin.productservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    public CategoryCreateResponse saveCategory(CategoryCreateRequest categoryCreateRequest){
        Category category=categoryConverter.convertCategoryCreateRequestToCategory(categoryCreateRequest);
        Category savedCategory=categoryRepository.save(category);
        return categoryConverter.convertCategoryToCategoryCreateResponse(savedCategory);
    }
    public CategoryCreateResponse getCategoryByUuid(String uuid){
        Category category=categoryRepository.findByUuid(uuid).orElseThrow(()-> new CategoryNotFoundException("Category not found!"));
        return categoryConverter.convertCategoryToCategoryCreateResponse(category);
    }

    protected Category getCategoryByUuidProtected(String uuid){
        return categoryRepository.findByUuid(uuid).orElseThrow(()-> new CategoryNotFoundException("Category not found!"));
    }
}

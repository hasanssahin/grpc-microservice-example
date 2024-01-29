package com.hasansahin.discountservice.service;

import com.hasansahin.discountservice.exception.CategoryNotFoundException;
import com.hasansahin.discountservice.model.Category;
import com.hasansahin.discountservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public Category getCategoryByUuid(String uuid){
        return categoryRepository.findByExternalCategoryUuid(uuid).orElseThrow(()->new CategoryNotFoundException("Category not found!"));
    }
}

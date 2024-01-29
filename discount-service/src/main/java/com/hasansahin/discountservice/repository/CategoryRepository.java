package com.hasansahin.discountservice.repository;

import com.hasansahin.discountservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByExternalCategoryUuid(String uuid);
}

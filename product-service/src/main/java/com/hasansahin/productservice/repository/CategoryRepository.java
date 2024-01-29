package com.hasansahin.productservice.repository;

import com.hasansahin.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByUuid(String uuid);
}

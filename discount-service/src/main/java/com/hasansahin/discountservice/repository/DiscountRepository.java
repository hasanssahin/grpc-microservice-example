package com.hasansahin.discountservice.repository;

import com.hasansahin.discountservice.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscountRepository extends JpaRepository<Discount,Long> {
    Optional<Discount> findByCodeAndCategoryExternalCategoryUuid(String code,String categoryUuid);
}

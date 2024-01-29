package com.hasansahin.productservice.dto.request;

public record ApplyDiscountRequest(String code,
        Float price,
        String categoryUuid) {
}

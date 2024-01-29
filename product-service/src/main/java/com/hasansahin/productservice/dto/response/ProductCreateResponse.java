package com.hasansahin.productservice.dto.response;


public record ProductCreateResponse(
        String name,
        String description,
        Integer quantity,
        Float price,
        String categoryName,
        String productUuid) {
}

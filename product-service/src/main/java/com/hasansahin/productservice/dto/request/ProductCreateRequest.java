package com.hasansahin.productservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductCreateRequest(
        @NotBlank(message = "Product name cannot be blank!")
        String name,
        String description,
        @PositiveOrZero(message = "Product quantity cannot be minus!")
        Integer quantity,
        @Positive(message = "Product price cannot be minus!")
        Float price,
        @NotBlank(message = "Category cannot be blank!")
        String categoryUuid) {
}

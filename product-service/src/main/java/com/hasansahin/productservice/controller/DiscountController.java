package com.hasansahin.productservice.controller;

import com.hasansahin.grpc.DiscountRequest;
import com.hasansahin.grpc.DiscountResponse;
import com.hasansahin.productservice.dto.request.ApplyDiscountRequest;
import com.hasansahin.productservice.dto.response.AppliedDiscountResponse;
import com.hasansahin.productservice.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/discounts")
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountService discountService;

    @PostMapping
    public ResponseEntity<AppliedDiscountResponse> applyDiscount(@RequestBody ApplyDiscountRequest discountRequest){
        DiscountResponse discountResponse=discountService.applyDiscount(discountRequest);
        AppliedDiscountResponse appliedDiscountResponse=new AppliedDiscountResponse(discountResponse.getCode(),
                discountResponse.getNewPrice(),
                discountResponse.getOldPrice(),
                discountResponse.getAppliedDiscount(),
                discountResponse.getResult(),
                discountResponse.getMessage());
        return ResponseEntity.ok(appliedDiscountResponse);
    }
}

package com.hasansahin.productservice.service;

import com.hasansahin.grpc.DiscountRequest;
import com.hasansahin.grpc.DiscountResponse;
import com.hasansahin.productservice.dto.request.ApplyDiscountRequest;
import com.hasansahin.productservice.service.grpc.DiscountGrpcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountGrpcService discountGrpcService;
    private final ProductService productService;

    public DiscountResponse applyDiscount(ApplyDiscountRequest discountRequest){
        DiscountRequest discountRequest1=DiscountRequest.newBuilder().setCode(discountRequest.code()).setPrice(discountRequest.price()).setCategoryUuid(discountRequest.categoryUuid()).build();
        return discountGrpcService.applyDiscount(discountRequest1);
    }
}

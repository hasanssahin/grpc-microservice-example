package com.hasansahin.discountservice.service;

import com.hasansahin.discountservice.model.Category;
import com.hasansahin.discountservice.model.Discount;
import com.hasansahin.discountservice.repository.DiscountRepository;
import com.hasansahin.grpc.DiscountRequest;
import com.hasansahin.grpc.DiscountResponse;
import com.hasansahin.grpc.DiscountServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class DiscountGrpcServiceImpl extends DiscountServiceGrpc.DiscountServiceImplBase {
    private final CategoryService categoryService;
    private final DiscountRepository discountRepository;
    @Override
    public void applyDiscount(DiscountRequest request, StreamObserver<DiscountResponse> responseObserver) {
        Category category = categoryService.getCategoryByUuid(request.getCategoryUuid());
        Discount discount = discountRepository.findByCodeAndCategoryExternalCategoryUuid(request.getCode(), category.getExternalCategoryUuid()).orElse(null);
        if(discount!=null){
            float newPrice = request.getPrice() - discount.getDiscountPrice();
            responseObserver.onNext(DiscountResponse.newBuilder()
                    .setCode(request.getCode())
                    .setNewPrice(newPrice)
                    .setOldPrice(request.getPrice())
                    .setAppliedDiscount(discount.getDiscountPrice())
                    .setResult(true)
                    .setMessage("Discount applied successfully.")
                    .build());
        }else{
            responseObserver.onNext(DiscountResponse.newBuilder()
                    .setCode(request.getCode())
                    .setNewPrice(request.getPrice())
                    .setOldPrice(request.getPrice())
                    .setAppliedDiscount(0)
                    .setResult(false)
                    .setMessage("Discount failed!")
                    .build());
        }


        responseObserver.onCompleted();
    }
}

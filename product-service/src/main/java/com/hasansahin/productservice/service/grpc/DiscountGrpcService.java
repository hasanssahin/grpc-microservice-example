package com.hasansahin.productservice.service.grpc;

import com.hasansahin.grpc.DiscountRequest;
import com.hasansahin.grpc.DiscountResponse;
import com.hasansahin.grpc.DiscountServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DiscountGrpcService {
    private final ManagedChannel channel;

    public DiscountGrpcService(@Value("${discount.server.host}") String grpcHost, @Value("${discount.server.port}") int grpcPort) {
        channel= ManagedChannelBuilder.forAddress(grpcHost, grpcPort).usePlaintext().build();
    }
    public DiscountResponse applyDiscount(DiscountRequest discountRequest){
        DiscountServiceGrpc.DiscountServiceBlockingStub discountServiceBlockingStub=DiscountServiceGrpc.newBlockingStub(channel);
        return discountServiceBlockingStub.applyDiscount(discountRequest);
    }
}

package com.hasansahin.discountservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String externalCategoryUuid;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Discount> discounts=new ArrayList<>();
}

package com.test.nexu.TestNexu.structure.brand.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class BrandModel {
    private Long id;
    private String name;
    private Double average_price;
}
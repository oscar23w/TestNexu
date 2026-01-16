package com.test.nexu.TestNexu.structure.model.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ModelModel {
    private Long id;
    private String name;
    private Double average_price;
    private Long brandId;
}
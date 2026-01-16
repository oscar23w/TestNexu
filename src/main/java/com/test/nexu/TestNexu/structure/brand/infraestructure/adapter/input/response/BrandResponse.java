package com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.input.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record BrandResponse(
        Long id,

        @JsonProperty("name")
        String name,

        @JsonProperty("average_price")
        Double averagePrice

) implements Serializable {
}

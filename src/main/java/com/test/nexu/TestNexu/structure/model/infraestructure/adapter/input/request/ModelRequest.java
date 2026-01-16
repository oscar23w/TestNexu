package com.test.nexu.TestNexu.structure.model.infraestructure.adapter.input.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ModelRequest(
        @JsonProperty("name")
        @NotBlank(message = "El nombre es obligatorio")
        @NotNull
        @NotEmpty
        String name,

        @JsonProperty("average_price")
        Double average_price

) {}
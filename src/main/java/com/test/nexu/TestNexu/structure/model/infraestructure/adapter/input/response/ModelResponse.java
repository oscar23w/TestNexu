package com.test.nexu.TestNexu.structure.model.infraestructure.adapter.input.response;

import java.io.Serializable;

public record ModelResponse(
        Long id,
        String name,
        Double average_price
) implements Serializable {
}

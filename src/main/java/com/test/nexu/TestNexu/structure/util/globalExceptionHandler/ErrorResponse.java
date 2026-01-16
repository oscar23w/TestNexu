package com.test.nexu.TestNexu.structure.util.globalExceptionHandler;

import java.io.Serializable;

public record ErrorResponse(
        String code,
        String message
) implements Serializable {
}

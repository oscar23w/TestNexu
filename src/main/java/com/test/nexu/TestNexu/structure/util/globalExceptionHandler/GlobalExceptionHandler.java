package com.test.nexu.TestNexu.structure.util.globalExceptionHandler;

import com.test.nexu.TestNexu.structure.brand.domain.exception.BrandAlreadyExistsException;
import com.test.nexu.TestNexu.structure.model.domain.exception.BrandNotFoundException;
import com.test.nexu.TestNexu.structure.model.domain.exception.InvalidPriceException;
import com.test.nexu.TestNexu.structure.model.domain.exception.ModelAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BrandAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleBrandExists(BrandAlreadyExistsException ex) {
        ErrorResponse error = new ErrorResponse(
                "BRAND_DUPLICATED",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBrandNotFound(BrandNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                "BRAND_NOT_FOUND",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPrice(InvalidPriceException ex) {
        ErrorResponse error = new ErrorResponse(
                "INVALID_PRICE",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ModelAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleModelAlreadyExists(ModelAlreadyExistsException ex) {
        ErrorResponse error = new ErrorResponse(
                "MODEL_ALREADY_EXISTS",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}

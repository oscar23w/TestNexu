package com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.input.controller;

import com.test.nexu.TestNexu.structure.brand.application.port.input.ManagingBrand;
import com.test.nexu.TestNexu.structure.brand.domain.model.BrandModel;
import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.input.request.BrandRequest;
import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.input.response.BrandResponse;
import com.test.nexu.TestNexu.structure.model.application.port.input.ManagingModel;
import com.test.nexu.TestNexu.structure.model.domain.model.ModelModel;
import com.test.nexu.TestNexu.structure.model.infraestructure.adapter.input.request.ModelRequest;
import com.test.nexu.TestNexu.structure.model.infraestructure.adapter.input.response.ModelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {
    private final ManagingBrand managingBrand;
    private final ManagingModel managingModel;

    @GetMapping
    public ResponseEntity<List<BrandResponse>> getBrands() {
        List<BrandModel> brands = managingBrand.findAllBrands();

        List<BrandResponse> response = brands.stream()
                .map(brand -> new BrandResponse(
                        brand.getId(),
                        brand.getName(),
                        brand.getAverage_price()
                ))
                .toList();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<BrandResponse> createBrand(@RequestBody BrandRequest brandRequest) {
        BrandModel brandModel = new BrandModel(null, brandRequest.name(), 0.0);

        BrandModel createdBrand = managingBrand.createBrand(brandModel);

        BrandResponse response = new BrandResponse(
                createdBrand.getId(),
                createdBrand.getName(),
                0.0

        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/{brandId}/models")
    public ResponseEntity<ModelResponse> createModel(
            @PathVariable Long brandId,
            @RequestBody ModelRequest request) {

        ModelModel domainModel = new ModelModel(null, request.name(), request.average_price(), brandId);
        ModelModel created = managingModel.createModel(brandId, domainModel);
        ModelResponse response = new ModelResponse(
                created.getId(),
                created.getName(),
                created.getAverage_price()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{brandId}/models")
    public ResponseEntity<List<ModelResponse>> getModelsByBrand(@PathVariable Long brandId) {
        List<ModelModel> domainModels = managingModel.getModelsByBrand(brandId);
        List<ModelResponse> response = domainModels.stream()
                .map(model -> new ModelResponse(
                        model.getId(),
                        model.getName(),
                        model.getAverage_price()
                ))
                .toList();

        return ResponseEntity.ok(response);
    }
}

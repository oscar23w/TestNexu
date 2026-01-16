package com.test.nexu.TestNexu.structure.brand.domain.useCase;

import com.test.nexu.TestNexu.structure.brand.application.port.input.ManagingBrand;
import com.test.nexu.TestNexu.structure.brand.application.port.output.Brands;
import com.test.nexu.TestNexu.structure.brand.domain.exception.BrandAlreadyExistsException;
import com.test.nexu.TestNexu.structure.brand.domain.model.BrandModel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BrandUseCase implements ManagingBrand {
    private final Brands brands;

    @Override
    public List<BrandModel> findAllBrands() {
        return brands.findAllBrands();
    }

    @Override
    public BrandModel createBrand(BrandModel brand) {
        if (brands.existsByName(brand.getName())) {
            throw new BrandAlreadyExistsException("Esta marca ya está registrada");
        }

        return brands.createBrand(brand);
    }
}

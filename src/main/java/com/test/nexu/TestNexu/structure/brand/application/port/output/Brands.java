package com.test.nexu.TestNexu.structure.brand.application.port.output;

import com.test.nexu.TestNexu.structure.brand.domain.model.BrandModel;

import java.util.List;

public interface Brands {
    List<BrandModel> findAllBrands();

    BrandModel createBrand(BrandModel brand); // Para guardar

    boolean existsByName(String name);

    boolean existsById(Long id);
}

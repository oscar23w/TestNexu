package com.test.nexu.TestNexu.structure.brand.application.port.input;

import com.test.nexu.TestNexu.structure.brand.domain.model.BrandModel;

import java.util.List;

public interface ManagingBrand {
    public List<BrandModel> findAllBrands();

    public BrandModel createBrand(BrandModel brand);
}

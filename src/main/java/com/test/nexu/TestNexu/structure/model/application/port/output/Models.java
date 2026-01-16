package com.test.nexu.TestNexu.structure.model.application.port.output;

import com.test.nexu.TestNexu.structure.model.domain.model.ModelModel;

import java.util.List;

public interface Models {
    ModelModel createModel(ModelModel model, Long brandId);

    boolean existsByNameInBrand(String name, Long brandId);

    List<ModelModel> findAllByBrandId(Long brandId);
}

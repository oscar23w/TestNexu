package com.test.nexu.TestNexu.structure.model.application.port.input;

import com.test.nexu.TestNexu.structure.model.domain.model.ModelModel;

import java.util.List;

public interface ManagingModel {
    public ModelModel createModel(Long brandId, ModelModel model);

    List<ModelModel> getModelsByBrand(Long brandId);
}

package com.test.nexu.TestNexu.structure.model.domain.useCase;

import com.test.nexu.TestNexu.structure.brand.application.port.output.Brands;
import com.test.nexu.TestNexu.structure.model.application.port.input.ManagingModel;
import com.test.nexu.TestNexu.structure.model.application.port.output.Models;
import com.test.nexu.TestNexu.structure.model.domain.exception.BrandNotFoundException;
import com.test.nexu.TestNexu.structure.model.domain.exception.InvalidPriceException;
import com.test.nexu.TestNexu.structure.model.domain.exception.ModelAlreadyExistsException;
import com.test.nexu.TestNexu.structure.model.domain.model.ModelModel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ModelUseCase implements ManagingModel {
    private final Models models;
    private final Brands brands;

    @Override
    public ModelModel createModel(Long brandId, ModelModel model) {
        if (model.getAverage_price() != null && model.getAverage_price() < 100000) {
            throw new InvalidPriceException("El precio promedio debe ser mayor a 100,000");
        }

        if (models.existsByNameInBrand(model.getName(), brandId)) {
            throw new ModelAlreadyExistsException("El nombre del modelo ya existe en esta marca");
        }

        return models.createModel(model, brandId);
    }

    @Override
    public List<ModelModel> getModelsByBrand(Long brandId) {
        if (!brands.existsById(brandId)) { // Necesitarías agregar existsById en Brands port
            throw new BrandNotFoundException("La marca con ID " + brandId + " no existe");
        }

        // Si la marca existe, buscamos sus modelos
        return models.findAllByBrandId(brandId);
    }

}

package com.test.nexu.TestNexu.structure.model.infraestructure.adapter;

import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.entity.Brand;
import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.repository.BrandRepository;
import com.test.nexu.TestNexu.structure.model.application.port.output.Models;
import com.test.nexu.TestNexu.structure.model.domain.exception.BrandNotFoundException;
import com.test.nexu.TestNexu.structure.model.domain.model.ModelModel;
import com.test.nexu.TestNexu.structure.model.infraestructure.adapter.output.entity.Model;
import com.test.nexu.TestNexu.structure.model.infraestructure.adapter.output.repository.ModelRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ModelAdapter implements Models {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    @Override
    public ModelModel createModel(ModelModel modelDomain, Long brandId) {
        Brand brandEntity = brandRepository.findById(brandId)
                .orElseThrow(() -> new BrandNotFoundException("La marca con ID " + brandId + " no existe"));

        Model modelEntity = new Model();
        modelEntity.setName(modelDomain.getName());
        modelEntity.setAverage_price(modelDomain.getAverage_price());
        modelEntity.setBrandId(brandEntity);
        Model savedEntity = modelRepository.save(modelEntity);

        return new ModelModel(savedEntity.getId(), savedEntity.getName(), savedEntity.getAverage_price(), savedEntity.getBrandId().getId());
    }

    @Override
    public boolean existsByNameInBrand(String name, Long brandId) {
        Brand brand = new Brand();
        brand.setId(brandId);
        return modelRepository.existsByNameAndBrandId(name, brand);
    }

    @Override
    public List<ModelModel> findAllByBrandId(Long brandId) {
        return modelRepository.findByBrandId_Id(brandId)
                .stream()
                .map(entity -> new ModelModel(
                        entity.getId(),
                        entity.getName(),
                        entity.getAverage_price(),
                        entity.getBrandId().getId()
                ))
                .toList();
    }

}

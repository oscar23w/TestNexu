package com.test.nexu.TestNexu.structure.brand.infraestructure.adapter;

import com.test.nexu.TestNexu.structure.brand.application.port.output.Brands;
import com.test.nexu.TestNexu.structure.brand.domain.model.BrandModel;
import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.entity.Brand;
import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.repository.BrandRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BrandAdapter implements Brands {
    private final BrandRepository brandRepository;

    @Override
    public List<BrandModel> findAllBrands() {
        List<Object[]> results = brandRepository.findAllBrandsWithAveragePrice();

        return results.stream()
                .map(row -> new BrandModel(
                        (Long) row[0],
                        (String) row[1],
                        (Double) row[2]
                ))
                .toList();
    }

    @Override
    public BrandModel createBrand(BrandModel brand) {
        Brand entityBrand = new Brand();
        entityBrand.setName(brand.getName());

        Brand savedEntity = brandRepository.save(entityBrand);
        return new BrandModel(savedEntity.getId(), savedEntity.getName(), 0.0);
    }

    @Override
    public boolean existsByName(String name) {
        return brandRepository.existsByName(name);
    }

    @Override
    public boolean existsById (Long id) {
        return brandRepository.existsById(id);
    }
}

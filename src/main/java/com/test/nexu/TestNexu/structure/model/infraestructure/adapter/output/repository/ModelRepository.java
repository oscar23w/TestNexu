package com.test.nexu.TestNexu.structure.model.infraestructure.adapter.output.repository;

import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.entity.Brand;
import com.test.nexu.TestNexu.structure.model.infraestructure.adapter.output.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository <Model, Long> {
    boolean existsByNameAndBrandId(String name, Brand brand);

    List<Model> findByBrandId_Id(Long id);
}

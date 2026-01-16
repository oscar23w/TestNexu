package com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.repository;

import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository <Brand, Long> {
    boolean existsByName(String name);

    @Query("SELECT b.id, b.name, COALESCE(AVG(m.average_price), 0) " +
            "FROM Model m " +
            "RIGHT JOIN m.brandId b " +
            "GROUP BY b.id, b.name")
    List<Object[]> findAllBrandsWithAveragePrice();

    Optional<Brand> findByName(String name);
}

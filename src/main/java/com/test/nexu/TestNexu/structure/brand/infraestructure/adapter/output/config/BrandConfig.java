package com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.config;

import com.test.nexu.TestNexu.structure.brand.domain.useCase.BrandUseCase;
import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.BrandAdapter;
import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.repository.BrandRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrandConfig {
    @Bean
    public BrandUseCase brandUseCase(BrandAdapter brandAdapter) {
        return new BrandUseCase(brandAdapter);
    }

    @Bean
    public BrandAdapter brandAdapter(BrandRepository brandRepository) {
        return new BrandAdapter(brandRepository);
    }
}

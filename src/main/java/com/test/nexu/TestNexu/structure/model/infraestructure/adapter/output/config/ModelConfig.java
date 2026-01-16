package com.test.nexu.TestNexu.structure.model.infraestructure.adapter.output.config;

import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.BrandAdapter;
import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.repository.BrandRepository;
import com.test.nexu.TestNexu.structure.model.domain.useCase.ModelUseCase;
import com.test.nexu.TestNexu.structure.model.infraestructure.adapter.ModelAdapter;
import com.test.nexu.TestNexu.structure.model.infraestructure.adapter.output.repository.ModelRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {
    @Bean
    public ModelUseCase modelUseCase(ModelAdapter modelAdapter, BrandAdapter brandAdapter) {
        return new ModelUseCase(modelAdapter, brandAdapter);
    }

    @Bean
    public ModelAdapter modelAdapter(ModelRepository modelRepository, BrandRepository brandRepository) {
        return new ModelAdapter(modelRepository, brandRepository);
    }
}

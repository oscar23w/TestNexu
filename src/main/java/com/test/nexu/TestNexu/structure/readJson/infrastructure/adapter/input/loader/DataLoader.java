package com.test.nexu.TestNexu.structure.readJson.infrastructure.adapter.input.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.entity.Brand;
import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.repository.BrandRepository;
import com.test.nexu.TestNexu.structure.model.infraestructure.adapter.output.repository.ModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataLoader implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Map<String, Brand> brandCache = new HashMap<>();

    public DataLoader(BrandRepository brandRepository,
                      ModelRepository modelRepository,
                      JdbcTemplate jdbcTemplate) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        if (modelRepository.count() == 0) {
            System.out.println("Iniciando carga de modelos con IDs fijos...");
            loadModelsFromJson();
            resetAutoIncrement();
            System.out.println("Carga completada exitosamente.");
        }
    }

    private void loadModelsFromJson() {
        try {
            InputStream inputStream = new ClassPathResource("models.json").getInputStream();
            List<JsonCarEntry> entries = objectMapper.readValue(inputStream, new TypeReference<>() {});

            String sql = "INSERT INTO model (id, name, average_price, brand_id) VALUES (?, ?, ?, ?)";

            for (JsonCarEntry entry : entries) {
                Brand brand = getOrCreateBrand(entry.brandName());

                jdbcTemplate.update(sql,
                        entry.id(),
                        entry.name(),
                        entry.averagePrice(),
                        brand.getId()
                );
            }

        } catch (Exception e) {
            System.err.println("Error crítico cargando JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void resetAutoIncrement() {
        try {
            Long maxId = jdbcTemplate.queryForObject("SELECT MAX(id) FROM model", Long.class);
            if (maxId != null) {
                long nextId = maxId + 1;
                jdbcTemplate.execute("ALTER TABLE model ALTER COLUMN id RESTART WITH " + nextId);
            }
        } catch (Exception e) {
            System.err.println("No se pudo ajustar la secuencia: " + e.getMessage());
        }
    }

    private Brand getOrCreateBrand(String brandName) {
        if (brandCache.containsKey(brandName)) {
            return brandCache.get(brandName);
        }

        return brandRepository.findByName(brandName)
                .map(existingBrand -> {
                    brandCache.put(brandName, existingBrand);
                    return existingBrand;
                })
                .orElseGet(() -> {
                    Brand newBrand = new Brand();
                    newBrand.setName(brandName);
                    Brand savedBrand = brandRepository.save(newBrand);
                    brandCache.put(brandName, savedBrand);
                    return savedBrand;
                });
    }

    @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
    record JsonCarEntry(
            Long id,
            String name,
            @JsonProperty("average_price") Double averagePrice,
            @JsonProperty("brand_name") String brandName
    ) {}
}
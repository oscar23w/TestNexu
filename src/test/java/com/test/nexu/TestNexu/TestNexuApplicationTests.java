package com.test.nexu.TestNexu;

import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.entity.Brand;
import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.repository.BrandRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestNexuApplicationTests {
// PRUEBA 1: Test de Integración
	@Autowired
	private BrandRepository brandRepository;

	@Test
	void contextLoads() {
		assertNotNull(brandRepository, "El repositorio debería haberse inyectado correctamente");
	}
}

// PRUEBA 2: Test Unitario de Base de Datos
@DataJpaTest
class BrandRepositoryTest {
	@Autowired
	private BrandRepository brandRepository;

	@Test
	void testSaveAndFindBrand() {
		Brand marcaTest = new Brand();
		marcaTest.setName("Tesla Test");

		Brand savedBrand = brandRepository.save(marcaTest);

		assertNotNull(savedBrand.getId());

		Optional<Brand> foundBrand = brandRepository.findByName("Tesla Test");

		assertTrue(foundBrand.isPresent(), "La marca debería haberse encontrado");
		assertEquals("Tesla Test", foundBrand.get().getName());
	}
}



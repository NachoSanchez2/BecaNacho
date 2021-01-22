package edu.beca.es.eoi.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.service.PasService;
import edu.beca.es.eoi.serviceImpl.PasServiceImpl;

class PasServiceImplTest {

	@Test
	void testSavePas() {
		// PreparedTest
		PasService service = new PasServiceImpl();

		// Assert
		assertTrue(service.savePas(6, "test", "test1234", "test", "test@gmail.com", "test", "test", 3, "CONDUCTOR", 6));
	}

	@Test
	void testUploadByUsername() {
		// PreparedTest
		PasService service = new PasServiceImpl();
		Person uploadedPerson = service.uploadByUsername(6, "tortilla", "lucas", "de", "patata", "lucas", "concebolla",
				3, "CONDUCTOR");

		// Assert
		assertNotNull(uploadedPerson);
	}

	@Test
	void testUploadByDNI() {
		// PreparedTest
		PasService service = new PasServiceImpl();
		Person uploadedPerson = service.uploadByDNI(6, "newTest", "lucas", "newTest", "newTest", "lucas", "newTest", 6,
				"SOI001");

		// Assert
		assertNotNull(uploadedPerson);
	}

}

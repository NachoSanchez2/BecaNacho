package edu.beca.es.eoi.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.service.ProfessorService;
import edu.beca.es.eoi.serviceImpl.ProfessorServiceImpl;

class ProfessorServiceImplTest {

	@Test
	void testSaveProfessor() {
		// PreparedTest
		ProfessorService service = new ProfessorServiceImpl();

		// Assert
		assertTrue(
				service.saveProfessor(83, "hastu", "pata", "pota", "pija@gmail.com", "astu", "pata", 2, "JLAJSH", 83));
	}

	@Test
	void testUploadByUsername() {
		// PreparedTest
		ProfessorService service = new ProfessorServiceImpl();
		Person uploadedPerson = service.uploadByUsername(3, "tortilla", "pablo", "de", "patata", "pablo", "concebolla",
				2, "SOI001");

		// Assert
		assertNotNull(uploadedPerson);
	}

	@Test
	void testUploadByDNI() {
		// PreparedTest
		ProfessorService service = new ProfessorServiceImpl();
		Person uploadedPerson = service.uploadByDNI(3, "newTest", "pablo", "newTest", "newTest", "pablo", "newTest", 2,
				"SOI001");

		// Assert
		assertNotNull(uploadedPerson);
	}

}

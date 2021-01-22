package edu.beca.es.eoi.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.service.StudentService;
import edu.beca.es.eoi.serviceImpl.StudentServiceImpl;

class StudentServiceImplTest {

	@Test
	void testSaveStudent() {
		// PreparedTest
		StudentService service = new StudentServiceImpl();

		// Assert
		assertTrue(
				service.saveStudent(82, "test", "test1234", "test", "test@gmail.com", "test", "test", 1, "Diseño", 82));
	}

	@Test
	void testUploadByUsername() {

		// PreparedTest
		StudentService service = new StudentServiceImpl();
		Person uploadedPerson = service.uploadByUsername(1, "newTest", "pepe", "newTest", "newTest", "pepe", "newTest", 1, "BELLAS ARTES");
		
		// Assert
		assertNotNull(uploadedPerson);
	}

	@Test
	void testUploadByDNI() {

		// PreparedTest
		StudentService service = new StudentServiceImpl();
		Person uploadedPerson = service.uploadByDNI(4, "newTest", "paco", "newTest", "newTest", "paco", "newTest", 1, "BELLAS ARTES");
		
		// Assert
		assertNotNull(uploadedPerson);
	}

}

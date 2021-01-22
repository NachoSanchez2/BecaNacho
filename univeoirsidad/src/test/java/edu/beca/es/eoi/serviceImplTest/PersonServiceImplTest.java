package edu.beca.es.eoi.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.service.PersonService;
import edu.beca.es.eoi.serviceImpl.PersonServiceImpl;

class PersonServiceImplTest {

	@Test
	void testSave() {
		// PreparedTest
		PersonService service = new PersonServiceImpl();

		// Assert
		assertTrue(service.save("test", "test12345", "test", "test@gmail.com", "test", "test", 1));
		assertTrue(service.save("test", "test12345", "test", "test@gmail.com", "test", "test", 2));
		assertTrue(service.save("test", "test12345", "test", "test@gmail.com", "test", "test", 3));
	}

	@Test
	void testRead() {
		// PreparedTest
		PersonService service = new PersonServiceImpl();
		Person person1 = service.read("pepe", null);
		Person person2 = service.read(null, "maria");

		// Assert
		assertNotNull(person1);
		assertNotNull(person2);
	}

	@Test
	void testReadByUsername() {
		// PreparedTest
		PersonService service = new PersonServiceImpl();
		Person student = service.readByUsername(1, "pepe");
		Person professor = service.readByUsername(2, "maria");
		Person pas = service.readByUsername(3, "esteban");

		// Assert
		assertNotNull(student);
		assertNotNull(professor);
		assertNotNull(pas);
	}

	@Test
	void testReadByDNI() {
		// PreparedTest
		PersonService service = new PersonServiceImpl();
		Person student = service.readByDNI(1, "pepe");
		Person professor = service.readByDNI(2, "maria");
		Person pas = service.readByDNI(3, "esteban");

		// Assert
		assertNotNull(student);
		assertNotNull(professor);
		assertNotNull(pas);
	}

	@Test
	void testDeleteByUsername() {
		// PreparedTest
		PersonService service = new PersonServiceImpl();
		boolean deleteOK = service.deleteByUsername("test");

		// Assert
		assertTrue(deleteOK);
	}

	@Test
	void testDeleteByDNI() {
		// PreparedTest
		PersonService service = new PersonServiceImpl();
		boolean deleteOK = service.deleteByUsername("test");

		// Assert
		assertTrue(deleteOK);
	}

}

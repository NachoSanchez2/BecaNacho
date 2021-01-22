package edu.beca.es.eoi.repositoryImplTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Pas;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.Professor;
import edu.beca.es.eoi.entity.Student;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJSONImpl;

class PersonRepositoryJSONImplTest {

	@Test
	void testSave() {
		// PreparedTest
		Person student = new Student(0, "test", "test1", "test", "test@gmail.com", "pepe", "test", 1, "INGENIERÍA", 0);
		Person professor = new Professor(0, "test", "test2", "test", "test@gmail.com", "paco", "test", 2, "MAS001", 0);
		Person pas = new Pas(0, "test", "test3", "test", "test@gmail.com", "pablo", "test", 3, "CONSERJE", 0);

		PersonRepositoryJSONImpl repository = new PersonRepositoryJSONImpl();

		// AssertsavePerson
		assertTrue(repository.savePerson(student));
		assertTrue(repository.savePerson(professor));
		assertTrue(repository.savePerson(pas));
	}

	@Test
	void readAllTest() {

		// PreparedTest
		PersonRepositoryJSONImpl repository = new PersonRepositoryJSONImpl();
		List<Person> persons = repository.readAll();

		// Asserts
		assertNotNull(persons.get(0));
	}

	@Test
	void readByUsernameTest() {

		// PreparedTest
		String username = "paco";
		PersonRepositoryJSONImpl repository = new PersonRepositoryJSONImpl();
		Person person = repository.readByUsername(username);

		// Assert
		assertNotNull(person);
	}

	@Test
	void readByDniTest() {
		// PreparedTest
		String dni = "test1";
		PersonRepositoryJSONImpl repository = new PersonRepositoryJSONImpl();
		Person person = repository.readByDNI(dni);

		// Assert
		assertNotNull(person);
	}

	@Test
	void uploadByUsernameTest() {
		// PreparedTest
		String studentUsername = "pepe";
		String professorUsername = "paco";
		String pasUsername = "pablo";

		PersonRepositoryJSONImpl repository = new PersonRepositoryJSONImpl();
		Person newStudent = new Student(0, "Hola", null, "esto", "es una", null, "prueba", 1, "DISEÑO", 0);
		Person newProfessor = new Professor(0, "Adiós", null, "esto", "es otra", null, "prueba", 2, "HGAL113", 0);
		Person newPas = new Pas(0, "Ahora", null, "si", "que es una", null, "prueba", 3, "MAYORISTA", 0);

		// Assert
		assertTrue(repository.uploadByUsername(newStudent, studentUsername));
		assertTrue(repository.uploadByUsername(newProfessor, professorUsername));
		assertTrue(repository.uploadByUsername(newPas, pasUsername));
	}

}
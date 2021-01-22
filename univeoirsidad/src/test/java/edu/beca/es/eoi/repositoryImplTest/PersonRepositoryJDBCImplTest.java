package edu.beca.es.eoi.repositoryImplTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Pas;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.Professor;
import edu.beca.es.eoi.entity.Student;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;

class PersonRepositoryJDBCImplTest {

	@Test
	void testSave() {
		// PreparedTest
		Person student = new Student("test", "test12345", "test", "test@gmail.com", "test", "test", 1);
		Person professor = new Professor("test", "test12345", "test", "test@gmail.com", "test", "test", 2);
		Person pas = new Pas("test", "test12345", "test", "test@gmail.com", "test", "test", 3);

		PersonRepository repository = new PersonRepositoryJDBCImpl();

		// Assert
		assertTrue(repository.save(student));
		assertTrue(repository.save(professor));
		assertTrue(repository.save(pas));
	}

	@Test
	void saveStudent() {
		// PreparedTest
		Person test = new Student(55, "test", "test12345", "test", "test@gmail.com", "test", "test", 1, "Diseño", 52);
		PersonRepository repository = new PersonRepositoryJDBCImpl();

		// Assert
		assertTrue(repository.saveStudent(((Student) test).getIdUser(), test));

	}

	@Test
	void saveProfessor() {
		// PreparedTest
		Person test = new Professor(56, "test", "test12345", "test", "test@gmail.com", "test", "test", 2, "AWLS123",
				17);
		PersonRepository repository = new PersonRepositoryJDBCImpl();

		// Assert
		assertTrue(repository.saveProfessor(((Professor) test).getIdUser(), test));
	}

	@Test
	void savePas() {
		// PreparedTest
		Person test = new Pas(57, "test", "test12345", "test", "test@gmail.com", "test", "test", 3, "CONSERJE", 51);
		PersonRepository repository = new PersonRepositoryJDBCImpl();

		// Assert
		assertTrue(repository.savePas(((Pas) test).getIdUser(), test));
	}

	@Test
	void testRead() {
		PersonRepository repository = new PersonRepositoryJDBCImpl();
		Person person1 = repository.read("pepe",null);
		Person person2 = repository.read(null, "maria");
		
		assertNotNull(person1);
		assertNotNull(person2);
		
	}

	@Test
	void testReadByUsername() {
		// PreparedTest
		Person student = new Student(1, "astu", "pepe", "pata", "pota", "pepe", "hija", 1, "Diseño", 1);
		Person professor = new Professor(2, "tortilla", "maria", "de", "patata", "maria", "sincebolla", 2, "LIJ120", 7);
		Person pas = new Pas(5, "ahora", "esteban", "esto", "si", "esteban", "funciona", 3, "CONSERJE", 5);
		PersonRepository repository = new PersonRepositoryJDBCImpl();

		// Implementation
		Person studentAUX = repository.readByUsername(1, student.getUsername());
		Person professorAUX = repository.readByUsername(2, professor.getUsername());
		Person pasAUX = repository.readByUsername(3, pas.getUsername());

		// Assert
		assertNotNull(studentAUX);
		assertNotNull(professorAUX);
		assertNotNull(pasAUX);
	}

	@Test
	void testReadByDNI() {
		// PreparedTest
		Person student = new Student(9, "test", "test12345", "test", "test@gmail.com", "test", "test", 1, "Diseño", 9);
		Person professor = new Professor(2, "maria", "maria", "maria", "maria", "maria", "maria", 2, "LIJ120", 2);
		Person pas = new Pas(5, "esteban", "esteban", "esteban", "esteban", "esteban", "esteban", 5);
		PersonRepository repository = new PersonRepositoryJDBCImpl();

		// Assert
		assertNotNull(repository.readByDNI(1, student.getDni()));
		assertNotNull(repository.readByDNI(2, professor.getDni()));
		assertNotNull(repository.readByDNI(3, pas.getDni()));
	}

	@Test
	void testDeleteByUsername() {
		// PreparedTest
		PersonRepository repository = new PersonRepositoryJDBCImpl();
		assertTrue(repository.deleteByUsername("test"));
	}

	@Test
	void testDeleteByDNI() {
		// PreparedTest
		PersonRepository repository = new PersonRepositoryJDBCImpl();
		assertTrue(repository.deleteByUsername("ocho"));
	}

	// TODO: Mejorar la parte de las entidades, no tanto constructor

	@Test
	void testUploadByUsername() {

		// PreparedTest
		PersonRepository repository = new PersonRepositoryJDBCImpl();
		// Students
		Person student = new Student(1, null, "pepe", null, null, "pepe", null, 1, null, 1);
		Person newStudent = new Student("astu", "pata", "pota", "hija", 1, "FILOSOFIA");

		// Professors
		Person professor = new Professor(2, null, "maria", null, null, "maria", null, 2, null, 2);
		Person newProfessor = new Professor("tortilla", "de", "patata", "sincebolla", 2, "BOLUDAZA");

		// Pas
		Person pas = new Pas(5, null, "esteban", null, null, "esteban", null, 3, null, 5);
		Person newPas = new Pas("ahora", "esto", "si", "funciona", 2, "TESTEST");

		// Implementation
		Person uploadedStudent = repository.uploadByUsername(1, newStudent, student.getUsername());
		Person uploadedProfessor = repository.uploadByUsername(2, newProfessor, professor.getUsername());
		Person uploadedPas = repository.uploadByUsername(3, newPas, pas.getUsername());

		// Asserts
		assertNotNull(uploadedStudent);
		assertNotNull(uploadedProfessor);
		assertNotNull(uploadedPas);

	}

	@Test
	void testUploadByDNI() {
		// PreparedTest
		PersonRepository repository = new PersonRepositoryJDBCImpl();
		// Students
		Person student = new Student(1, null, "pepe", null, null, "pepe", null, 1, null, 1);
		Person newStudent = new Student("astu", "pata", "pota", "hija", 1, "FILOSOFIA");

		// Professors
		Person professor = new Professor(2, null, "maria", null, null, "maria", null, 2, null, 2);
		Person newProfessor = new Professor("tortilla", "de", "patata", "sincebolla", 2, "BOLUDAZA");

		// Pas
		Person pas = new Pas(5, null, "esteban", null, null, "esteban", null, 3, null, 5);
		Person newPas = new Pas("ahora", "esto", "si", "funciona", 2, "TESTEST");

		// Implementation
		Person uploadedStudent = repository.uploadByDNI(1, newStudent, student.getDni());
		Person uploadedProfessor = repository.uploadByDNI(2, newProfessor, professor.getDni());
		Person uploadedPas = repository.uploadByDNI(3, newPas, pas.getDni());

		// Asserts
		assertNotNull(uploadedStudent);
		assertNotNull(uploadedProfessor);
		assertNotNull(uploadedPas);

	}

}

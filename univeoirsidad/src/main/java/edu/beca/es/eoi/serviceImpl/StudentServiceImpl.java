package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.Student;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;
import edu.beca.es.eoi.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private static final PersonRepository REPOSITORY = new PersonRepositoryJDBCImpl();

	@Override
	public boolean saveStudent(int id, String name, String dni, String surname, String mail, String username,
			String password, int tipoPersona, String faculty, int idUser) {

		Person student = new Student(id, name, dni, surname, mail, username, password, tipoPersona, faculty, idUser);
		return REPOSITORY.saveStudent(idUser, student);
	}

	@Override
	public Person uploadByUsername(int id, String newName, String dni, String newSurname, String newMail,
			String username, String newPassword, int tipoPersona, String newfaculty) {

		Person newStudent = new Student(newName, newSurname, newMail, newPassword, tipoPersona, newfaculty);
		return REPOSITORY.uploadByUsername(tipoPersona, newStudent, username);
	}

	@Override
	public Person uploadByDNI(int id, String newName, String dni, String newSurname, String newMail, String username,
			String newPassword, int tipoPersona, String newfaculty) {

		Person newStudent = new Student(newName, newSurname, newMail, newPassword, tipoPersona, newfaculty);
		return REPOSITORY.uploadByDNI(tipoPersona, newStudent, dni);
	}

}

package edu.beca.es.eoi.serviceImpl;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.Student;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;
import edu.beca.es.eoi.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private static final PersonRepository REPOSITORY = new PersonRepositoryJDBCImpl();
	private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);

	@Override
	public boolean saveStudent(int id, String name, String dni, String surname, String mail, String username,
			String password, int tipoPersona, String faculty, int idUser) {
		logger.info("Entro en el metodo saveStudent de la entidad Student de la implementacion de Servicio");
		Person student = new Student(id, name, dni, surname, mail, username, password, tipoPersona, faculty, idUser);
		return REPOSITORY.saveStudent(idUser, student);
	}

	@Override
	public Person uploadByUsername(int id, String newName, String dni, String newSurname, String newMail,
			String username, String newPassword, int tipoPersona, String newfaculty) {
		logger.info("Entro en el metodo uploadByUsername de la entidad Student de la implementacion de Servicio");
		Person newStudent = new Student(newName, newSurname, newMail, newPassword, tipoPersona, newfaculty);
		return REPOSITORY.uploadByUsername(tipoPersona, newStudent, username);
	}

	@Override
	public Person uploadByDNI(int id, String newName, String dni, String newSurname, String newMail, String username,
			String newPassword, int tipoPersona, String newfaculty) {
		logger.info("Entro en el metodo uploadByDni de la entidad Student de la implementacion de Servicio");
		Person newStudent = new Student(newName, newSurname, newMail, newPassword, tipoPersona, newfaculty);
		return REPOSITORY.uploadByDNI(tipoPersona, newStudent, dni);
	}

}

package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.Professor;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;
import edu.beca.es.eoi.service.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {
	private static final PersonRepository REPOSITORY = new PersonRepositoryJDBCImpl();

	@Override
	public boolean saveProfessor(int id, String name, String dni, String surname, String mail, String username,
			String password, int tipoPersona, String office, int idUser) {

		Person professor = new Professor(id, name, dni, surname, mail, username, password, tipoPersona, office, idUser);
		return REPOSITORY.saveProfessor(idUser, professor);
	}

	@Override
	public Person uploadByUsername(int id, String newName, String dni, String newSurname, String newMail,
			String username, String newPassword, int tipoPersona, String newOffice) {

		Person newProfessor = new Professor(newName, newSurname, newMail, newPassword, tipoPersona, newOffice);
		return REPOSITORY.uploadByUsername(tipoPersona, newProfessor, username);
	}

	@Override
	public Person uploadByDNI(int id, String newName, String dni, String newSurname, String newMail, String username,
			String newPassword, int tipoPersona, String newOffice) {

		Person newProfessor = new Professor(newName, newSurname, newMail, newPassword, tipoPersona, newOffice);
		return REPOSITORY.uploadByDNI(tipoPersona, newProfessor, dni);
	}

}

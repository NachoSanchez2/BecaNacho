package edu.beca.es.eoi.serviceImpl;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.Professor;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;
import edu.beca.es.eoi.service.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {
	private static final PersonRepository REPOSITORY = new PersonRepositoryJDBCImpl();
	private static final Logger logger = Logger.getLogger(ProfessorServiceImpl.class);

	@Override
	public boolean saveProfessor(int id, String name, String dni, String surname, String mail, String username,
			String password, int tipoPersona, String office, int idUser) {
		logger.info("Entro en el metodo saveProfessor de la entidad professor de la implementacion de Servicio");
		Person professor = new Professor(id, name, dni, surname, mail, username, password, tipoPersona, office, idUser);
		return REPOSITORY.saveProfessor(idUser, professor);
	}

	@Override
	public Person uploadByUsername(int id, String newName, String dni, String newSurname, String newMail,
			String username, String newPassword, int tipoPersona, String newOffice) {
		logger.info("Entro en el metodo uploadByUsername de la entidad professor de la implementacion de Servicio");
		Person newProfessor = new Professor(newName, newSurname, newMail, newPassword, tipoPersona, newOffice);
		return REPOSITORY.uploadByUsername(tipoPersona, newProfessor, username);
	}

	@Override
	public Person uploadByDNI(int id, String newName, String dni, String newSurname, String newMail, String username,
			String newPassword, int tipoPersona, String newOffice) {
		logger.info("Entro en el metodo uploadByDNI de la entidad professor de la implementacion de Servicio");
		Person newProfessor = new Professor(newName, newSurname, newMail, newPassword, tipoPersona, newOffice);
		return REPOSITORY.uploadByDNI(tipoPersona, newProfessor, dni);
	}

}

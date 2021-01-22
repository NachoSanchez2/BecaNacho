package edu.beca.es.eoi.serviceImpl;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.entity.Pas;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;
import edu.beca.es.eoi.service.PasService;

public class PasServiceImpl implements PasService {

	private static final Logger logger = Logger.getLogger(PasServiceImpl.class);
	private static final PersonRepository REPOSITORY = new PersonRepositoryJDBCImpl();

	@Override
	public boolean savePas(int id, String name, String dni, String surname, String mail, String username,
			String password, int tipoPersona, String unit, int idUser) {
		logger.info("Entra en el metodo savePas");
		Person pas = new Pas(id, name, dni, surname, mail, username, password, tipoPersona, unit, idUser);
		return REPOSITORY.savePas(idUser, pas);
	}

	@Override
	public Person uploadByUsername(int id, String newName, String dni, String newSurname, String newMail,
			String username, String newPassword, int tipoPersona, String newUnit) {
		logger.info("Entra en el metodo uploadByUsername de la entidad Pas");
		Person newPas = new Pas(newName, newSurname, newMail, newPassword, tipoPersona, newUnit);
		return REPOSITORY.uploadByUsername(tipoPersona, newPas, username);
	}

	@Override
	public Person uploadByDNI(int id, String newName, String dni, String newSurname, String newMail, String username,
			String newPassword, int tipoPersona, String newUnit) {
		logger.info("Entra en el metodo uploadByDNI de la entidad Pas");
		Person newPas = new Pas(newName, newSurname, newMail, newPassword, tipoPersona, newUnit);
		return REPOSITORY.uploadByDNI(tipoPersona, newPas, dni);
	}

}

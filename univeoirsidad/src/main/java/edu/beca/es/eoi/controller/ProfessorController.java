package edu.beca.es.eoi.controller;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.service.PersonService;
import edu.beca.es.eoi.service.ProfessorService;
import edu.beca.es.eoi.serviceImpl.PersonServiceImpl;
import edu.beca.es.eoi.serviceImpl.ProfessorServiceImpl;

public class ProfessorController {

	private static final ProfessorService PROFESSORSERVICE = new ProfessorServiceImpl();
	private static final PersonService PERSONSERVICE = new PersonServiceImpl();
	private static final Logger logger = Logger.getLogger(ProfessorController.class);

	public void saveProfessor(String name, String dni, String surname, String mail, String username, String password,
			int tipoPersona, String office) throws Exception {
		logger.info("Se entra en el metodo saveProfessor del controlador de profesores");

		boolean savePersonOK = PERSONSERVICE.save(name, dni, surname, mail, username, password, tipoPersona);
		int id = PERSONSERVICE.read(username, dni).getId();
		int idUser = id;
		if (savePersonOK) {
			logger.debug("Se guarda la persona " + name + "," + "," + dni + "," + surname + "," + mail + "," + username
					+ "," + password + "," + tipoPersona + "," + office);
			boolean saveOK = PROFESSORSERVICE.saveProfessor(id, name, dni, surname, mail, username, password,
					tipoPersona, office, idUser);
			if (!saveOK) {
				throw new Exception("No se ha podido guardar la facultad");
			}
		} else {
			throw new Exception("No se ha podido guardar al usuario");
		}
	}

	public Person uploadByUsername(String newName, String newSurname, String newMail, String username,
			String newPassword, String newOffice) throws Exception {
		logger.info("Se entra en el metodo uploadByUsername del controlador de profesores");
		logger.debug("Se busca a la persona con el usuario " + username);
		Person e = PERSONSERVICE.read(username, null);
		if (e != null) {
			logger.debug("Se guardan los nuevos datos " + newName + "," + "," + newSurname + "," + newMail + ","
					+ newPassword + "," + newOffice);
			PROFESSORSERVICE.uploadByUsername(e.getId(), newName, e.getDni(), newSurname, newMail, username,
					newPassword, e.getTipoPersona(), newOffice);
		} else {
			throw new Exception("No se ha podido encontrar el usuario que desea modificar");
		}
		return e;
	}

	public Person uploadByDni(String newName, String dni, String newSurname, String newMail, String newPassword,
			String newOffice) throws Exception {
		logger.info("Se entra en el metodo uploadByDni del controlador de profesores");
		logger.debug("Se busca a la persona con el dni " + dni);
		Person e = PERSONSERVICE.read(null, dni);
		if (e != null) {
			logger.debug("Se guardan los nuevos datos " + newName + "," + "," + newSurname + "," + newMail + ","
					+ newPassword + "," + newOffice);
			PROFESSORSERVICE.uploadByDNI(e.getId(), newName, dni, newSurname, newMail, e.getUsername(), newPassword,
					e.getTipoPersona(), newOffice);
		} else {
			throw new Exception("No se ha podido encontrar el usuario que desea modificar");
		}
		return e;
	}
}

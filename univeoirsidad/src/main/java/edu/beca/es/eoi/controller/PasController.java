package edu.beca.es.eoi.controller;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.service.PasService;
import edu.beca.es.eoi.service.PersonService;
import edu.beca.es.eoi.serviceImpl.PasServiceImpl;
import edu.beca.es.eoi.serviceImpl.PersonServiceImpl;

public class PasController {

	private static final PasService PASSERVICE = new PasServiceImpl();
	private static final PersonService PERSONSERVICE = new PersonServiceImpl();
	private static final Logger logger = Logger.getLogger(PasController.class);

	public void savePas(String name, String dni, String surname, String mail, String username, String password,
			int tipoPersona, String unit) throws Exception {
		logger.info("Se entra en el metodo savePas del controlador de la entidad Pas");

		boolean savePersonOK = PERSONSERVICE.save(name, dni, surname, mail, username, password, tipoPersona);
		int id = PERSONSERVICE.read(username, dni).getId();

		int idUser = id;
		if (savePersonOK) {
			logger.debug("Se guarda la persona " + name + "," + "," + dni + "," + surname + "," + mail + "," + username
					+ "," + password + "," + tipoPersona + "," + unit);
			boolean saveOK = PASSERVICE.savePas(id, name, dni, surname, mail, username, password, tipoPersona, unit,
					idUser);
			if (!saveOK) {
				throw new Exception("No se ha podido guardar la facultad");
			}
		} else {
			throw new Exception("No se ha podido guardar al usuario");
		}
	}

	public Person uploadByUsername(String newName, String newSurname, String newMail, String username,
			String newPassword, String newUnit) throws Exception {
		logger.info("Se entra en el metodo uploadByUsername del controlador de la entidad Pas");
		logger.debug("Se busca la persona con el usuario " + username);
		Person e = PERSONSERVICE.read(username, null);
		if (e != null) {
			logger.debug("Se le cambian los parametros " + newName + "," + newSurname + "," + newMail + ","
					+ newPassword + "," + newUnit);
			PASSERVICE.uploadByUsername(e.getId(), newName, e.getDni(), newSurname, newMail, username, newPassword,
					e.getTipoPersona(), newUnit);
		} else {
			throw new Exception("No se ha podido encontrar el usuario que desea modificar");
		}
		return e;
	}

	public Person uploadByDni(String newName, String dni, String newSurname, String newMail, String newPassword,
			String newUnit) throws Exception {
		logger.info("Se entra en el metodo uploadByDNI del controlador de la entidad Pas");
		logger.debug("Se busca la persona con el dni " + dni);
		Person e = PERSONSERVICE.read(null, dni);
		if (e != null) {
			logger.debug("Se le cambian los parametros " + newName + "," + newSurname + "," + newMail + ","
					+ newPassword + "," + newUnit);
			PASSERVICE.uploadByDNI(e.getId(), newName, dni, newSurname, newMail, e.getUsername(), newPassword,
					e.getTipoPersona(), newUnit);
		} else {
			throw new Exception("No se ha podido encontrar el usuario que desea modificar");
		}
		return e;
	}
}

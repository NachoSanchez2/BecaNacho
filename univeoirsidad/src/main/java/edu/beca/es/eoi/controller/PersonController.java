package edu.beca.es.eoi.controller;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.service.PersonService;
import edu.beca.es.eoi.serviceImpl.PersonServiceImpl;

public class PersonController {
	private static final PersonService PERSONSERVICE = new PersonServiceImpl();
	private static final Logger logger = Logger.getLogger(PersonController.class);

	public Person readByUsername(String username) throws Exception {
		logger.info("Se entra en el metodo readByUsername del controlador de personas");
		logger.debug("Se busca a la persona con el usuario " + username);
		Person e = PERSONSERVICE.read(username, null);
		if (e != null) {
			PERSONSERVICE.readByUsername(e.getTipoPersona(), username);
		} else {
			throw new Exception("No se ha podido encontrar al usuario");
		}
		return e;
	}

	public Person readByDni(String dni) throws Exception {
		logger.info("Se entra en el metodo readByDni del controlador de personas");
		logger.debug("Se busca a la persona con el dni " + dni);
		Person e = PERSONSERVICE.read(null, dni);
		if (e != null) {
			PERSONSERVICE.readByDNI(e.getTipoPersona(), dni);
		} else {
			throw new Exception("No se ha podido encontrar al usuario");
		}
		return e;
	}

	public void deleteByUsername(String username) throws Exception {
		logger.info("Se entra en el metodo deleteByUsername del controlador de personas");
		logger.debug("Se borra a la persona con el usuario" + username);
		boolean deleteOK = PERSONSERVICE.deleteByUsername(username);
		if (!deleteOK) {
			throw new Exception("No se ha podido eliminar el usuario que desea");
		}
	}

	public void deleteByDni(String dni) throws Exception {
		logger.info("Se entra en el metodo deleteByDni del controlador de personas");
		logger.debug("Se borra a la persona con el dni" + dni);
		boolean deleteOK = PERSONSERVICE.deleteByDNI(dni);
		if (!deleteOK) {
			throw new Exception("No se ha podido eliminar el usuario que desea");
		}
	}

}

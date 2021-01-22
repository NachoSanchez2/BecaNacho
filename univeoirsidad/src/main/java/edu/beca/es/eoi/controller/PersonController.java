package edu.beca.es.eoi.controller;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.service.PersonService;
import edu.beca.es.eoi.serviceImpl.PersonServiceImpl;

public class PersonController {
	private static final PersonService PERSONSERVICE = new PersonServiceImpl();

	public Person readByUsername(String username) throws Exception {
		Person e = PERSONSERVICE.read(username, null);
		if (e != null) {
			PERSONSERVICE.readByUsername(e.getTipoPersona(), username);
		} else {
			throw new Exception("No se ha podido encontrar al usuario");
		}
		return e;
	}

	public Person readByDni(String dni) throws Exception {
		Person e = PERSONSERVICE.read(null, dni);
		if (e != null) {
			PERSONSERVICE.readByDNI(e.getTipoPersona(), dni);
		} else {
			throw new Exception("No se ha podido encontrar al usuario");
		}
		return e;
	}

	public void deleteByUsername(String username) throws Exception {
		boolean deleteOK = PERSONSERVICE.deleteByUsername(username);
		if (!deleteOK) {
			throw new Exception("No se ha podido eliminar el usuario que desea");
		}
	}

	public void deleteByDni(String dni) throws Exception {
		boolean deleteOK = PERSONSERVICE.deleteByDNI(dni);
		if (!deleteOK) {
			throw new Exception("No se ha podido eliminar el usuario que desea");
		}
	}

}

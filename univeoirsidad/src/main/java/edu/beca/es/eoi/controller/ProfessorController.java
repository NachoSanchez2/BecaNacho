package edu.beca.es.eoi.controller;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.service.PersonService;
import edu.beca.es.eoi.service.ProfessorService;
import edu.beca.es.eoi.serviceImpl.PersonServiceImpl;
import edu.beca.es.eoi.serviceImpl.ProfessorServiceImpl;

public class ProfessorController {

	private static final ProfessorService PROFESSORSERVICE = new ProfessorServiceImpl();
	private static final PersonService PERSONSERVICE = new PersonServiceImpl();

	public void saveProfessor(String name, String dni, String surname, String mail, String username, String password,
			int tipoPersona, String faculty) throws Exception {

		boolean savePersonOK = PERSONSERVICE.save(name, dni, surname, mail, username, password, tipoPersona);
		int id = PERSONSERVICE.read(username, dni).getId();
		int idUser = id;
		if (savePersonOK) {
			boolean saveOK = PROFESSORSERVICE.saveProfessor(id, name, dni, surname, mail, username, password,
					tipoPersona, faculty, idUser);
			if (!saveOK) {
				throw new Exception("No se ha podido guardar la facultad");
			}
		} else {
			throw new Exception("No se ha podido guardar al usuario");
		}
	}

	public Person uploadByUsername(String newName, String newSurname, String newMail, String username,
			String newPassword, String newOffice) throws Exception {

		Person e = PERSONSERVICE.read(username, null);
		if (e != null) {
			PROFESSORSERVICE.uploadByUsername(e.getId(), newName, e.getDni(), newSurname, newMail, username,
					newPassword, e.getTipoPersona(), newOffice);
		} else {
			throw new Exception("No se ha podido encontrar el usuario que desea modificar");
		}
		return e;
	}

	public Person uploadByDni(String newName, String dni, String newSurname, String newMail, String newPassword,
			String newOffice) throws Exception {

		Person e = PERSONSERVICE.read(null, dni);
		if (e != null) {
			PROFESSORSERVICE.uploadByDNI(e.getId(), newName, dni, newSurname, newMail, e.getUsername(), newPassword,
					e.getTipoPersona(), newOffice);
		} else {
			throw new Exception("No se ha podido encontrar el usuario que desea modificar");
		}
		return e;
	}
}

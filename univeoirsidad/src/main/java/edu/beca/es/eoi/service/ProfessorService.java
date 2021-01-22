package edu.beca.es.eoi.service;

import edu.beca.es.eoi.entity.Person;

public interface ProfessorService {

	Person uploadByDNI(int id, String newName, String dni, String newSurname, String newMail, String username,
			String newPassword, int tipoPersona, String newOffice);

	Person uploadByUsername(int id, String newName, String dni, String newSurname, String newMail, String username,
			String newPassword, int tipoPersona, String newOffice);

	boolean saveProfessor(int id, String name, String dni, String surname, String mail, String username,
			String password, int tipoPersona, String office, int idUser);

}

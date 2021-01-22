package edu.beca.es.eoi.service;

import edu.beca.es.eoi.entity.Person;

public interface StudentService {

	boolean saveStudent(int id, String name, String dni, String surname, String mail, String username, String password,
			int tipoPersona, String faculty, int idUser);

	Person uploadByUsername(int id, String newName, String dni, String newSurname, String newMail, String username,
			String newPassword, int tipoPersona, String newfaculty);

	Person uploadByDNI(int id, String newName, String dni, String newSurname, String newMail, String username,
			String newPassword, int tipoPersona, String faculty);

}

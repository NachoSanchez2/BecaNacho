package edu.beca.es.eoi.service;

import edu.beca.es.eoi.entity.Person;

public interface PasService {

	public boolean savePas(int id, String name, String dni, String surname, String mail, String username,
			String password, int tipoPersona, String unit, int idUser);

	public Person uploadByUsername(int id, String newName, String dni, String newSurname, String newMail,
			String username, String newPassword, int tipoPersona, String newUnit);

	public Person uploadByDNI(int id, String newName, String dni, String newSurname, String newMail, String username,
			String newPassword, int tipoPersona, String newUnit);
}

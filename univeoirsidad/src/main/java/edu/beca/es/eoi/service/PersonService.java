package edu.beca.es.eoi.service;

import edu.beca.es.eoi.entity.Person;

public interface PersonService {

	boolean save(String name, String dni, String surname, String mail, String username, String password, int tipoPersona);

	Person read(String username, String dni);

	Person readByUsername(int tipoPersona, String username);

	Person readByDNI(int tipoPersona, String dni);

	boolean deleteByUsername(String username);

	boolean deleteByDNI(String dni);

}

package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;
import edu.beca.es.eoi.service.PersonService;

public class PersonServiceImpl implements PersonService {

	private static final PersonRepository REPOSITORY = new PersonRepositoryJDBCImpl();

	@Override
	public boolean save(String name, String dni, String surname, String mail, String username, String password,
			int tipoPersona) {
		// Declaration
		Person person = new Person(name, dni, surname, mail, username, password, tipoPersona);

		// Implementation
		boolean saveOK = REPOSITORY.save(person);

		// Return
		return saveOK;
	}

	@Override
	public Person read(String username, String dni) {
		return REPOSITORY.read(username, dni);
	}

	@Override
	public Person readByUsername(int tipoPersona, String username) {
		return REPOSITORY.readByUsername(tipoPersona, username);
	}

	@Override
	public Person readByDNI(int tipoPersona, String dni) {
		return REPOSITORY.readByDNI(tipoPersona, dni);
	}

	@Override
	public boolean deleteByUsername(String username) {
		return REPOSITORY.deleteByUsername(username);
	}

	@Override
	public boolean deleteByDNI(String dni) {
		return REPOSITORY.deleteByDNI(dni);
	}

}

package edu.beca.es.eoi.serviceImpl;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;
import edu.beca.es.eoi.service.PersonService;

public class PersonServiceImpl implements PersonService {

	private static final PersonRepository REPOSITORY = new PersonRepositoryJDBCImpl();
	private static final Logger logger = Logger.getLogger(PersonServiceImpl.class);

	@Override
	public boolean save(String name, String dni, String surname, String mail, String username, String password,
			int tipoPersona) {
		logger.info("Entro en el metodo save de la entidad Persona de la implementacion de servicios");
		// Declaration
		Person person = new Person(name, dni, surname, mail, username, password, tipoPersona);

		// Implementation
		boolean saveOK = REPOSITORY.save(person);

		// Return
		return saveOK;
	}

	@Override
	public Person read(String username, String dni) {
		logger.info("Entro en el metodo readPerson de la entidad Persona de la implementacion de servicios");
		return REPOSITORY.read(username, dni);
	}

	@Override
	public Person readByUsername(int tipoPersona, String username) {
		logger.info("Entro en el metodo readByUsername de la entidad Persona de la implementacion de servicios");
		return REPOSITORY.readByUsername(tipoPersona, username);
	}

	@Override
	public Person readByDNI(int tipoPersona, String dni) {
		logger.info("Entro en el metodo readByDNI de la entidad Persona de la implementacion de servicios");
		return REPOSITORY.readByDNI(tipoPersona, dni);
	}

	@Override
	public boolean deleteByUsername(String username) {
		logger.info("Entro en el metodo deleteByUsername de la entidad Persona de la implementacion de servicios");
		return REPOSITORY.deleteByUsername(username);
	}

	@Override
	public boolean deleteByDNI(String dni) {
		logger.info("Entro en el metodo deleteByDNI de la entidad Persona de la implementacion de servicios");
		return REPOSITORY.deleteByDNI(dni);
	}

}

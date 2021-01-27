package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.Dog;
import edu.beca.es.eoi.repository.PetRepository;
import edu.beca.es.eoi.repositoryImpl.PetRepositoryJDBCImpl;
import edu.beca.es.eoi.service.DogService;
import lombok.extern.log4j.Log4j;

@Log4j
public class DogServiceImpl implements DogService {
	// Repository
	public static final PetRepository REPOSITORY = new PetRepositoryJDBCImpl();

	@Override
	public boolean saveDog(String name, String location, String description, int typePet, String photo, Integer age,
			Integer idPet) {
		log.info("Entra en el menu de saveDog");
		Dog dog = new Dog(name, location, description, typePet, photo, age, idPet);
		return REPOSITORY.saveDog(dog);
	}

}

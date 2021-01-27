package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.Bird;
import edu.beca.es.eoi.repository.PetRepository;
import edu.beca.es.eoi.repositoryImpl.PetRepositoryJDBCImpl;
import edu.beca.es.eoi.service.BirdService;
import lombok.extern.log4j.Log4j;

@Log4j
public class BirdServiceImpl implements BirdService {
	private static final PetRepository REPOSITORY = new PetRepositoryJDBCImpl();

	@Override
	public boolean saveBird(String name, String location, String description, int typePet, String photo, String colour,
			Integer idPet) {
		log.info("Entra en el menu de saveCat");
		Bird bird = new Bird(name, location, description, typePet, photo, colour, idPet);
		return REPOSITORY.saveBird(bird);
	}

}

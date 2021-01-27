package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.Cat;
import edu.beca.es.eoi.repository.PetRepository;
import edu.beca.es.eoi.repositoryImpl.PetRepositoryJDBCImpl;
import edu.beca.es.eoi.service.CatService;
import lombok.extern.log4j.Log4j;

@Log4j
public class CatServiceImpl implements CatService {
	private static final PetRepository REPOSITORY = new PetRepositoryJDBCImpl();

	@Override
	public boolean saveCat(String name, String location, String description, int typePet, String photo, Integer age,
			Integer idPet) {
		log.info("Entra en el menu de saveCat");
		Cat cat = new Cat(name, location, description, typePet, photo, age, idPet);
		return REPOSITORY.saveCat(cat);
	}
}

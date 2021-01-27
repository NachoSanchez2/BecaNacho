package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.Other;
import edu.beca.es.eoi.repository.PetRepository;
import edu.beca.es.eoi.repositoryImpl.PetRepositoryJDBCImpl;
import edu.beca.es.eoi.service.OtherService;
import lombok.extern.log4j.Log4j;

@Log4j
public class OtherServiceImpl implements OtherService {
	// Repository
	public static final PetRepository REPOSITORY = new PetRepositoryJDBCImpl();

	@Override
	public boolean saveOther(String name, String location, String description, int typePet, String photo, String type,
			Integer idPet) {
		log.info("Entra en el menu de saveDog");
		Other other = new Other(name, location, description, typePet, photo, type, idPet);
		return REPOSITORY.saveOther(other);
	}
}

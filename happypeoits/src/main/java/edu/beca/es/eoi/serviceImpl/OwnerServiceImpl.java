package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.Owner;
import edu.beca.es.eoi.repository.OwnerRepository;
import edu.beca.es.eoi.repositoryImpl.OwnerRepositoryJDBCImpl;
import edu.beca.es.eoi.service.OwnerService;

public class OwnerServiceImpl implements OwnerService {
	private static final OwnerRepository REPOSITORY = new OwnerRepositoryJDBCImpl();

	@Override
	public boolean saveOwner(String name, String phone, int idPet) {
		Owner owner = new Owner(name, phone, idPet);
		return REPOSITORY.saveOwner(owner);
	}

}

package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.Pet;
import edu.beca.es.eoi.repository.PetRepository;
import edu.beca.es.eoi.repositoryImpl.PetRepositoryJDBCImpl;
import edu.beca.es.eoi.service.PetService;
import lombok.extern.log4j.Log4j;

@Log4j
public class PetServiceImpl implements PetService {

	// Repository
	public static final PetRepository REPOSITORY = new PetRepositoryJDBCImpl();

	@Override
	public int savePet(String name, String location, String description, int typePet, String photo) {
		log.info("Entra en el metodo savePet del servicio, se instancia una mascota y se manda al repository");

		// Declaration of pet and instantiation
		Pet pet = new Pet(name, location, description, typePet, photo);
		return REPOSITORY.savePet(pet);
	}

	@Override
	public Pet readById(int id) {
		return REPOSITORY.readById(id);
	}

	@Override
	public int readByName(String name) {
		return REPOSITORY.readByName(name);
	}

	@Override
	public boolean uploadbyID(int idPet, String newname, String newlocation, String newdescription, String newOwnerName,
			String newtlf, String newphoto, int newage, String newColour, String newType) {

		if (newColour.equals(null) && newType.equals(null)) {
			return REPOSITORY.uploadPet(idPet, newname, newlocation, newdescription, newOwnerName, newtlf, newphoto,
					newage, null, null);
		} else if (newage == 0 && newType.equals(null)) {
			return REPOSITORY.uploadPet(idPet, newname, newlocation, newdescription, newOwnerName, newtlf, newphoto, 0,
					newColour, null);
		} else if (newage == 0 && newColour.equals(null)) {
			return REPOSITORY.uploadPet(idPet, newname, newlocation, newdescription, newOwnerName, newtlf, newphoto, 0,
					null, newType);
		} else {
			return false;
		}

	}

	public boolean deletebyid(int idPet) {
		return REPOSITORY.deletePet(idPet);
	}
}

package edu.beca.es.eoi.controller;

import edu.beca.es.eoi.UIConsole.BirdMenu;
import edu.beca.es.eoi.UIConsole.CatMenu;
import edu.beca.es.eoi.UIConsole.DogMenu;
import edu.beca.es.eoi.UIConsole.OtherMenu;
import edu.beca.es.eoi.entity.Pet;
import edu.beca.es.eoi.enums.TypePets;
import edu.beca.es.eoi.service.BirdService;
import edu.beca.es.eoi.service.CatService;
import edu.beca.es.eoi.service.DogService;
import edu.beca.es.eoi.service.OtherService;
import edu.beca.es.eoi.service.PetService;
import edu.beca.es.eoi.serviceImpl.BirdServiceImpl;
import edu.beca.es.eoi.serviceImpl.CatServiceImpl;
import edu.beca.es.eoi.serviceImpl.DogServiceImpl;
import edu.beca.es.eoi.serviceImpl.OtherServiceImpl;
import edu.beca.es.eoi.serviceImpl.PetServiceImpl;
import lombok.extern.log4j.Log4j;

@Log4j
public class PetController {

	// Services
	private static final PetService PETSERVICE = new PetServiceImpl();
	private static final DogService DOGSERVICE = new DogServiceImpl();
	private static final CatService CATSERVICE = new CatServiceImpl();
	private static final BirdService BIRDSERVICE = new BirdServiceImpl();
	private static final OtherService OTHERSERVICE = new OtherServiceImpl();

	// Menus
	private static final DogMenu DOGMENU = new DogMenu();
	private static final CatMenu CATMENU = new CatMenu();
	private static final BirdMenu BIRDMENU = new BirdMenu();
	private static final OtherMenu OTHERMENU = new OtherMenu();

	public int savePet(String name, String location, String description, int typePet, String photo) throws Exception {
		log.info("Entra en el metodo savePet del controlador");
		// Variables declaration
		int id = PETSERVICE.savePet(name, location, description, typePet, photo);
		if (id > 1) {
			return id;
		} else {
			throw new Exception("Ha habido un problema al dar de alta la mascota, por favor, vuelva a intentarlo");
		}
	}

	public void saveDog(String name, String location, String description, int typePet, String photo, int age, int idPet)
			throws Exception {
		log.info("Entra en el metodo saveDog del controlador");
		// Variables declaration
		boolean saveOK = DOGSERVICE.saveDog(name, location, description, typePet, photo, age, idPet);
		if (!saveOK) {
			throw new Exception("No se ha podido guardar la mascota, ha habido un error inesperado");
		}
	}

	public void saveCat(String name, String location, String description, int typePet, String photo, int age, int idPet)
			throws Exception {
		log.info("Entra en el metodo saveCat del controlador");
		// Variables declaration
		boolean saveOK = CATSERVICE.saveCat(name, location, description, typePet, photo, age, idPet);
		if (!saveOK) {
			throw new Exception("No se ha podido guardar la mascota, ha habido un error inesperado");
		}
	}

	public void saveBird(String name, String location, String description, int typePet, String photo, String colour,
			int idPet) throws Exception {
		log.info("Entra en el metodo saveBird del controlador");
		// Variables declaration
		boolean saveOK = BIRDSERVICE.saveBird(name, location, description, typePet, photo, colour, idPet);
		if (!saveOK) {
			throw new Exception("No se ha podido guardar la mascota, ha habido un error inesperado");
		}
	}

	public void saveOther(String name, String location, String description, int typePet, String photo, String type,
			int idPet) throws Exception {
		log.info("Entra en el metodo saveOther del controlador");
		// Variables declaration
		boolean saveOK = OTHERSERVICE.saveOther(name, location, description, typePet, photo, type, idPet);
		if (!saveOK) {
			throw new Exception("No se ha podido guardar la mascota, ha habido un error inesperado");
		}
	}

	public void readById(int idPet) {
		Pet pet = PETSERVICE.readById(idPet);
		if (pet.getTypepet() == TypePets.DOG.getIntValue()) {
			DOGMENU.readByIdResult(pet);
		} else if (pet.getTypepet() == TypePets.CAT.getIntValue()) {
			CATMENU.readByIdResult(pet);
		} else if (pet.getTypepet() == TypePets.BIRD.getIntValue()) {
			BIRDMENU.readByIdResult(pet);
		} else {
			OTHERMENU.readByIdResult(pet);
		}
	}

	public int readByName(String name) {
		return PETSERVICE.readByName(name);
	}

	public void uploadPet(String newname, String newlocation, String newdescription, int typePet, String newOwnerName,
			String newtlf, String newphoto, int idPet) throws Exception {
		boolean uploadOK = false;
		if (typePet == TypePets.DOG.getIntValue()) {
			uploadOK = DOGMENU.uploadDog(idPet, newname, newlocation, newdescription, newOwnerName, newtlf, newphoto);
		} else if (typePet == TypePets.CAT.getIntValue()) {
			uploadOK = CATMENU.uploadCat(idPet, newname, newlocation, newdescription, newOwnerName, newtlf, newphoto);
		} else if (typePet == TypePets.BIRD.getIntValue()) {
			uploadOK = BIRDMENU.uploadBird(idPet, newname, newlocation, newdescription, newOwnerName, newtlf, newphoto);
		} else {
			uploadOK = OTHERMENU.uploadOther(idPet, newname, newlocation, newdescription, newOwnerName, newtlf,
					newphoto);
		}
		if (!uploadOK) {
			throw new Exception("Ha habido un problema al introducir los cambios");
		}
	}

	public void deletebyid(int idPet) throws Exception {
		boolean deleteOK = PETSERVICE.deletebyid(idPet);
		if (!deleteOK) {
			throw new Exception("No se ha podido eliminar la mascota");
		}
	}

}

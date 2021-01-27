package edu.beca.es.eoi.repository;

import edu.beca.es.eoi.entity.Bird;
import edu.beca.es.eoi.entity.Cat;
import edu.beca.es.eoi.entity.Dog;
import edu.beca.es.eoi.entity.Other;
import edu.beca.es.eoi.entity.Pet;

public interface PetRepository extends CrudInterface<Pet, Integer> {
	boolean saveDog(Dog e);

	boolean saveCat(Cat e);

	boolean saveBird(Bird e);

	boolean saveOther(Other e);

	int readByName(String name);

	boolean uploadPet(int idPet, String newname, String newlocation, String newdescription, String newOwnerName,
			String newtlf, String newphoto, int newage, String newColour, String newType);

}

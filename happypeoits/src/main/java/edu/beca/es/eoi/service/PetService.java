package edu.beca.es.eoi.service;

import edu.beca.es.eoi.entity.Pet;

public interface PetService {
	int savePet(String name, String location, String description, int typePet, String photos);

	int readByName(String name);

	Pet readById(int id);

	boolean uploadbyID(int idPet, String newname, String newlocation, String newdescription, String newOwnerName,
			String newtlf, String newphoto, int newage, String newColour, String newType);

	boolean deletebyid(int idPet);
}

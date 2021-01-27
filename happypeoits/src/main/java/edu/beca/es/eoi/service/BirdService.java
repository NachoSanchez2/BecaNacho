package edu.beca.es.eoi.service;

public interface BirdService {
	boolean saveBird(String name, String location, String description, int typePet, String photo, String colour,
			Integer idPet);

}

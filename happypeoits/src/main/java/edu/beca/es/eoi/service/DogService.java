package edu.beca.es.eoi.service;

public interface DogService {
	boolean saveDog(String name, String location, String description, int typePet, String photo, Integer age,
			Integer idPet);
}

package edu.beca.es.eoi.service;

public interface CatService {
	boolean saveCat(String name, String location, String description, int typePet, String photo, Integer age,
			Integer idPet);

}

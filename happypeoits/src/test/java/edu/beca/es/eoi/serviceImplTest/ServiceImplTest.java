package edu.beca.es.eoi.serviceImplTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.enums.TypePets;
import edu.beca.es.eoi.service.BirdService;
import edu.beca.es.eoi.service.CatService;
import edu.beca.es.eoi.service.DogService;
import edu.beca.es.eoi.service.OtherService;
import edu.beca.es.eoi.service.OwnerService;
import edu.beca.es.eoi.service.PetService;
import edu.beca.es.eoi.serviceImpl.BirdServiceImpl;
import edu.beca.es.eoi.serviceImpl.CatServiceImpl;
import edu.beca.es.eoi.serviceImpl.DogServiceImpl;
import edu.beca.es.eoi.serviceImpl.OtherServiceImpl;
import edu.beca.es.eoi.serviceImpl.OwnerServiceImpl;
import edu.beca.es.eoi.serviceImpl.PetServiceImpl;

class ServiceImplTest {

	@Test
	void testSavePet() {
		// PreparedTest
		PetService service = new PetServiceImpl();
		String name = "Test";
		String location = "Test";
		String description = "Test,Test";
		String photo = "TEST.ATEST";
		// Implementation
		int idPet = service.savePet(name, location, description, TypePets.DOG.getIntValue(), photo);

		// Assert
		assertEquals(34, idPet);
	}

	@Test
	void testSaveOwner() {

		// PreparedTest
		OwnerService service = new OwnerServiceImpl();
		String name = "PACO";
		String phone = "123456Q";
		int idPet = 6;

		// Assert and implementation
		assertTrue(service.saveOwner(name, phone, idPet));
	}

	@Test
	void testSaveDog() {

		// PreparedTest
		DogService service = new DogServiceImpl();
		String name = "Test";
		String location = "test";
		String description = "test, muy test";
		int typePet = TypePets.DOG.getIntValue();
		String photo = "test";
		Integer age = 125;
		Integer idPet = 4;

		// Assert and implementation
		assertTrue(service.saveDog(name, location, description, typePet, photo, age, idPet));
	}

	@Test
	void testSaveCat() {

		// Prepared Test
		CatService service = new CatServiceImpl();
		String name = "Test";
		String location = "test";
		String description = "test, muy test";
		int typePet = TypePets.CAT.getIntValue();
		String photo = "test";
		Integer age = 120;
		Integer idPet = 2;

		// Assert and implementation
		assertTrue(service.saveCat(name, location, description, typePet, photo, age, idPet));
	}

	@Test
	void testSaveBird() {

		// PreparedTest
		BirdService service = new BirdServiceImpl();
		String name = "Test";
		String location = "test";
		String description = "test, muy test";
		int typePet = TypePets.BIRD.getIntValue();
		String photo = "test";
		String colour = "yellow";
		Integer idPet = 5;

		// Assert and implementation
		assertTrue(service.saveBird(name, location, description, typePet, photo, colour, idPet));
	}

	@Test
	void testSaveOther() {

		// PreparedTest
		OtherService service = new OtherServiceImpl();
		String name = "Test";
		String location = "test";
		String description = "test, muy test";
		int typePet = TypePets.DOG.getIntValue();
		String photo = "test";
		String type = "Lagarto";
		Integer idPet = 8;

		// Assert and implementation
		assertTrue(service.saveOther(name, location, description, typePet, photo, type, idPet));
	}

}

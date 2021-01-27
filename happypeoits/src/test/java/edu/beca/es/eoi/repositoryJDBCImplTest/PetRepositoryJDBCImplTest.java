package edu.beca.es.eoi.repositoryJDBCImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Bird;
import edu.beca.es.eoi.entity.Cat;
import edu.beca.es.eoi.entity.Dog;
import edu.beca.es.eoi.entity.Other;
import edu.beca.es.eoi.entity.Pet;
import edu.beca.es.eoi.enums.TypePets;
import edu.beca.es.eoi.repository.PetRepository;
import edu.beca.es.eoi.repositoryImpl.PetRepositoryJDBCImpl;

class PetRepositoryJDBCImplTest {

	@Test
	void testSavePet() {
		// Preparated Test
		PetRepository repository = new PetRepositoryJDBCImpl();
		Pet pet = new Pet("Test", "Altea", "Perro muy asqueroso", TypePets.DOG.getIntValue(), "poaghlaksdgjlakjdgs");

		// Implementation
		int idPet = repository.savePet(pet);

		// Assert
		assertEquals(33, idPet);
	}

	@Test
	void testSaveDog() {
		// Preparated Test
		PetRepository repository = new PetRepositoryJDBCImpl();
		Dog dog = new Dog("Scooby", "Altea", "Chiquitito, muy chiquitito", TypePets.CAT.getIntValue(), "ASKDGJASKDGJ",
				125, 4);

		// Assert and implementation
		assertTrue(repository.saveDog(dog));
	}

	@Test
	void testSaveCat() {
		// Preparated Test
		PetRepository repository = new PetRepositoryJDBCImpl();
		Cat cat = new Cat("TEST", "TEST", "TEST, TEST, TEST", TypePets.CAT.getIntValue(), "TEST", 120, 2);

		// Assert and implementation
		assertTrue(repository.saveCat(cat));
	}

	@Test
	void testSaveBird() {
		// Preparated Test
		PetRepository repository = new PetRepositoryJDBCImpl();
		Bird bird = new Bird("Test", "test", "test, test test", TypePets.BIRD.getIntValue(), "test", "Granate", 5);

		// Assert and implementation
		assertTrue(repository.saveBird(bird));
	}

	@Test
	void testSaveOther() {
		// Preparated Test
		PetRepository repository = new PetRepositoryJDBCImpl();
		Other other = new Other("test", "test", "test, test test", TypePets.OTHER.getIntValue(), "test", "Lagartija",
				2);

		// Assert and implementation
		assertTrue(repository.saveOther(other));
	}

	@Test
	void testreadById() {
		// Preparation Test
		int idCat = 1;
		PetRepository repository = new PetRepositoryJDBCImpl();

		// Implementation
		Pet cat = repository.readById(idCat);

		// Assert
		assertNotNull(cat);
	}

	@Test
	void testreadByName() {
		// TestPrepared
		String name = "Lola llobell";
		PetRepository repository = new PetRepositoryJDBCImpl();
		int idPet = repository.readByName(name);

		// Assert
		assertEquals(14, idPet);
	}

	@Test
	void testUploadById() {
		int idPet = 22;
		String newname = "Test";
		String newlocation = "Test";
		String newdescription = "Test,test";
		String newOwnerName = "Pablo";
		String newtlf = "123456789Q";
		String newphoto = "kasdhglkasdjglkasg";
		int newage = 0;
		String newColour = null;
		String newType = "Periquito";
		PetRepository repository = new PetRepositoryJDBCImpl();

		assertTrue(repository.uploadPet(idPet, newname, newlocation, newdescription, newOwnerName, newtlf, newphoto,
				newage, newColour, newType));
	}

}

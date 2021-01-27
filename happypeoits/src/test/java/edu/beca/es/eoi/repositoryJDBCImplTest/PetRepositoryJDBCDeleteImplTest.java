package edu.beca.es.eoi.repositoryJDBCImplTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.repository.PetRepository;
import edu.beca.es.eoi.repositoryImpl.PetRepositoryJDBCImpl;

class PetRepositoryJDBCDeleteImplTest {

	@Test
	void testDeletePet() {

		// PreparationTest
		int idPet = 15;
		PetRepository repository = new PetRepositoryJDBCImpl();

		// Implementation and assert
		assertTrue(repository.deletePet(idPet));
	}

}

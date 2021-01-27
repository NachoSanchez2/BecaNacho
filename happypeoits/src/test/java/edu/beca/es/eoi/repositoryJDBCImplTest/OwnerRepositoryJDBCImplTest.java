package edu.beca.es.eoi.repositoryJDBCImplTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Owner;
import edu.beca.es.eoi.repository.OwnerRepository;
import edu.beca.es.eoi.repositoryImpl.OwnerRepositoryJDBCImpl;

class OwnerRepositoryJDBCImplTest {

	@Test
	void testSaveOwner() {
		// Test preparation
		Owner owner = new Owner("Pepe", "12345678Q", 3);
		OwnerRepository repository = new OwnerRepositoryJDBCImpl();

		// Implementation and assert
		assertTrue(repository.saveOwner(owner));
	}

}

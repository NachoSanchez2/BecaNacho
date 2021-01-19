package edu.beca.es.eoi.aleoixaRepositoryImplTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.aleoixaRepository.JokesRepository;
import edu.beca.es.eoi.aleoixaRepositoryImpl.JokesRepositoryJDBCImpl;

class JokeRepositoryJDBCImplTest {

	@Test
	void testReadById() {
		// TestPreparation
		int id = 1;
		JokesRepository repository = new JokesRepositoryJDBCImpl();

		// Implementation
		String joke = repository.readById(id);

		// Assert
		assertNotNull(joke);

	}

}

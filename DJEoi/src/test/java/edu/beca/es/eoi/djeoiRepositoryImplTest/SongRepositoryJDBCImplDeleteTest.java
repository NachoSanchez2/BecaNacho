package edu.beca.es.eoi.djeoiRepositoryImplTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.djeoiRepository.SongRepository;
import edu.beca.es.eoi.djeoiRepositoryImpl.SongRepositoryJDBCImpl;

class SongRepositoryJDBCImplDeleteTest {

	@Test
	void testDelete() {
		// PreparedTest
		String songName = "TEST";
		SongRepository repository = new SongRepositoryJDBCImpl();
		// Asserts
		assertTrue(repository.delete(songName));
	}

}

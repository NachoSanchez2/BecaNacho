package edu.beca.es.eoi.djeoiRepositoryImplTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.djeoiEntity.Song;
import edu.beca.es.eoi.djeoiRepository.SongRepository;
import edu.beca.es.eoi.djeoiRepositoryImpl.SongRepositoryJDBCImpl;

class SongRepositoryJDBCImplTest {

	@Test
	void testSave() {
		// Prepared test
		String songName = "TEST";
		String songvalue = "TEST";
		Song song = new Song(songName, songvalue);

		// Implementation
		SongRepository repository = new SongRepositoryJDBCImpl();

		// Asserts
		assertTrue(repository.save(song));
	}

	@Test
	void testReadAllSongs() {
		// Prepared Test
		Map<String, String> songs = new TreeMap<String, String>();
		SongRepository repository = new SongRepositoryJDBCImpl();

		// Implementation
		songs = repository.readAllSongs();
		assertNotNull(songs.keySet());

	}

}

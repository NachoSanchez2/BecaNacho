package edu.beca.es.eoi.djeoiUItest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.djeoiController.SongController;

class SongMenuTest {

	@Test
	void testPlaySong() {
		SongController controller = new SongController();
		String songName = "Los_Simpsons";
		assertTrue(controller.playSong(songName));
	}

}

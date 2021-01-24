package edu.beca.es.eoi.djeoiController;

import java.util.Map;

import org.apache.log4j.Logger;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import edu.beca.es.eoi.djeoiService.SongService;
import edu.beca.es.eoi.djeoiServiceImpl.SongServiceImpl;

public class SongController {

	// Configuration: Logger, jukebox and SERVICE;
	private static final Logger logger = Logger.getLogger(SongController.class);
	private static final Player jukebox = new Player();
	private static final SongService SONGSERVICE = new SongServiceImpl();

	// Global variables
	private static Map<String, String> songs;

	public Map<String, String> readAllSongs() {
		return SONGSERVICE.readAllSongs();
	}

	public boolean playSong(String songName) {
		boolean playOK = false;
		logger.info(
				"Se entra en el metodo playSong, se le pasa la cancion seleccionada y se recoge la lista de canciones");
		songs = SONGSERVICE.readAllSongs();
		for (String songAUX : songs.keySet()) {
			if (songAUX.equalsIgnoreCase(songName)) {
				Pattern song = new Pattern(songs.get(songAUX).toString());
				logger.debug("El valor de la cancion es: " + song);
				jukebox.play(song);
				playOK = true;
			}
		}
		logger.info("Se sale del metodo playSong");
		return playOK;
	}

	public boolean deleteSong(String songName) {
		return SONGSERVICE.delete(songName);
	}
}

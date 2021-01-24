package edu.beca.es.eoi.djeoiServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jfugue.pattern.Pattern;

import edu.beca.es.eoi.djeoiEntity.Song;
import edu.beca.es.eoi.djeoiEntity.Voice;
import edu.beca.es.eoi.djeoiRepository.SongRepository;
import edu.beca.es.eoi.djeoiRepositoryImpl.SongRepositoryJDBCImpl;
import edu.beca.es.eoi.djeoiService.SongService;

public class SongServiceImpl implements SongService {
	private static final Pattern VOICEPATTERN = new Pattern();
	private static final SongRepository SONGREPOSITORY = new SongRepositoryJDBCImpl();

	// This is for testing
	private static List<Song> songs = new ArrayList<Song>();

	@Override
	public void save(Map<String, Voice> voices, String songName) {

		for (Voice voice : voices.values()) {
			VOICEPATTERN.add(voice.getVoice());
		}
		Song song = new Song(songName, VOICEPATTERN.toString());

		SONGREPOSITORY.save(song);
		songs.add(song);
	}

	@Override
	public Map<String, String> readAllSongs() {
		return SONGREPOSITORY.readAllSongs();
	}

	@Override
	public boolean delete(String songName) {
		return SONGREPOSITORY.delete(songName);
	}

}

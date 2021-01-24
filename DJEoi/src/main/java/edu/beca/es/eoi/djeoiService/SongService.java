package edu.beca.es.eoi.djeoiService;

import java.util.Map;

import edu.beca.es.eoi.djeoiEntity.Voice;

public interface SongService {
	void save(Map<String, Voice> voices, String songName);

	Map<String, String> readAllSongs();

	boolean delete(String songName);
}

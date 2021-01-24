package edu.beca.es.eoi.djeoiRepository;

import java.util.Map;

public interface CrudInterface<E, SEARCH_FILE> {

	boolean save(E e);

	Map<SEARCH_FILE, SEARCH_FILE> readAllSongs();

	boolean delete(SEARCH_FILE sf);

}

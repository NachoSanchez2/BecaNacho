package edu.beca.es.eoi.djeoiService;

import java.util.Map;

public interface CrudInterface<E> {

	boolean save(E e);

	Map<String, String> readAllSongs();

	boolean delete(E e);

}

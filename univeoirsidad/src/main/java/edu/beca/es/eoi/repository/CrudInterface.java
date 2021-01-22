package edu.beca.es.eoi.repository;

public interface CrudInterface<E, SEARCH_FIELD> {

	boolean save(E e);

	E read(SEARCH_FIELD sf1, SEARCH_FIELD sf2);

	E readByUsername(int i, SEARCH_FIELD sf);

	E readByDNI(int i, SEARCH_FIELD sf);

	E uploadByUsername(int i,E e, SEARCH_FIELD sf);

	E uploadByDNI(int i,E e, SEARCH_FIELD sf);

	boolean deleteByUsername(SEARCH_FIELD sf);

	boolean deleteByDNI(SEARCH_FIELD sf);
}

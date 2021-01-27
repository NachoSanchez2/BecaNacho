package edu.beca.es.eoi.repository;

public interface CrudInterface<E, ID> {

	ID savePet(E e);

	E readById(ID id);

	boolean deletePet(ID id);

}

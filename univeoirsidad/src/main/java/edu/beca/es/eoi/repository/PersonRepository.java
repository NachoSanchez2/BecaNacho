package edu.beca.es.eoi.repository;

import edu.beca.es.eoi.entity.Person;

public interface PersonRepository extends CrudInterface<Person, String> {

	public boolean saveStudent(int idUser, Person e);

	public boolean saveProfessor(int idUser, Person e);

	public boolean savePas(int idUser, Person e);
}

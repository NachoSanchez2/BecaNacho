package edu.beca.es.eoi.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Person {
	String faculty;
	int idUser;

	public Student(int id, String name, String dni, String surname, String mail, String username, String password,
			int tipoPersona, String faculty, int idUser) {
		super(id, name, surname, dni, mail, username, password, tipoPersona);
		this.faculty = faculty;
		this.idUser = idUser;
	}

	public Student(String name, String dni, String surname, String mail, String username, String password,
			int tipoPersona, String faculty) {
		super(name, surname, dni, mail, username, password, tipoPersona);
		this.faculty = faculty;
	}

	public Student(String name, String dni, String surname, String mail, String username, String password,
			int tipoPersona) {
		super(name, surname, dni, mail, username, password, tipoPersona);
	}

	public Student(String username) {
		super(username);
	}

	public Student(String name, String dni, String surname, String mail, String username, String password,
			int tipoPersona, String faculty, int idUser) {
		super(name, surname, dni, mail, username, password, tipoPersona);

		this.faculty = faculty;
		this.idUser = idUser;
	}

	public Student(String name, String surname, String mail, String password, int tipoPersona, String faculty) {
		super(name, surname, mail, password, tipoPersona);
		this.faculty = faculty;
	}

}

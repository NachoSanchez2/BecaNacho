package edu.beca.es.eoi.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Professor extends Person {

	private String office;
	private int idUser;

	public Professor(int id, String name, String surname, String dni, String mail, String username, String password,
			int tipoPersona, String office, int idUser) {
		super(id, name, surname, dni, mail, username, password, tipoPersona);
		this.office = office;
		this.idUser = idUser;
	}

	public Professor(String name, String surname, String dni, String mail, String username, String password,
			int tipoPersona) {
		super(name, surname, dni, mail, username, password, tipoPersona);
	}

	public Professor(String name, String surname, String mail, String password, int tipoPersona, String office) {
		super(name, surname, mail, password, tipoPersona);
		this.office = office;
	}
}

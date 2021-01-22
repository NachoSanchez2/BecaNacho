package edu.beca.es.eoi.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pas extends Person {
	private String unit;
	private int idUser;

	public Pas(int id, String name, String dni,String surname, String mail, String username, String password,
			int tipoPersona, String unit, int idUser) {
		super(id, name, surname, dni, mail, username, password, tipoPersona);
		this.unit = unit;
		this.idUser = idUser;
	}

	public Pas(int id, String name, String surname, String dni, String mail, String username, String password,
			int tipoPersona) {
		super(id, name, surname, dni, mail, username, password, tipoPersona);
	}

	public Pas(String name, String surname, String dni, String mail, String username, String password,
			int tipoPersona) {
		super(name, surname, dni, mail, username, password, tipoPersona);
	}

	public Pas(String name, String surname, String mail, String password, int tipoPersona, String unit) {
		super(name, surname, mail, password, tipoPersona);
		this.unit = unit;
	}


}

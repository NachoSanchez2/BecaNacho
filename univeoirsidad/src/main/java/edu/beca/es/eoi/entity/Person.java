package edu.beca.es.eoi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
	private int id;
	private String name;
	private String surname;
	private String dni;
	private String mail;
	private String username;
	private String password;
	private int tipoPersona;

	public Person(String name, String surname, String dni, String mail, String username, String password,
			int tipoPersona) {

		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.tipoPersona = tipoPersona;
	}

	public Person(String username) {
		this.username = username;
	}

	public Person(String name, String surname, String mail, String password, int tipoPersona) {
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.tipoPersona = tipoPersona;

	}

}

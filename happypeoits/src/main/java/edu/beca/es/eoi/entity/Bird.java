package edu.beca.es.eoi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Bird extends Pet {

	private String colour;
	private int idPet;

	public Bird(String name, String location, String description, int typepet, String photo, String colour, int idPet) {
		super(name, location, description, typepet, photo);

		this.colour = colour;
		this.idPet = idPet;

	}

	public Bird(String colour, int idPet) {
		super();
		this.colour = colour;
		this.idPet = idPet;
	}
}

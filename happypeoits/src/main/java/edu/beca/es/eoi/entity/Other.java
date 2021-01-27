package edu.beca.es.eoi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Other extends Pet {

	private String type;
	private int idPet;

	public Other(String name, String location, String description, int typepet, String photo, String type, int idPet) {
		super(name, location, description, typepet, photo);
		this.type = type;
		this.idPet = idPet;
	}

	public Other(String type, int idPet) {
		super();
		this.type = type;
		this.idPet = idPet;
	}
}

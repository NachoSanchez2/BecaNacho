package edu.beca.es.eoi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cat extends Pet {

	private int age;
	private int idPet;

	public Cat(String name, String location, String description, int typepet, String photo, int age, int idPet) {
		super(name, location, description, typepet, photo);
		this.age = age;
		this.idPet = idPet;
	}

	public Cat(int age, int idPet) {
		super();
		this.age = age;
		this.idPet = idPet;
	}
}

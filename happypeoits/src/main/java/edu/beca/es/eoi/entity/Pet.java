package edu.beca.es.eoi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Pet {

	private int id;
	private String name;
	private String location;
	private String description;
	private int typepet;
	private String photo;
	private Owner owner;
	private Dog dog;
	private Cat cat;
	private Bird bird;
	private Other other;

	public Pet(String name, String location, String description, int typepet, String photo) {
		this.name = name;
		this.location = location;
		this.description = description;
		this.typepet = typepet;
		this.photo = photo;
	}

	public Pet(String name, String location, String description, int typepet, String photo, Owner owner, Dog dog) {
		this.name = name;
		this.location = location;
		this.description = description;
		this.typepet = typepet;
		this.photo = photo;
		this.owner = owner;
		this.dog = dog;
	}

	public Pet(String name, String location, String description, int typepet, String photo, Owner owner, Cat cat) {
		this.name = name;
		this.location = location;
		this.description = description;
		this.typepet = typepet;
		this.photo = photo;
		this.owner = owner;
		this.cat = cat;
	}

	public Pet(String name, String location, String description, int typepet, String photo, Owner owner, Bird bird) {
		this.name = name;
		this.location = location;
		this.description = description;
		this.typepet = typepet;
		this.photo = photo;
		this.owner = owner;
		this.bird = bird;
	}

	public Pet(String name, String location, String description, int typepet, String photo, Owner owner, Other other) {
		this.name = name;
		this.location = location;
		this.description = description;
		this.typepet = typepet;
		this.photo = photo;
		this.owner = owner;
		this.other = other;
	}

}

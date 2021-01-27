package edu.beca.es.eoi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypePets {
	DOG(1, "PERRO"), CAT(2, "GATO"), BIRD(3, "PAJARO"), OTHER(4, "OTRO");

	private int intValue;
	private String typePet;
}

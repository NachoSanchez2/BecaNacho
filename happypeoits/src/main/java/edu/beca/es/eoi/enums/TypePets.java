package edu.beca.es.eoi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypePets {
	DOG(1), CAT(2), BIRD(3), OTHER(4);

	private int intValue;
}

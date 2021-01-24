package edu.beca.es.eoi.djeoiEntity;

import org.jfugue.pattern.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Voice {
	private Pattern voice;
	private String name;
}

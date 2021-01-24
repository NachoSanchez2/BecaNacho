package edu.beca.es.eoi.djeoiEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Chords {
	MAJOR(1, "maj"), MINOR(2, "min"), AUGMENTED(3, "aug"), DIMINISHED(4, "dim"), SEVENTH(5, "dom7"),
	MAJOR7TH(6, "maj7"), MINOR7TH(7, "min7"), SUSPENDED4TH(8, "sus4"), SUSPENDED2TH(9, "sus2"), SIXTH(10, "maj6"),
	MINOR6TH(11, "min6"), NINTH(12, "dom9"), MAJOR9TH(13, "maj9"), MINOR9TH(14, "min9"), DIMISHED7TH(15, "dim7");

	private int key;
	private String value;

	public static String chordOptions(int userOption) {
		String chord = "";
		switch (userOption) {
		case 1:
			chord = Chords.MAJOR.getValue();
			break;
		case 2:
			chord = Chords.MINOR.getValue();
			break;
		case 3:
			chord = Chords.AUGMENTED.getValue();
			break;
		case 4:
			chord = Chords.DIMINISHED.getValue();
			break;
		case 5:
			chord = Chords.SEVENTH.getValue();
			break;
		case 6:
			chord = Chords.MAJOR7TH.getValue();
			break;
		case 7:
			chord = Chords.MINOR7TH.getValue();
			break;
		case 8:
			chord = Chords.SUSPENDED4TH.getValue();
			break;
		case 9:
			chord = Chords.SUSPENDED2TH.getValue();
			break;
		case 10:
			chord = Chords.SIXTH.getValue();
			break;
		case 11:
			chord = Chords.MINOR6TH.getValue();
			break;
		case 12:
			chord = Chords.NINTH.getValue();
			break;
		case 13:
			chord = Chords.MAJOR9TH.getValue();
			break;
		case 14:
			chord = Chords.MINOR9TH.getValue();
			break;
		case 15:
			chord = Chords.DIMISHED7TH.getValue();
		}
		return chord;
	}
}

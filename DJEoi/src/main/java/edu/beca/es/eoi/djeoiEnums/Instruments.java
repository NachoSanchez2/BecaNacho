package edu.beca.es.eoi.djeoiEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Instruments {
	PIANO(1, "PIANO"), BRIGHT_ACOUSTIC(2, "BRIGHT_ACOUSTIC"), CLAVINET(3, "CLAVINET"), CELESTINA(4, "CELESTINA"),
	MUSIC_BOX(5, "MUSIC_BOX"), MARIMBA(6, "MARIMBA"), XYLOPHONE(7, "XYLOPHONE"), TRUMPET(8, "TRUMPET"),
	TROMBONE(9, "TROMBONE"), TUBA(10, "TUBA"), OBOE(11, "OBOE"), CHOIR(12, "CHOIR"), MARACAS(13, "MARACAS"),
	CLARINET(14, "CLARINET"), VIOLIN(15, "VIOLIN"), VIOLA(16, "VIOLA"), CELLO(17, "CELLO"), BANJO(18, "BANJO"),
	GUITAR(19, "GUITAR"), STEEL_DRUMS(20, "STEEL_DRUMS"), BASS_DRUM(21, "BASS_DRUM"), HAND_CLAP(22, "HAND_CLAP"),
	CRASH_CYMBAL_1(23, "CRASH_CYMBAL_1"), PEDAL_HI_HAT(24, "PEDAL_HI_HAT"), ACOUSTIC_SNARE(25, "ACOUSTIC_SNARE");

	private int key;
	private String name;

	public static String instrumentsOptions(int userOption) {
		String instrument = "";
		switch (userOption) {
		case 1:
			instrument = Instruments.PIANO.getName();
			break;
		case 2:
			instrument = Instruments.BRIGHT_ACOUSTIC.getName();
			break;
		case 3:
			instrument = Instruments.CLAVINET.getName();
			break;
		case 4:
			instrument = Instruments.CELESTINA.getName();
			break;
		case 5:
			instrument = Instruments.MUSIC_BOX.getName();
			break;
		case 6:
			instrument = Instruments.MARIMBA.getName();
			break;
		case 7:
			instrument = Instruments.XYLOPHONE.getName();
			break;
		case 8:
			instrument = Instruments.TRUMPET.getName();
			break;
		case 9:
			instrument = Instruments.TROMBONE.getName();
			break;
		case 10:
			instrument = Instruments.TUBA.getName();
			break;
		case 11:
			instrument = Instruments.OBOE.getName();
			break;
		case 12:
			instrument = Instruments.CHOIR.getName();
			break;
		case 13:
			instrument = Instruments.MARACAS.getName();
			break;
		case 14:
			instrument = Instruments.CLARINET.getName();
			break;
		case 15:
			instrument = Instruments.VIOLIN.getName();
			break;
		case 16:
			instrument = Instruments.VIOLA.getName();
			break;
		case 17:
			instrument = Instruments.CELLO.getName();
			break;
		case 18:
			instrument = Instruments.BANJO.getName();
			break;
		case 19:
			instrument = Instruments.GUITAR.getName();
			break;
		case 20:
			instrument = Instruments.STEEL_DRUMS.getName();
			break;
		case 21:
			instrument = Instruments.BASS_DRUM.getName();
			break;
		case 22:
			instrument = Instruments.HAND_CLAP.getName();
			break;
		case 23:
			instrument = Instruments.CRASH_CYMBAL_1.getName();
			break;
		case 24:
			instrument = Instruments.PEDAL_HI_HAT.getName();
			break;
		case 25:
			instrument = Instruments.ACOUSTIC_SNARE.getName();
			break;
		default:
			instrument = Instruments.PIANO.getName();
			break;
		}
		return instrument;
	}
}

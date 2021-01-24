package edu.beca.es.eoi.djeoiUI;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.djeoiController.VoiceController;
import edu.beca.es.eoi.djeoiEntity.Voice;
import edu.beca.es.eoi.djeoiEnums.Chords;
import edu.beca.es.eoi.djeoiEnums.Instruments;
import edu.beca.es.eoi.djeoiMain.MainDj;

public class VoiceMenu {
	// Configuration: Logger, Scanners and Controller
	private static final Logger logger = Logger.getLogger(MainDj.class);
	private static final Scanner INTEGERSCANNER = new Scanner(System.in);
	private static final Scanner STRINGSCANNER = new Scanner(System.in);
	private static final VoiceController VOICECONTROLLER = new VoiceController();

	// Constant
	private static final int STEEL_DRUMS = 1;
	private static final int BASS_DRUM = 2;
	private static final int HAND_CLAP = 3;
	private static final int CRASH_CYBAL = 4;
	private static final int PEDAL_HI_HAT = 5;
	private static final int ACOUSTIC_SNARE = 6;

	private static final int CHORDLIST = 1;
	private static final int COMPOSITECHORD = 2;

	// Global variable declaration
	private static String instrument;

	public void instrumentSelection() {
		logger.info("Entramos en el menu de creacion de voz y elegimos un instrumento");
		// Declaration
		Instruments[] instruments = Instruments.values();
		int counter = 0;
		String showInstruments;
		int userOption = 0;

		// Menu
		System.out.println("    A continuación elegirás el instrumento que tocara tu voz     ");
		System.out.println(" * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");

		// Implementation
		do {
			for (int j = 0; j < 5; j++) {

				if (Integer.toString(instruments[counter].getKey()).length() < 2) {
					showInstruments = "0".concat(Integer.toString(instruments[counter].getKey())
							.concat(".-".concat(instruments[counter].getName().concat("     "))));
				} else {
					showInstruments = Integer.toString(instruments[counter].getKey())
							.concat(".-".concat(instruments[counter].getName().concat("     ")));
				}
				System.out.print(showInstruments);
				counter++;
			}
			System.out.println();
		} while (counter < 25);

		try {
			userOption = INTEGERSCANNER.nextInt();
		} catch (InputMismatchException e) {
			logger.debug("Se ha introducido mal un valor: " + e.getStackTrace());
			System.out.println("Por favor, introduce un valor correcto");
			instrumentSelection();
		}
		try {
			VOICECONTROLLER.selectInstrument(userOption);
			System.out.println("Se ha establecido correctamente el instrumento");
		} catch (Exception e) {
			logger.debug("No se ha establecido correctamente el instrumento" + e.getStackTrace());
			System.out.println("No se ha podido establecer el instrumento, vuelvalo a intentar");
			instrumentSelection();
		}

	}

	public void makeRithm() {
		logger.info("Entramos en el menu de creacion de voz ritmica");
		// Declaration
		String rithm = "";
		String value = "";
		int userOption = 0;

		// Menu
		System.out.println("A continuación vas a elegir un ritmo que acompañara a tu melodia");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
		System.out.println("Primero elige el instrumento");
		System.out.println(" 1.- Toms aereos\n" + " 2.- Bombo\n" + " 3.- Palmada\n" + " 4.- Platillo ride\n"
				+ " 5.- Platillo hi hat\n" + " 6.- Caja");

		try {
			userOption = INTEGERSCANNER.nextInt();
			logger.debug("El usuario ha elegido el valor: " + userOption);
		} catch (InputMismatchException e) {
			logger.debug("No se ha introducido correctamente el valor: " + e.getStackTrace());
			System.out.println("El valor introducido no es correcto, por favor vuelva a intentarlo");
			makeRithm();
		}
		switch (userOption) {
		case STEEL_DRUMS:
			value = "o";
			break;
		case BASS_DRUM:
			value = "O";
			break;
		case HAND_CLAP:
			value = "X";
			break;
		case CRASH_CYBAL:
			value = "+";
			break;
		case PEDAL_HI_HAT:
			value = "'";
			break;
		case ACOUSTIC_SNARE:
			value = "S";
			break;
		}

		System.out.println(
				"Es hora de elegir el ritmo, escriba con la letra O la voz ritmica que desee, recuerde que un espaci es un silencio");
		rithm = STRINGSCANNER.nextLine();
		logger.debug("Se valida la opcion del usuario " + rithm);
		try {
			rithm = VOICECONTROLLER.rithmVerification(rithm);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			System.out.println("Por favor, es importante que el caracter que use sea la O, vuélvalo a intentar");
		}
		logger.debug(
				"Se transforma o traduce el MusicString del usuario para que pueda entenderlo el programa: " + rithm);
		try {
			VOICECONTROLLER.makeRithm(value, rithm);
		} catch (Exception e) {
			logger.debug("Se ha producido un error" + e.getStackTrace());
			System.out.println("Se ha producido un error, por favor inténtelo de nuevo");
			makeRithm();
		}

	}

	public void chordMenu() {
		logger.info("Se entra en la opcion menu acordes");
		int userOption = 0;
		System.out.println("Puedes elegir un acorde de entre los que ya hay, o si lo prefieres puedes crear uno");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("   1.- Ver lista de acordes \n" + "   2.- Componer acorde");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

		try {
			userOption = INTEGERSCANNER.nextInt();
		} catch (InputMismatchException e) {
			logger.debug("Se ha introducido mal un valor: " + e.getStackTrace());
			System.out.println("Por favor, introduce un valor correcto");
			instrumentSelection();
		}
		switch (userOption) {
		case CHORDLIST:
			chordsList();
			break;
		case COMPOSITECHORD:
			makeChord();
			break;
		}
	}

	public void makeChord() {
		System.out.println("Para poder crear un acorde, debe introducir una cadena de valores del teclado\n"
				+ "para que puedan sonar juntas, ha de añadir un + a la cadena en vez de un espacio\n"
				+ "de la letra Q a la U para añadir notas con dos tempos(Blancas)\n"
				+ "de la letra A a la J para añadir notas con un tempo(Negra)\n"
				+ "de la letra Z a la M para añadir notas con medio tempo(Corchea)");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
		String userComposition = STRINGSCANNER.nextLine();
		String translatedUserComposition = VOICECONTROLLER.translateKeyboard(userComposition);
		if (userComposition != null) {
			if (instrument != null) {
				String chord = VOICECONTROLLER.makeChords(translatedUserComposition);
				logger.debug("Se ha compuesto el acorde: " + chord);
				System.out.println("El acorde que ha compuesto es: " + chord);
			}
		}

	}

	public void chordsList() {
		logger.info("Se entra en la opcion, acordes");
		Chords[] chords = Chords.values();
		int counter = 0;
		String showChords;
		int userOption = 0;

		// Menu
		System.out.println("Elige un acorde");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * *");

		// Implementation
		do {
			for (int j = 0; j < 5; j++) {

				if (Integer.toString(chords[counter].getKey()).length() < 2) {
					showChords = "0".concat(Integer.toString(chords[counter].getKey())
							.concat(".-".concat(chords[counter].getValue().concat("     "))));
				} else {
					showChords = Integer.toString(chords[counter].getKey())
							.concat(".-".concat(chords[counter].getValue().concat("     ")));
				}
				System.out.print(showChords);
				counter++;
			}
			System.out.println();
		} while (counter < 15);

		try {
			userOption = INTEGERSCANNER.nextInt();
		} catch (InputMismatchException e) {
			logger.debug("Se ha introducido mal un valor: " + e.getStackTrace());
			System.out.println("Por favor, introduce un valor correcto");
			chordsList();
		}
		String chord = VOICECONTROLLER.makeChords(Chords.chordOptions(userOption));
		System.out.println("El acorde que ha elegido es: " + chord);
	}

	public void compositeVoice() {
		System.out.println("Para poder componer una voz, debe introducir una cadena de valores del teclado\n"
				+ "de la letra Q a la U para añadir notas con dos tempos(Blancas)\n"
				+ "de la letra A a la J para añadir notas con un tempo(Negra)\n"
				+ "de la letra Z a la M para añadir notas con medio tempo(Corchea)");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
		String userComposition = STRINGSCANNER.nextLine();
		String translatedUserComposition = VOICECONTROLLER.translateKeyboard(userComposition);
		if (translatedUserComposition != null) {
			Voice voice = VOICECONTROLLER.freeComposition(translatedUserComposition);
			logger.debug("Se ha compuesto la voz " + voice.getName() + " = " + voice.getVoice().toString());
			System.out.println(
					"Se ha compuesto la voz " + voice.getName() + " ha quedado así: " + voice.getVoice().toString());
		}
	}

	public void deleteVoice() {
		for (String voiceName : VoiceController.voices.keySet()) {
			System.out.print("NOMBRE: ".concat(
					voiceName.concat("  VALOR: ".concat(VoiceController.voices.get(voiceName).getVoice().toString()))));
		}
		System.out.println("Cual es el nombre de la voz que quieres eliminar?");
	}

	public void saveSong(String songName) throws Exception {
		VOICECONTROLLER.saveSong(songName);
	}
}

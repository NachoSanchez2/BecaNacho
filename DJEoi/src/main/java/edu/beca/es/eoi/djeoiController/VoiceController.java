package edu.beca.es.eoi.djeoiController;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.djeoiEntity.Voice;
import edu.beca.es.eoi.djeoiEnums.Instruments;
import edu.beca.es.eoi.djeoiService.SongService;
import edu.beca.es.eoi.djeoiService.VoiceService;
import edu.beca.es.eoi.djeoiServiceImpl.SongServiceImpl;
import edu.beca.es.eoi.djeoiServiceImpl.VoiceServiceImpl;

public class VoiceController {
	// Configurations, menu and logger
	public static final VoiceService VOICESERVICE = new VoiceServiceImpl();
	public static final SongService SONGSERVICE = new SongServiceImpl();
	private static final Logger logger = Logger.getLogger(VoiceController.class);

	// Global variables declaration
	public static Map<String, Voice> voices = new TreeMap<String, Voice>();
	public static String instrument;
	public static int index = 1;

	public boolean selectInstrument(int userOption) throws Exception {
		logger.info("Se entra en el metodo selectInstrument Controller");
		boolean instrumentOK = false;
		instrument = Instruments.instrumentsOptions(userOption);
		logger.debug(instrument);
		if (instrument != null) {
			instrumentOK = true;
		} else {
			throw new Exception("No se ha establecido el instrumento");
		}
		return instrumentOK;
	}

	public boolean makeRithm(String value, String rithmVoice) {
		logger.info("Se entra en el menu makeRithm y se junta con el instrumento");
		String parsedRithm = rithmVoice.replace('O', value.charAt(0)).replace(' ', '.');
		String voiceName = "V9";
		String voiceValue = "".concat(" ".concat(voiceName.concat(" ".concat(parsedRithm))));
		Voice rithm = VOICESERVICE.makeVoice(voiceName, voiceValue);

		if (rithm != null) {
			voices.put(voiceName, rithm);
			return true;
		} else {
			return false;
		}

	}

	public String rithmVerification(String rithmVoice) throws Exception {
		String voice = "";
		for (char letter : rithmVoice.toCharArray()) {
			if ("O".equals(Character.toString(letter))) {
				return rithmVoice;
			} else {
				throw new Exception("Se ha introducido otro caracter que no es la O");
			}
		}
		return voice;
	}

	public String makeChords(String userComposition) {
		logger.info(
				"Se entra en el menu makeChords del controlador que añade el instrumento seleccionado y lo junta todo en una voz");
		String chordedUserComposition = " ";
		for (int i = 0; i < userComposition.length(); i++) {
			chordedUserComposition = userComposition.trim();
			chordedUserComposition = chordedUserComposition.replace(' ', '+');
		}
		String chord = "i".concat("[".concat(instrument).concat("]")).concat(" ".concat(chordedUserComposition));
		String voiceName = "V2";
		Voice voice = VOICESERVICE.makeVoice(voiceName, chord);
		voices.put(voiceName, voice);
		logger.debug("Se sale del metodo y se guarda la voz en el mapa de voces: " + voice.getName() + " "
				+ voice.getVoice());
		return chord;
	}

	public Voice freeComposition(String userComposition) {
		String userCompositionParsed = "i".concat("[".concat(instrument).concat("] ").concat(userComposition));
		String voiceName = "V".concat(Integer.toString(index));
		String voiceComposition = "".concat(voiceName.concat(userCompositionParsed));
		Voice voice = VOICESERVICE.makeVoice(voiceName, voiceComposition);
		index++;
		voices.put(voiceName, voice);
		return voice;
	}

	public boolean deleteVoice(String voiceName) {
		boolean deleteOK = false;
		for (String voice : voices.keySet()) {
			if (voice.equalsIgnoreCase(voiceName)) {
				voices.remove(voice);
				deleteOK = true;
			}
		}
		return deleteOK;
	}

	public boolean saveSong(String songName) throws Exception {
		boolean saveOK = false;
		if (voices != null) {
			SONGSERVICE.save(voices, songName);
			saveOK = true;
		} else {
			throw new Exception("No hay ninguna voz insertada, por favor introduzca por lo menos una");
		}
		return saveOK;
	}

	public String translateKeyboard(String userComposition) {
		logger.info("Entra en el metodo traducir VoiceController");
		String upperUserComposition = userComposition.toUpperCase();
		String[] letterIteratorArray = new String[userComposition.length()];
		StringBuffer stringBuffer = new StringBuffer();
		String translatedUserComposition = " ";

		logger.info(
				"Se crea un substric de cada caracter de la composicion del usuario y se elimina del array si no esta dentro del rango de caracteres permitidos");
		for (int i = 0; i < letterIteratorArray.length; i++) {
			letterIteratorArray[i] = upperUserComposition.substring(i, i + 1);

		}

		for (int i = 0; i < letterIteratorArray.length; i++) {
			if ("Q".equals(letterIteratorArray[i].toString()) || "W".equals(letterIteratorArray[i].toString())
					|| "E".equals(letterIteratorArray[i].toString()) || "R".equals(letterIteratorArray[i].toString())
					|| "T".equals(letterIteratorArray[i].toString()) || "Y".equals(letterIteratorArray[i].toString())
					|| "U".equals(letterIteratorArray[i].toString())) {
				letterIteratorArray[i] = traduceFirstRow(letterIteratorArray[i].toString());
			} else if ("A".equals(letterIteratorArray[i].toString()) || "S".equals(letterIteratorArray[i].toString())
					|| "D".equals(letterIteratorArray[i].toString()) || "F".equals(letterIteratorArray[i].toString())
					|| "G".equals(letterIteratorArray[i].toString()) || "H".equals(letterIteratorArray[i].toString())
					|| "J".equals(letterIteratorArray[i].toString())) {
				letterIteratorArray[i] = traduceSecondRow(letterIteratorArray[i].toString());
			} else if ("Z".equals(letterIteratorArray[i].toString()) || "X".equals(letterIteratorArray[i].toString())
					|| "C".equals(letterIteratorArray[i].toString()) || "V".equals(letterIteratorArray[i].toString())
					|| "B".equals(letterIteratorArray[i].toString()) || "N".equals(letterIteratorArray[i].toString())
					|| "M".equals(letterIteratorArray[i].toString())) {
				letterIteratorArray[i] = traduceThirdRow(letterIteratorArray[i].toString());
			}
		}

		for (int i = 0; i < letterIteratorArray.length; i++) {
			translatedUserComposition = stringBuffer.append(letterIteratorArray[i]).toString();
		}

		logger.debug("Se recorre el valor introducido por el usuario: " + translatedUserComposition
				+ " y se sustitye por la traduccion de JFUGUE");
		return translatedUserComposition;
	}

	private String traduceFirstRow(String letterIterator) {
		if ("Q".equals(letterIterator)) {
			letterIterator = "Cw";
		} else if ("W".equals(letterIterator)) {
			letterIterator = "Dw";
		} else if ("E".equals(letterIterator)) {
			letterIterator = "Ew";
		} else if ("R".equals(letterIterator)) {
			letterIterator = "Fw";
		} else if ("T".equals(letterIterator)) {
			letterIterator = "Gw";
		} else if ("Y".equals(letterIterator)) {
			letterIterator = "Aw";
		} else if ("U".equals(letterIterator)) {
			letterIterator = "Bw";
		}
		return letterIterator;
	}

	private String traduceSecondRow(String letterIterator) {
		if ("A".equals(letterIterator)) {
			letterIterator = "Ch";
		} else if ("S".equals(letterIterator)) {
			letterIterator = "Dh";
		} else if ("D".equals(letterIterator)) {
			letterIterator = "Eh";
		} else if ("F".equals(letterIterator)) {
			letterIterator = "Fh";
		} else if ("G".equals(letterIterator)) {
			letterIterator = "Gh";
		} else if ("H".equals(letterIterator)) {
			letterIterator = "Ah";
		} else if ("J".equals(letterIterator)) {
			letterIterator = "Bh";
		}
		return letterIterator;
	}

	private String traduceThirdRow(String letterIterator) {
		if ("Z".equals(letterIterator)) {
			letterIterator = "Ch";
		} else if ("X".equals(letterIterator)) {
			letterIterator = "Dh";
		} else if ("C".equals(letterIterator)) {
			letterIterator = "Eh";
		} else if ("V".equals(letterIterator)) {
			letterIterator = "Fh";
		} else if ("B".equals(letterIterator)) {
			letterIterator = "Gh";
		} else if ("B".equals(letterIterator)) {
			letterIterator = "Ah";
		} else if ("N".equals(letterIterator)) {
			letterIterator = "Bh";
		}
		return letterIterator;
	}
}

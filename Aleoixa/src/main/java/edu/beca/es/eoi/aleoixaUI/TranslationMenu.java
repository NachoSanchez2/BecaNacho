package edu.beca.es.eoi.aleoixaUI;

import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.aleoixaControllers.TranslateController;
import edu.beca.es.eoi.aleoixaMain.AleoixaMainApp;

public class TranslationMenu {

	private static final Scanner ESCANER = new Scanner(System.in);
	private static final TranslateController CONTROLLER = new TranslateController();
	static Logger logger = Logger.getLogger(AleoixaMainApp.class);

	public void printTranslationMenu() {
		System.out.println("¿Qué palabra quiere traducir?");
		String userOption = ESCANER.nextLine();
		String translatedWord = "";

		try {
			translatedWord = CONTROLLER.translateWord(userOption);
		} catch (Exception e) {
			logger.debug("Ha habido un error o no se ha encontrado la palabra");
			System.out.println("Por favor, vuelva a intentarlo");
			e.printStackTrace();
			printTranslationMenu();
		}
		System.out.println("La traduccion a la palabra ".concat(userOption.concat(" es: ".concat(translatedWord))));
	}

}

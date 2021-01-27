package edu.beca.es.eoi.main;

import edu.beca.es.eoi.UIConsole.MainMenu;
import lombok.extern.log4j.Log4j;

@Log4j
public class MainHappyPeoits {

	private static final MainMenu MAINMENU = new MainMenu();

	public static void main(String[] args) {
		log.info("Se enciende la aplicacion");
		MAINMENU.printMenuMain();
		log.info("Se sale de la aplicacion");
	}

}

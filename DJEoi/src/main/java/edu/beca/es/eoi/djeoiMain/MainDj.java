package edu.beca.es.eoi.djeoiMain;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.djeoiUI.MainMenu;

public class MainDj {
	private static final Logger logger = Logger.getLogger(MainDj.class);
	private static final MainMenu MENU = new MainMenu();

	public static void main(String[] args) {
		logger.info("Se enciende la aplicacion");
		MENU.printMenuMain();
		logger.info("Se apaga la aplicacion");

	}
}

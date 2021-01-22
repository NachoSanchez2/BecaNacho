package edu.beca.es.eoi.main;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.UI.MainMenu;

public class MainJavaApp {
	private static final Logger logger = Logger.getLogger(MainJavaApp.class);
	private static final MainMenu MENU = new MainMenu();

	public static void main(String[] args) {

		logger.info("Enciendo la app");
		MENU.printMenuMain();
		logger.info("Apago la app");
	}

}

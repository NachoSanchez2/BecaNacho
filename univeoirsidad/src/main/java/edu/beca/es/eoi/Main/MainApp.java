package edu.beca.es.eoi.Main;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.UI.MenuPrincipal;

public class MainApp {
	private static final Logger logger = Logger.getLogger(MainApp.class);
	private static final MenuPrincipal MENU = new MenuPrincipal();

	public static void main(String[] args) {
		logger.info("Se inicia la aplicacion");
		MENU.printMainMenu();
		System.out.println("ADIOS, VUELVE CUANDO QUIERAS");
		logger.info("Se apaga la aplicacion");
	}

}

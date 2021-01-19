package edu.beca.es.eoi.aleoixaMain;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.aleoixaUI.MenuPrincipal;

public class AleoixaMainApp {

	static Logger logger = Logger.getLogger(AleoixaMainApp.class);
	private static final MenuPrincipal MENUPRINCIPAL = new MenuPrincipal();

	public static void main(String[] args) {
		logger.info("Se inicia la app");
		MENUPRINCIPAL.printMenuPrincipal();
		logger.info("Se cierra la app");
	}

}

package edu.beca.es.eoi.aleoixaMain;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class AleoixaMainApp {

	static Logger logger = Logger.getLogger(AleoixaMainApp.class);
	public static final Scanner ESCANER = new Scanner(System.in);

	public static void main(String[] args) {
		logger.info("Se inicia la app");
		System.out.println("Bienvenido al asistente ALEOIXA");
		System.out.println("¿En que puedo ayudarle?");
		String userOption = ESCANER.nextLine();
		
		
		logger.info("Se cierra la app");
	}

}

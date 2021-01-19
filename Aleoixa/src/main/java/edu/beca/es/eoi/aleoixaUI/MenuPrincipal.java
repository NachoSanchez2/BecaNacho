package edu.beca.es.eoi.aleoixaUI;

import java.util.Scanner;

import edu.beca.es.eoi.aleoixaControllers.MainController;

public class MenuPrincipal {
	public static final Scanner ESCANER = new Scanner(System.in);
	public static final MainController CONTROLLER = new MainController();

	public void printMenuPrincipal() {
		boolean salirOK = false;

		do {
			System.out.println("Bienvenido al asistente ALEOIXA");
			System.out.println("¿En que puedo ayudarle?");
			String userOption = ESCANER.nextLine();
			CONTROLLER.mainController(userOption);
			if (userOption.equalsIgnoreCase("salir")) {
				salirOK = true;
			}
		} while (!salirOK);
	}

}
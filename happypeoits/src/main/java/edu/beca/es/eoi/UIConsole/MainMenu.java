package edu.beca.es.eoi.UIConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.extern.log4j.Log4j;

@Log4j
public class MainMenu {
	// Configuration and anothers menus
	private static final Scanner INTEGERSCANNER = new Scanner(System.in);
	private static final PetMenu PETMENU = new PetMenu();

	// Constants
	private static final int PETREGISTER = 1;
	private static final int SEARCHPET = 2;
	private static final int UPLOADPET = 3;
	private static final int DELETEPET = 4;
	private static final int MAKEINFORMS = 5;
	private static final int EXIT = 6;

	public void printMenuMain() {
		log.info("Se entra en el menu principal");

		// Variables declaration
		int userOption = 0;
		boolean exitOK = false;

		do {
			System.out.println("Bienvenido a la app de adopcion de animales");
			System.out.println("* * * * * * * * * * * * * * * * * * * * * *");
			System.out.println(" 1.- Dar de alta a un mascota \n" + " 2.- Buscar mascota \n"
					+ " 3.- Modificar mascota \n" + " 4.- Eliminar mascota \n" + " 5.- Elabora informe" + " 6.- SALIR");

			try {
				userOption = INTEGERSCANNER.nextInt();
			} catch (InputMismatchException e) {
				log.debug("Se ha introducido un mal caracter " + userOption + e.getStackTrace());
				System.out.println("El valor introducido no es correcto, por favor vuelva a intentarlo");
				printMenuMain();
			}
			switch (userOption) {
			case PETREGISTER:
				PETMENU.printPetMenu();
				break;
			case SEARCHPET:
				PETMENU.searchPetMenu();
				break;
			case UPLOADPET:
				PETMENU.uploadPetMenu();
				break;
			case DELETEPET:
				PETMENU.deletePetMenu();
				break;
			case MAKEINFORMS:
				System.out.println("No se ha podido implementar este servicio");
				break;
			case EXIT:
				exitOK = true;
				System.out.println("Vuelva cuando quiera, CHAU");
			}
		} while (!exitOK);
	}

}

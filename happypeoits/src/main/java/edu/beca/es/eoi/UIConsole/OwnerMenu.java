package edu.beca.es.eoi.UIConsole;

import java.util.Scanner;

import edu.beca.es.eoi.controller.OwnerController;
import lombok.extern.log4j.Log4j;

@Log4j
public class OwnerMenu {
	// Scanners, controller and another menu;
	private static final Scanner STRINGSCANNER = new Scanner(System.in);
	private static final OwnerController CONTROLLER = new OwnerController();
	private static final PetMenu PETMENU = new PetMenu();

	public void printMenuOwner(int idPet) {
		System.out.println("Que, bien el problema estará en porque quieren darlo en adopcion");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * ** * * * * *");
		System.out.println("Indique el nombre del dueño");
		String ownername = STRINGSCANNER.nextLine();
		System.out.println("Por favor, indique un número de contacto");
		String phone = STRINGSCANNER.nextLine();

		try {
			CONTROLLER.saveOwner(ownername, phone, idPet);
		} catch (Exception e) {
			log.debug(e.getMessage());
			System.out.println(e.getMessage());
			PETMENU.printPetMenu();
		}

		STRINGSCANNER.close();
	}
}

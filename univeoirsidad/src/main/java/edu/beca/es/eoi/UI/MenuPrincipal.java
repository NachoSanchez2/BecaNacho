package edu.beca.es.eoi.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class MenuPrincipal {
	private static final Logger logger = Logger.getLogger(MenuPrincipal.class);
	private static final Scanner ESCANERENTEROS = new Scanner(System.in);

	private static final int SAVE = 1;
	private static final int READ = 2;
	private static final int UPDATE = 3;
	private static final int DELETE = 4;
	private static final int EXIT = 5;

	private static final MenuDarAlta SAVEMENU = new MenuDarAlta();
	private static final MenuBuscar READMENU = new MenuBuscar();
	private static final MenuModificar UPDATEMENU = new MenuModificar();
	private static final MenuBorrar DELETEMENU = new MenuBorrar();

	public void printMainMenu() {
		logger.info("Se entra en el menuPrincipal");
		boolean exitOK = false;
		do {
			System.out.println("Bienvenido al gestor de universidad");
			System.out.println("* * * * * * * * * * * * * * * * * *");
			System.out.println("   1.- Dar de alta un usuario      \n" + "   2.- Buscar un usuario           \n"
					+ "   3.- Modificar un usuario        \n" + "   4.- Borrar un usuario           \n"
					+ "   5.- Salir                       ");
			System.out.println("* * * * * * * * * * * * * * * * * *");
			int userOption = 0;

			try {
				userOption = ESCANERENTEROS.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("El valor introducido no es correcto, por favor vuelvalo a intentar");
				e.printStackTrace();
				printMainMenu();
			}
			switch (userOption) {
			case SAVE:
				SAVEMENU.printMenuDarAlta();
				break;
			case READ:
				READMENU.printMenuBuscar();
				break;
			case UPDATE:
				UPDATEMENU.printMenuModificar();
				break;
			case DELETE:
				DELETEMENU.printMenuBorrar();
				break;
			case EXIT:
				exitOK = true;
				break;
			}
		} while (!exitOK);
		ESCANERENTEROS.close();
	}
}

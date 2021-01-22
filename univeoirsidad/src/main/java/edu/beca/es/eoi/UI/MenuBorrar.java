package edu.beca.es.eoi.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.controller.PersonController;

public class MenuBorrar {

	private static final MenuPrincipal MENU = new MenuPrincipal();

	private static final PersonController PERSONCONTROLLER = new PersonController();
	private static final Logger logger = Logger.getLogger(MenuBorrar.class);

	private static final Scanner ESCANERSTRINGS = new Scanner(System.in);
	private static final Scanner ESCANERENTEROS = new Scanner(System.in);

	private static final int USERNAME = 1;
	private static final int DNI = 2;

	public void printMenuBorrar() {
		logger.info("Se entra en el menu Borrar");
		System.out.println("   Bienvenido al deleteator   ");
		System.out.println("* * * * * * * * * * * * * * * *");
		System.out.println("   1.- Borrar por usuario   \n" + "   2.- Borrar por dni       ");
		System.out.println("* * * * * * * * * * * * * * * *");
		int userOption = 0;
		try {
			userOption = ESCANERENTEROS.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("El valor que ha introducido no es correcto, por favor vuelva a intentarlo");
			printMenuBorrar();
		}
		switch (userOption) {
		case USERNAME:
			deleteByUsername();
			break;
		case DNI:
			deleteByDni();
			break;

		}

		ESCANERENTEROS.close();
		ESCANERSTRINGS.close();
	}

	public void deleteByUsername() {
		System.out.print("Introduzca el usuario: ");
		String username = ESCANERSTRINGS.nextLine();
		try {
			logger.debug("Se introduce el usuario " + username);
			PERSONCONTROLLER.deleteByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("El usuario que intenta eliminar no se encuentra, vuelvalo a intentar");
			MENU.printMainMenu();

		}
	}

	public void deleteByDni() {
		System.out.print("Introduzca el dni del usuario: ");
		String dni = ESCANERSTRINGS.nextLine();
		try {
			logger.debug("Se introduce el dni " + dni);
			PERSONCONTROLLER.deleteByDni(dni);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("El usuario que intenta eliminar no se encuentra, vuelvalo a intentar");
			MENU.printMainMenu();

		}
	}
}

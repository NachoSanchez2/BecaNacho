package edu.beca.es.eoi.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.beca.es.eoi.controller.PersonController;
import edu.beca.es.eoi.entity.Pas;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.Professor;
import edu.beca.es.eoi.entity.Student;

public class MenuBuscar {
	private static final PersonController PERSONCONTROLLER = new PersonController();
	private static final MenuPrincipal MENU = new MenuPrincipal();

	private static final int STUDENT = 1;
	private static final int PROFESSOR = 2;
	private static final int PAS = 3;

	private static final Scanner ESCANERSTRINGS = new Scanner(System.in);
	private static final Scanner ESCANERENTEROS = new Scanner(System.in);

	private static final int USERNAME = 1;
	private static final int DNI = 2;

	public void printMenuBuscar() {
		System.out.println("   Bienvenido al buscador   ");
		System.out.println("* * * * * * * * * * * * * * ");
		System.out.println("   1.- Buscar por usuario   " + "\n   2.- Buscar por dni       ");
		System.out.println("* * * * * * * * * * * * * * ");
		int userOption = 0;
		try {
			userOption = ESCANERENTEROS.nextInt();
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.out.println("El valor introducido no es correcto, por favor, vuelva a intentarlo");
			printMenuBuscar();
		}
		switch (userOption) {
		case USERNAME:
			readByUsername();
			break;

		case DNI:
			readByDni();
			break;
		}
		ESCANERENTEROS.close();
		ESCANERSTRINGS.close();
	}

	public void readByUsername() {
		System.out.print("Introduzca el usuario: ");
		String username = ESCANERSTRINGS.nextLine();
		Person e = null;

		try {
			e = PERSONCONTROLLER.readByUsername(username);
		} catch (Exception e1) {
			System.out.println("No se encuentra el usuario que desea buscar");
			e1.printStackTrace();
			MENU.printMainMenu();
		}
		System.out.println(e.getName() + " " + e.getSurname() + " " + e.getDni() + " " + e.getMail() + ". ");
		if (e.getTipoPersona() == STUDENT) {
			System.out.println("FACULTAD: " + ((Student) e).getFaculty());
		} else if (e.getTipoPersona() == PROFESSOR) {
			System.out.println("OFICINA: " + ((Professor) e).getOffice());
		} else if (e.getTipoPersona() == PAS) {
			System.out.println("UNIDAD: " + ((Pas) e).getUnit());
		}
	}

	public void readByDni() {
		System.out.print("Introduzca el dni: ");
		String dni = ESCANERSTRINGS.nextLine();
		Person e = null;

		try {
			e = PERSONCONTROLLER.readByDni(dni);
		} catch (Exception e1) {
			System.out.println("No se encuentra el usuario que desea buscar");
			e1.printStackTrace();
			MENU.printMainMenu();
		}
		System.out.println(e.getName() + " " + e.getSurname() + " " + e.getUsername() + " " + e.getMail() + ". ");
		if (e.getTipoPersona() == STUDENT) {
			System.out.println("FACULTAD: " + ((Student) e).getFaculty());
		} else if (e.getTipoPersona() == PROFESSOR) {
			System.out.println("OFICINA: " + ((Professor) e).getOffice());
		} else if (e.getTipoPersona() == PAS) {
			System.out.println("UNIDAD: " + ((Pas) e).getUnit());
		}
	}

}

package edu.beca.es.eoi.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.controller.PasController;
import edu.beca.es.eoi.controller.ProfessorController;
import edu.beca.es.eoi.controller.StudentController;

public class MenuDarAlta {

	private static final Logger logger = Logger.getLogger(MenuDarAlta.class);

	private static final StudentController STUDENTCONTROLLER = new StudentController();
	private static final ProfessorController PROFESSORCONTROLLER = new ProfessorController();
	private static final PasController PASCONTROLLER = new PasController();

	private static final int STUDENT = 1;
	private static final int PROFESSOR = 2;
	private static final int PAS = 3;

	private static final Scanner ESCANERENTEROS = new Scanner(System.in);
	private static final Scanner ESCANERSTRINGS = new Scanner(System.in);
	private static final MenuPrincipal MENUPRINCIPAL = new MenuPrincipal();

	public void printMenuDarAlta() {
		logger.info("Se entra en el menu DAR DE ALTA");
		int userOption = 0;
		System.out.println(" Bienvenido al menu dar de ALTA ");
		System.out.println(" * * * * * * * * * * * * * * *  ");
		System.out.println("   1.- Dar de alta un alumno    " + "   2.- Dar de alta un profesor  "
				+ "   3.- Dar de alta un PAS       ");

		try {
			userOption = ESCANERENTEROS.nextInt();
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.out.println("El valor introducido no es correcto, intentelo de nuevo");
			printMenuDarAlta();
		}
		switch (userOption) {
		case STUDENT:
			registerStudent();
			break;

		case PROFESSOR:
			registerProfessor();
			break;
		case PAS:
			registerPas();
			break;
		}
		ESCANERENTEROS.close();
	}

	public void registerStudent() {
		System.out.println("NOMBRE");
		String name = ESCANERSTRINGS.nextLine();
		System.out.println("DNI");
		String dni = ESCANERSTRINGS.nextLine();
		System.out.println("APELLIDOS");
		String surname = ESCANERSTRINGS.nextLine();
		System.out.println("MAIL");
		String mail = ESCANERSTRINGS.nextLine();
		System.out.println("USERNAME");
		String username = ESCANERSTRINGS.nextLine();
		System.out.println("PASSWORD");
		String password = ESCANERSTRINGS.nextLine();
		System.out.println("FACULTY");
		String faculty = ESCANERSTRINGS.nextLine();

		try {
			logger.debug("Se introducen los datos del usuario que se va a guardar: " + name + "," + dni + "," + surname
					+ "," + mail + "," + username + "," + password + "," + faculty);
			STUDENTCONTROLLER.saveStudent(name, dni, surname, mail, username, password, STUDENT, faculty);
		} catch (Exception e) {
			MENUPRINCIPAL.printMainMenu();
			e.printStackTrace();
		}
	}

	public void registerProfessor() {
		System.out.println("NOMBRE");
		String name = ESCANERSTRINGS.nextLine();
		System.out.println("DNI");
		String dni = ESCANERSTRINGS.nextLine();
		System.out.println("APELLIDOS");
		String surname = ESCANERSTRINGS.nextLine();
		System.out.println("MAIL");
		String mail = ESCANERSTRINGS.nextLine();
		System.out.println("USERNAME");
		String username = ESCANERSTRINGS.nextLine();
		System.out.println("PASSWORD");
		String password = ESCANERSTRINGS.nextLine();
		System.out.println("OFICINA");
		String office = ESCANERSTRINGS.nextLine();

		try {
			logger.debug("Se introducen los datos del usuario que se va a guardar: " + name + "," + dni + "," + surname
					+ "," + mail + "," + username + "," + password + "," + office);
			PROFESSORCONTROLLER.saveProfessor(name, dni, surname, mail, username, password, PROFESSOR, office);
		} catch (Exception e) {
			MENUPRINCIPAL.printMainMenu();
			e.printStackTrace();
		}
	}

	public void registerPas() {
		System.out.println("NOMBRE");
		String name = ESCANERSTRINGS.nextLine();
		System.out.println("DNI");
		String dni = ESCANERSTRINGS.nextLine();
		System.out.println("APELLIDOS");
		String surname = ESCANERSTRINGS.nextLine();
		System.out.println("MAIL");
		String mail = ESCANERSTRINGS.nextLine();
		System.out.println("USERNAME");
		String username = ESCANERSTRINGS.nextLine();
		System.out.println("PASSWORD");
		String password = ESCANERSTRINGS.nextLine();
		System.out.println("UNIDAD");
		String unit = ESCANERSTRINGS.nextLine();

		try {
			logger.debug("Se introducen los datos del usuario que se va a guardar: " + name + "," + dni + "," + surname
					+ "," + mail + "," + username + "," + password + "," + unit);
			PASCONTROLLER.savePas(name, dni, surname, mail, username, password, PAS, unit);
		} catch (Exception e) {
			MENUPRINCIPAL.printMainMenu();
			e.printStackTrace();
		}
	}

}

package edu.beca.es.eoi.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.controller.PasController;
import edu.beca.es.eoi.controller.PersonController;
import edu.beca.es.eoi.controller.ProfessorController;
import edu.beca.es.eoi.controller.StudentController;
import edu.beca.es.eoi.entity.Pas;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.Professor;
import edu.beca.es.eoi.entity.Student;

public class MenuModificar {

	private static final MenuPrincipal MENU = new MenuPrincipal();
	private static final Logger logger = Logger.getLogger(MenuModificar.class);

	private static final PersonController PERSONCONTROLLER = new PersonController();
	private static final StudentController STUDENTCONTROLLER = new StudentController();
	private static final ProfessorController PROFESSORCONTROLLER = new ProfessorController();
	private static final PasController PASCONTROLLER = new PasController();

	private static final int STUDENT = 1;
	private static final int PROFESSOR = 2;
	private static final int PAS = 3;

	private static final Scanner ESCANERSTRINGS = new Scanner(System.in);
	private static final Scanner ESCANERENTEROS = new Scanner(System.in);

	private static final int USERNAME = 1;
	private static final int DNI = 2;

	public void printMenuModificar() {
		logger.info("Se entra en el menu modificar");
		System.out.println("   Bienvenido al modificador   ");
		System.out.println("* * * * * * * * * * * * * * * *");
		System.out.println("   1.- Modificar por usuario   \n" + "   2.- Modificar por dni       ");
		System.out.println("* * * * * * * * * * * * * * * *");
		int userOption = 0;
		try {
			userOption = ESCANERENTEROS.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("El valor que ha introducido no es correcto, por favor vuelva a intentarlo");
			printMenuModificar();
		}
		switch (userOption) {
		case USERNAME:
			updateByUsername();
			break;
		case DNI:
			updateByDni();
			break;

		}

		ESCANERENTEROS.close();
		ESCANERSTRINGS.close();
	}

	public void updateByUsername() {
		String newFaculty = "";
		String newOffice = "";
		String newUnit = "";
		Person persona = null;
		Person student = null;
		Person professor = null;
		Person pas = null;

		System.out.print("Introduzca el usuario: ");
		String username = ESCANERSTRINGS.nextLine();
		int tipoPersona = 0;
		System.out.print("Nuevo nombre: ");
		String newName = ESCANERSTRINGS.nextLine();
		System.out.println("Nuevos apellidos: ");
		String newSurname = ESCANERSTRINGS.nextLine();
		System.out.println("Nuevo mail: ");
		String newMail = ESCANERSTRINGS.nextLine();
		System.out.println("Nueva contraseña");
		String newPassword = ESCANERSTRINGS.nextLine();

		try {

			logger.debug("Se busca al usuario: " + username);
			persona = PERSONCONTROLLER.readByUsername(username);
			tipoPersona = persona.getTipoPersona();

			if (tipoPersona == STUDENT) {

				System.out.println("Nueva facultad: ");
				newFaculty = ESCANERSTRINGS.nextLine();

				logger.debug("Se introducen los nuevos datos que se van a guardar: " + newName + "," + newSurname + ","
						+ newMail + "," + newPassword + "," + newFaculty);

				student = STUDENTCONTROLLER.uploadByUsername(newName, persona.getDni(), newSurname, newMail,
						newPassword, newFaculty);
				System.out.println(student.getName() + " " + student.getSurname() + " " + student.getDni() + " "
						+ student.getMail() + ". FACULTAD: " + ((Student) student).getFaculty());
			} else if (tipoPersona == PROFESSOR) {

				System.out.println("Nueva oficina: ");
				newOffice = ESCANERSTRINGS.nextLine();

				logger.debug("Se introducen los nuevos datos que se van a guardar: " + newName + "," + newSurname + ","
						+ newMail + "," + newPassword + "," + newOffice);

				professor = PROFESSORCONTROLLER.uploadByUsername(newName, persona.getDni(), newSurname, newMail,
						newPassword, newOffice);
				System.out.println(professor.getName() + " " + professor.getSurname() + " " + professor.getDni() + " "
						+ professor.getMail() + ". OFICINA: " + ((Professor) professor).getOffice());
			} else if (tipoPersona == PAS) {

				System.out.println("Nueva unidad: ");
				newUnit = ESCANERSTRINGS.nextLine();

				logger.debug("Se introducen los nuevos datos que se van a guardar: " + newName + "," + newSurname + ","
						+ newMail + "," + newPassword + "," + newUnit);

				pas = PASCONTROLLER.uploadByUsername(newName, persona.getDni(), newSurname, newMail, newPassword,
						newUnit);
				System.out.println(pas.getName() + " " + pas.getSurname() + " " + pas.getDni() + " " + pas.getMail()
						+ ". PAS: " + ((Pas) pas).getUnit());
			}
		} catch (Exception e) {
			System.out.println("No se ha encontrado a la persona que busca");
			e.printStackTrace();
			MENU.printMainMenu();
		}
	}

	public void updateByDni() {

		String newFaculty = "";
		String newOffice = "";
		String newUnit = "";
		Person persona = null;
		Person student = null;
		Person professor = null;
		Person pas = null;

		System.out.print("Introduzca el dni: ");
		String dni = ESCANERSTRINGS.nextLine();
		int tipoPersona = 0;
		System.out.print("Nuevo nombre: ");
		String newName = ESCANERSTRINGS.nextLine();
		System.out.println("Nuevos apellidos: ");
		String newSurname = ESCANERSTRINGS.nextLine();
		System.out.println("Nuevo mail: ");
		String newMail = ESCANERSTRINGS.nextLine();
		System.out.println("Nueva contraseña");
		String newPassword = ESCANERSTRINGS.nextLine();

		try {
			persona = PERSONCONTROLLER.readByDni(dni);
			tipoPersona = persona.getTipoPersona();
			if (tipoPersona == STUDENT) {
				System.out.println("Nueva facultad: ");
				newFaculty = ESCANERSTRINGS.nextLine();
				student = STUDENTCONTROLLER.uploadByDni(newName, dni, newSurname, newMail, newPassword, newFaculty);
				System.out.println(student.getName() + " " + student.getSurname() + " " + student.getDni() + " "
						+ student.getMail() + ". FACULTAD: " + ((Student) student).getFaculty());
			} else if (tipoPersona == PROFESSOR) {
				System.out.println("Nueva oficina: ");
				newOffice = ESCANERSTRINGS.nextLine();
				professor = PROFESSORCONTROLLER.uploadByDni(newName, dni, newSurname, newMail, newPassword, newOffice);
				System.out.println(professor.getName() + " " + professor.getSurname() + " " + professor.getDni() + " "
						+ professor.getMail() + ". OFICINA: " + ((Professor) professor).getOffice());
			} else if (tipoPersona == PAS) {
				System.out.println("Nueva unidad: ");
				newUnit = ESCANERSTRINGS.nextLine();
				pas = PASCONTROLLER.uploadByDni(newName, dni, newSurname, newMail, newPassword, newUnit);
				System.out.println(pas.getName() + " " + pas.getSurname() + " " + pas.getDni() + " " + pas.getMail()
						+ ". PAS: " + ((Pas) pas).getUnit());
			}
		} catch (Exception e) {
			System.out.println("No se ha encontrado a la persona que busca");
			e.printStackTrace();
			MENU.printMainMenu();
		}
	}
}

package edu.beca.es.eoi.UIConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.beca.es.eoi.controller.PetController;
import edu.beca.es.eoi.enums.TypePets;
import lombok.extern.log4j.Log4j;

@Log4j
public class PetMenu {
	// Scanners
	private static final Scanner INTEGERSCANNER = new Scanner(System.in);
	private static final Scanner STRINGSCANNER = new Scanner(System.in);

	// Others menus
	private static final DogMenu DOGMENU = new DogMenu();
	private static final CatMenu CATMENU = new CatMenu();
	private static final BirdMenu BIRDMENU = new BirdMenu();
	private static final OtherMenu OTHERMENU = new OtherMenu();

	private static final String DOG = "PERRO";
	private static final String CAT = "GATO";
	private static final String BIRD = "PAJARO";

	// Controller
	private static final PetController CONTROLLER = new PetController();

	public void printPetMenu() {
		log.info("Entra en el menu mascota para dar de alta una mascota");
		// Variables declaration
		int idPet = 0;

		System.out.println(" A continuacion va a dar de alta a un animal");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * ");
		System.out.print(" Introduzca un nombre: ");
		String name = STRINGSCANNER.nextLine();

		System.out.print(" Introduzca la ubicacion:");
		String location = STRINGSCANNER.nextLine();

		System.out.print(" Introduzca una description:");
		String description = STRINGSCANNER.nextLine();

		System.out.print(" Especifique la url de la foto para mostrar la mascota:");
		String photo = STRINGSCANNER.nextLine();

		System.out.println(" ¿Que tipo de animal se trata?");
		String typePet = STRINGSCANNER.nextLine().toUpperCase();

		log.debug("El usuario mete los valores: " + name + " " + location + " " + description + " " + typePet);
		switch (typePet) {
		case DOG:
			try {
				idPet = CONTROLLER.savePet(name, location, description, TypePets.DOG.getIntValue(), photo);
			} catch (Exception e) {
				log.debug(e.getMessage() + " " + e.getStackTrace());
				System.out.println(e.getMessage());
				printPetMenu();
			}
			DOGMENU.printDogMenu(name, location, description, TypePets.DOG.getIntValue(), photo, idPet);
			break;
		case CAT:
			try {
				idPet = CONTROLLER.savePet(name, location, description, TypePets.CAT.getIntValue(), photo);
			} catch (Exception e) {
				log.debug(e.getMessage() + " " + e.getStackTrace());
				System.out.println(e.getMessage());
				printPetMenu();
			}
			CATMENU.printCatMenu(name, location, description, TypePets.CAT.getIntValue(), photo, idPet);
			break;
		case BIRD:
			try {
				idPet = CONTROLLER.savePet(name, location, description, TypePets.BIRD.getIntValue(), photo);
			} catch (Exception e) {
				log.debug(e.getMessage() + " " + e.getStackTrace());
				System.out.println(e.getMessage());
				printPetMenu();
			}
			BIRDMENU.printBirdMenu(name, location, description, TypePets.BIRD.getIntValue(), photo, idPet);
			break;
		default:
			try {
				idPet = CONTROLLER.savePet(name, location, description, TypePets.OTHER.getIntValue(), photo);
			} catch (Exception e) {
				log.debug(e.getMessage() + " " + e.getStackTrace());
				System.out.println(e.getMessage());
				printPetMenu();
			}
			OTHERMENU.printOtherMenu(name, location, description, TypePets.OTHER.getIntValue(), photo, idPet);
			break;
		}

		STRINGSCANNER.close();
	}

	public void searchPetMenu() {
		log.info("Se entra en el menu buscar mascota");
		// Variables declaration
		int idPet = 0;
		System.out.println("¿Se sabe la id de la mascota que quiere buscar?");
		String userOption = STRINGSCANNER.nextLine();

		if ("S".equalsIgnoreCase(userOption) && userOption.length() == 1) {
			System.out.print(" Introduzca la id de la mascota que quiere buscar: ");
			try {
				idPet = INTEGERSCANNER.nextInt();
			} catch (InputMismatchException e) {
				log.debug("Se ha introducido un valor incorrecto: " + idPet);
				System.out.println("Por favor, introduzca un valor valido");
				searchPetMenu();
			}
		} else if ("N".equalsIgnoreCase(userOption) && userOption.length() == 1) {
			System.out.println("Entonces tendremos que buscar por el nombre, al menos");
			System.out.println("Introduzca el nombre de la mascota que quiere buscar");
			String name = STRINGSCANNER.nextLine();
			idPet = CONTROLLER.readByName(name);

		} else {
			log.debug("Se ha introducido una opcion erronea");
			System.out.println("Por favor, introduzca una opcion válida, SÍ = S || NO = N");
			searchPetMenu();
		}
		CONTROLLER.readById(idPet);
		STRINGSCANNER.close();
	}

	public void uploadPetMenu() {
		log.info("Entra en el menu mascota para dar de alta una mascota");
		// Variables declaration
		int idPet = 0;
		int typePet = 0;
		String newOwnerName = null;
		String newtlf = null;
		System.out.println("¿Se sabe la id de la mascota que quiere buscar? S/N");
		String userOption = STRINGSCANNER.nextLine();

		if ("S".equalsIgnoreCase(userOption) && userOption.length() == 1) {
			System.out.print(" Introduzca la id de la mascota que quiere buscar: ");
			try {
				idPet = INTEGERSCANNER.nextInt();
			} catch (InputMismatchException e) {
				log.debug("Se ha introducido un valor incorrecto: " + idPet);
				System.out.println("Por favor, introduzca un valor valido");
				uploadPetMenu();
			}
		} else if ("N".equalsIgnoreCase(userOption) && userOption.length() == 1) {
			System.out.println("Entonces tendremos que buscar por el nombre, al menos");
			System.out.println("Introduzca el nombre de la mascota que quiere buscar");
			String name = STRINGSCANNER.nextLine();
			idPet = CONTROLLER.readByName(name);

		} else {
			log.debug("Se ha introducido una opcion erronea");
			System.out.println("Por favor, introduzca una opcion válida, SÍ = S || NO = N");
			searchPetMenu();
		}
		System.out.print(" Introduzca un nombre: ");
		String newname = STRINGSCANNER.nextLine();

		System.out.print(" Introduzca la ubicacion:");
		String newlocation = STRINGSCANNER.nextLine();

		System.out.print(" Introduzca una description:");
		String newdescription = STRINGSCANNER.nextLine();

		System.out.print(" Especifique la url de la foto para mostrar la mascota:");
		String newphoto = STRINGSCANNER.nextLine();

		System.out.println(" ¿Que tipo de animal se trata?");
		String typePetOption = STRINGSCANNER.nextLine().toUpperCase();

		log.debug("El usuario mete los valores: " + newname + " " + newlocation + " " + newdescription + " " + typePet);

		switch (typePetOption) {
		case DOG:
			typePet = TypePets.DOG.getIntValue();
			break;
		case CAT:
			typePet = TypePets.CAT.getIntValue();
			break;
		case BIRD:
			typePet = TypePets.BIRD.getIntValue();
			break;
		default:
			typePet = TypePets.OTHER.getIntValue();
			break;
		}

		System.out.println("¿Quieres hacer algún cambio de dueño?");
		String ownerOption = STRINGSCANNER.nextLine();
		if ("S".equalsIgnoreCase(ownerOption) && ownerOption.length() == 1) {
			System.out.print("Introduce el nombre del nuevo dueño: ");
			newOwnerName = STRINGSCANNER.nextLine();
			System.out.println("Introduce el telefono del nuevo dueño");
			newtlf = STRINGSCANNER.nextLine();
		} else if ("N".equalsIgnoreCase(ownerOption) && ownerOption.length() == 1) {
			System.out.println("Qué pena, a ver si hay suerte");
		} else {
			log.debug("Se ha introducido una opcion erronea");
			System.out.println("Por favor, introduzca una opcion válida, SÍ = S || NO = N");
			uploadPetMenu();
		}
		try {
			CONTROLLER.uploadPet(newname, newlocation, newdescription, typePet, newOwnerName, newtlf, newphoto, idPet);
		} catch (Exception e) {
			log.debug(e.getMessage());
			System.out.println(e.getMessage());
			uploadPetMenu();
		}

		STRINGSCANNER.close();
		INTEGERSCANNER.close();
	}

	public void deletePetMenu() {
		log.info("Entra en el menu mascota para dar de alta una mascota");
		// Variables declaration
		int idPet = 0;
		System.out.println("¿Se sabe la id de la mascota que quiere buscar? SS/N");
		String userOption = STRINGSCANNER.nextLine();

		if ("S".equalsIgnoreCase(userOption) && userOption.length() == 1) {
			System.out.print(" Introduzca la id de la mascota que quiere buscar: ");
			try {
				idPet = INTEGERSCANNER.nextInt();
			} catch (InputMismatchException e) {
				log.debug("Se ha introducido un valor incorrecto: " + idPet);
				System.out.println("Por favor, introduzca un valor valido");
				deletePetMenu();
			}
		} else if ("N".equalsIgnoreCase(userOption) && userOption.length() == 1) {
			System.out.println("Entonces tendremos que buscar por el nombre, al menos");
			System.out.println("Introduzca el nombre de la mascota que quiere buscar");
			String name = STRINGSCANNER.nextLine();
			idPet = CONTROLLER.readByName(name);

		} else {
			log.debug("Se ha introducido una opcion erronea");
			System.out.println("Por favor, introduzca una opcion válida, SÍ = S || NO = N");
			searchPetMenu();
		}
		try {
			CONTROLLER.deletebyid(idPet);
		} catch (Exception e) {
			log.debug(e.getMessage());
			System.out.println(e.getMessage());
			deletePetMenu();
		}

		INTEGERSCANNER.close();
		STRINGSCANNER.close();
	}
}

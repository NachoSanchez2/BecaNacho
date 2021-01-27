package edu.beca.es.eoi.UIConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.beca.es.eoi.controller.PetController;
import edu.beca.es.eoi.entity.Pet;
import edu.beca.es.eoi.service.PetService;
import edu.beca.es.eoi.serviceImpl.PetServiceImpl;
import lombok.extern.log4j.Log4j;

@Log4j
public class CatMenu {

	// Scanners, controller and another menu;
	private static final Scanner INTEGERSCANNER = new Scanner(System.in);
	private static final Scanner STRINGSCANNER = new Scanner(System.in);
	private static final PetController PETCONTROLLER = new PetController();

	private static final OwnerMenu OWNERMENU = new OwnerMenu();
	private static final PetMenu PETMENU = new PetMenu();

	private static final PetService PETSERVICE = new PetServiceImpl();

	public void printCatMenu(String name, String location, String description, int typePet, String photo, int idPet) {
		int age = 0;
		int years = 0;
		int months = 0;
		log.info("Entra en el menu de gato para acabar de completar los datos de la mascota");
		System.out.println("¿Cuantos años tiene el gato?");
		try {
			years = INTEGERSCANNER.nextInt();
		} catch (InputMismatchException e) {
			log.debug("El usuario ha introducido mal un campo: " + age + e.getStackTrace());
			System.out.println("Ha introducido incorrectamente el campo, por favor vuelva a intentarlo");
			printCatMenu(name, location, description, typePet, photo, idPet);
		}
		System.out.println("¿Cuantos meses?");
		try {
			months = INTEGERSCANNER.nextInt();
		} catch (InputMismatchException e) {
			log.debug("El usuario ha introducido mal un campo: " + age + e.getStackTrace());
			System.out.println("Ha introducido incorrectamente el campo, por favor vuelva a intentarlo");
			printCatMenu(name, location, description, typePet, photo, idPet);
		}
		System.out.println("¿Eres el dueño de la mascota, o la mascota tiene dueño?S/N");
		String userOption = STRINGSCANNER.nextLine();
		if ("S".equalsIgnoreCase(userOption) && userOption.length() == 1) {
			OWNERMENU.printMenuOwner(idPet);
		} else if ("N".equalsIgnoreCase(userOption) && userOption.length() == 1) {
			System.out.println("Qué pena, a ver si hay suerte");
		} else {
			log.debug("Se ha introducido una opcion erronea");
			System.out.println("Por favor, introduzca una opcion válida, SÍ = S || NO = N");
			printCatMenu(name, location, description, typePet, photo, idPet);
		}
		age = (years / 12) + months;
		try {
			log.debug("Datos mascota: " + name + " " + location + " " + description + " " + photo + " " + age);
			PETCONTROLLER.saveCat(name, location, description, typePet, photo, age, idPet);
			System.out.println("La mascota se ha guardado corréctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage() + ", vuelva a intentarlo");
			log.debug(e.getMessage());
			PETMENU.printPetMenu();
		}
		INTEGERSCANNER.close();
		STRINGSCANNER.close();
	}

	public void readByIdResult(Pet pet) {
		log.info("Entra en el resultado de la busqueda readByIdResult");
		int ageMonths = pet.getCat().getAge() * 12;
		int years = ageMonths / 12;
		int months = ageMonths - (years * 12);
		System.out.println("La mascota se llama " + pet.getName() + ", se trata de un perro de " + years + " años y "
				+ months + " meses. Es " + pet.getDescription() + " y es de " + pet.getLocation());
		if (pet.getOwner() != null) {
			System.out.println("El dueño se llama " + pet.getOwner().getName() + " su telefono de contacto es el: "
					+ pet.getOwner().getPhone());
		}
	}

	public boolean uploadCat(int idPet, String newname, String newlocation, String newdescription, String newOwnerName,
			String newtlf, String newphoto) {
		System.out.println("Por favor introduzca la nueva edad del gato");
		int age = INTEGERSCANNER.nextInt();
		if (newOwnerName.equals(null) && newtlf.equals(null)) {
			return PETSERVICE.uploadbyID(idPet, newname, newlocation, newdescription, null, null, newphoto, age, null,
					null);
		} else if (newOwnerName.equals(null)) {
			return PETSERVICE.uploadbyID(idPet, newname, newlocation, newdescription, null, null, newphoto, age, null,
					null);
		} else {
			return PETSERVICE.uploadbyID(idPet, newname, newlocation, newdescription, newOwnerName, null, newphoto, age,
					null, null);
		}
	}
}

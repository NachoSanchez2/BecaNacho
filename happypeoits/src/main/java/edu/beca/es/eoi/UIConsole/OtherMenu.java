package edu.beca.es.eoi.UIConsole;

import java.util.Scanner;

import edu.beca.es.eoi.controller.PetController;
import edu.beca.es.eoi.entity.Pet;
import edu.beca.es.eoi.service.PetService;
import edu.beca.es.eoi.serviceImpl.PetServiceImpl;
import lombok.extern.log4j.Log4j;

@Log4j
public class OtherMenu {

	// Scanners, controller and another menu;
	private static final Scanner STRINGSCANNER = new Scanner(System.in);
	private static final PetController PETCONTROLLER = new PetController();

	private static final OwnerMenu OWNERMENU = new OwnerMenu();
	private static final PetMenu PETMENU = new PetMenu();

	private static final PetService PETSERVICE = new PetServiceImpl();

	public void printOtherMenu(String name, String location, String description, int typePet, String photo, int idPet) {

		log.info("Entra en el menu de otro para acabar de completar los datos de la mascota");
		System.out.println("¿Qué clase de animal es?");

		String type = STRINGSCANNER.nextLine();

		System.out.println("¿Eres el dueño de la mascota, o la mascota tiene dueño?S/N");
		String userOption = STRINGSCANNER.nextLine();
		if ("S".equalsIgnoreCase(userOption) && userOption.length() == 1) {
			OWNERMENU.printMenuOwner(idPet);
		} else if ("N".equalsIgnoreCase(userOption) && userOption.length() == 1) {
			System.out.println("Qué pena, a ver si hay suerte");
		} else {
			log.debug("Se ha introducido una opcion erronea");
			System.out.println("Por favor, introduzca una opcion válida, SÍ = S || NO = N");
			printOtherMenu(name, location, description, typePet, photo, idPet);
		}
		try {
			log.debug("Datos mascota: " + name + " " + location + " " + description + " " + photo
					+ ". Se trata de un/a: " + type);
			PETCONTROLLER.saveOther(name, location, description, typePet, photo, type, idPet);
			System.out.println("La mascota se ha guardado corréctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage() + ", vuelva a intentarlo");
			log.debug(e.getMessage());
			PETMENU.printPetMenu();
		}
		STRINGSCANNER.close();
	}

	public void readByIdResult(Pet pet) {
		log.info("Entra en el resultado de la busqueda readByIdResult");

		System.out.println("La mascota se llama " + pet.getName() + ", se trata de un " + pet.getOther().getType()
				+ ". Es " + pet.getDescription() + " y es de " + pet.getLocation());
		if (pet.getOwner() != null) {
			System.out.println("El dueño se llama " + pet.getOwner().getName() + " su telefono de contacto es el: "
					+ pet.getOwner().getPhone());
		}
	}

	public boolean uploadOther(int idPet, String newname, String newlocation, String newdescription,
			String newOwnerName, String newtlf, String newphoto) {
		System.out.println("Por favor introduzca la nueva edad del perro");
		String newType = STRINGSCANNER.nextLine();
		if (newOwnerName.equals(null) && newtlf.equals(null)) {
			return PETSERVICE.uploadbyID(idPet, newname, newlocation, newdescription, null, null, newphoto, 0, null,
					newType);
		} else if (newOwnerName.equals(null)) {
			return PETSERVICE.uploadbyID(idPet, newname, newlocation, newdescription, null, null, newphoto, 0, null,
					newType);
		} else {
			return PETSERVICE.uploadbyID(idPet, newname, newlocation, newdescription, newOwnerName, null, newphoto, 0,
					null, newType);
		}
	}

}

package edu.beca.es.eoi.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsultMenu {
	private static final Scanner INTEGERSCANNER = new Scanner(System.in);
	private static final MainMenu MENU = new MainMenu();

	public void consultNumber() {
		System.out.print("COMPROBAR NÚMERO:");
		int userOption = 0;

		try {
			userOption = INTEGERSCANNER.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("El numero introducido no es correcto, introduzca un número de entre 0 y 99.999");
			consultNumber();
		}

		for (Integer number : MainMenu.simulatedLotery.keySet()) {
			if (number.equals(userOption)) {
				System.out.println("¡ENHORABUENA! Ha ganado " + MainMenu.simulatedLotery.get(number));
			} else {
				System.out.println("Lo siento, no ha habido premio para el numero que ha seleccionado");
				MENU.printMenuMain();
			}
		}
	}
}

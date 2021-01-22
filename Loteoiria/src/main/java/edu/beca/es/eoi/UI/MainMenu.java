package edu.beca.es.eoi.UI;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.controller.LoteryController;
import edu.beca.es.eoi.main.MainJavaApp;

public class MainMenu {
	private static final Logger logger = Logger.getLogger(MainJavaApp.class);

	private static final int SIMULATE = 1;
	private static final int PRIZES = 2;
	private static final int PREMIATEDNUMBERS = 3;
	private static final int CONSULTNUMBER = 4;
	private static final int EXIT = 5;

	private static final Scanner INTEGERSCANNER = new Scanner(System.in);

	private static final PrizesMenu PRIZESMENU = new PrizesMenu();
	private static final ConsultMenu CONSULTMENU = new ConsultMenu();
	private static final LoteryController LOTERYCONTROLLER = new LoteryController();
	static Map<Integer, Integer> simulatedLotery = new HashMap<Integer, Integer>();

	public void printMenuMain() {
		// Declaration
		int userOption = 0;
		boolean exitOK = false;
		// Menu
		do {
			logger.info("Entro en el menu principal");
			System.out.println("Bienvenido a LOTERÍA DEL ESTADO");
			System.out.println("* * * * * * * * * * * * * * * *");
			System.out.println("1.- SIMULAR LOTERIA            \n" + "2.- CONSULTAR PREMIOS          \n"
					+ "3.- CONSULTAR NUMEROS PREMIADOS\n" + "4.- COMPROBAR NUMERO           \n" + "5.- SALIR\n");

			try {
				userOption = INTEGERSCANNER.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Por favor introduzca una opcion valida");
				logger.debug("Ha habido un error: " + e.getStackTrace());
				printMenuMain();
			}
			switch (userOption) {
			case SIMULATE:
				System.out.println("QUE TENGAS MUCHA SUERTE");
				try {
					simulatedLotery = LOTERYCONTROLLER.simulateLotery();
					if (!simulatedLotery.isEmpty()) {
						System.out.println("Se ha realizado la simulacion correctamente");
						PRIZESMENU.showLoterySimulation(simulatedLotery);
					}
				} catch (Exception e) {
					e.printStackTrace();
					logger.debug("Ha habido un error en la simulacion de la loteria: " + e.getStackTrace());
					printMenuMain();
				}
				break;
			case PRIZES:
				if (!simulatedLotery.isEmpty()) {
					PRIZESMENU.showPrizes();
				} else {
					logger.debug("Se intenta acceder al menú de premios sin haber simulado el sorteo");
					System.out.println("La lotería aún no se ha simulado, por favor, simule antes el sorteo");
					printMenuMain();
				}
				break;
			case PREMIATEDNUMBERS:
				if (!simulatedLotery.isEmpty()) {
					PRIZESMENU.showPremiatedNumbers();
				} else {
					logger.debug("Se intenta acceder al menú de numeros premiados sin haber simulado el sorteo");
					System.out.println("La lotería aún no se ha simulado, por favor, simule antes el sorteo");
					printMenuMain();
				}
				break;
			case CONSULTNUMBER:
				if (!simulatedLotery.isEmpty()) {
					CONSULTMENU.consultNumber();
				} else {
					logger.debug("Se intenta acceder al menú para consultar premios sin haber simulado el sorteo");
					System.out.println("La lotería aún no se ha simulado, por favor, simule antes el sorteo");
					printMenuMain();
				}
				break;
			case EXIT:
				exitOK = true;
				simulatedLotery.clear();
				break;
			}
		} while (!exitOK);
	}
}

package edu.beca.es.eoi.djeoiUI;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.djeoiController.SongController;
import edu.beca.es.eoi.djeoiMain.MainDj;

public class MainMenu {
	// Scanner and logger
	private static final Logger logger = Logger.getLogger(MainDj.class);
	private static final Scanner INTEGERSCANNER = new Scanner(System.in);

	// Constants
	private static final int MAKESONG = 1;
	private static final int LISTSONGS = 2;
	private static final int DELETESONG = 3;
	private static final int EXIT = 4;

	// Song menu and controller instance
	private static final SongMenu SONGMENU = new SongMenu();
	private static final SongController SONGCONTROLLER = new SongController();

	// Global variables
	private static boolean exitOK = false;
	private static Map<String, String> songs = new HashMap<String, String>();

	public void printMenuMain() {
		logger.info("Entra en el menu principal");
		// Menu
		do {
			System.out.println("    BIENVENIDO A DJEOI    ");
			System.out.println("**************************");
			System.out.println("  1.- Crear melodía       \n" + "  2.- Listar melodías     \n"
					+ "  3.- Borrar melodía      \n" + "  4.- SALIR               ");
			System.out.println("**************************");

			// Declaration
			int userOptionMenu = 0;

			try {
				userOptionMenu = INTEGERSCANNER.nextInt();
			} catch (InputMismatchException e) {
				logger.debug("Se ha introducido un comando incorrecto: " + e.getStackTrace());
				System.out.println("El valor que ha introducido es incorrecto, vuelva a intentarlo");
				printMenuMain();
			}

			switch (userOptionMenu) {
			case MAKESONG:
				SONGMENU.printSongMenu();
				break;
			case LISTSONGS:
				songs = SONGCONTROLLER.readAllSongs();
				for (String song : songs.keySet()) {
					System.out.println(song);
				}
				SONGMENU.playSong();
				break;
			case DELETESONG:
				SONGMENU.deleteSong();
				break;
			case EXIT:
				exitOK = true;
				System.out.println("Adiós, vuelve pronto");
				break;
			default:
				System.out.println("Adiós, vuelve pronto");
				exitOK = true;
				break;
			}
		} while (!exitOK);
	}
}

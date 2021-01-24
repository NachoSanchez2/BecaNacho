package edu.beca.es.eoi.djeoiUI;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.djeoiController.SongController;
import edu.beca.es.eoi.djeoiMain.MainDj;

public class SongMenu {
	// Scanner, logger and Jukebox;
	private static final Logger logger = Logger.getLogger(MainDj.class);
	private static final Scanner STRINGSCANNER = new Scanner(System.in);
	private static final Scanner INTEGERSCANNER = new Scanner(System.in);

	private static final MainMenu MENU = new MainMenu();
	private static final SongController SONGCONTROLLER = new SongController();
	private static final VoiceMenu VOICEMENU = new VoiceMenu();

	// Constants
	private static final int CHOOSEINSTRUMENT = 1;
	private static final int GENERATERITHM = 2;
	private static final int INSERTCHORD = 3;
	private static final int COMPOSITEAVOICE = 4;
	private static final int DELETEVOICE = 5;
	private static final int SAVESONG = 6;

	// Global variable declaration
	private static Map<String, String> songs = new TreeMap<String, String>();

	public void printSongMenu() {
		logger.info("Se entra en el menu Composicion de melodias");
		// Declaration
		int userOption = 0;
		boolean save = false;

		System.out.println("¿Primero que nada, que nombre le quiere poner a la cancion?");
		String songName = STRINGSCANNER.nextLine();
		logger.debug("Se establece el nombre de la cancion: " + songName);
		do {
			System.out.println("       Compositor de melodías       ");
			System.out.println("************************************");
			System.out.println("   1.- Elegir instrumento           \n" + "   2.- Generar voz ritmica          \n"
					+ "   3.- Insertar acorde existente    \n" + "   4.- Composición de voz           \n"
					+ "   5.- Eliminar voz                 \n" + "   6.- Guardar cancion              \n");
			System.out.println("************************************");

			try {
				userOption = INTEGERSCANNER.nextInt();
			} catch (InputMismatchException e) {
				logger.debug("Se ha introducido un valor erróneo: " + e.getStackTrace());
				System.out.println("Ha introducido un valor erróneo vuelva a intentarlo");
				printSongMenu();
			}
			switch (userOption) {
			case CHOOSEINSTRUMENT:
				VOICEMENU.instrumentSelection();
				break;
			case GENERATERITHM:
				VOICEMENU.makeRithm();
				break;
			case INSERTCHORD:
				VOICEMENU.chordMenu();
				break;
			case COMPOSITEAVOICE:
				VOICEMENU.compositeVoice();
				break;
			case DELETEVOICE:
				VOICEMENU.deleteVoice();
				break;
			case SAVESONG:
				try {
					VOICEMENU.saveSong(songName);
				} catch (Exception e) {
					logger.debug("Ha habido un error: " + e.getMessage());
					System.out.println(e.getMessage());
					printSongMenu();
				}
				save = true;
				break;
			}
		} while (!save);

	}

	public void playSong() {
		logger.info("Entra en el menu playSong");
		System.out.println("Desea reproducir alguna? S/N");
		System.out.println("****************************");
		String userOption = STRINGSCANNER.nextLine();

		logger.debug("El usuario ha elegido " + userOption + " se comprueba que ha elegido correctamente");
		if (userOption.length() == 1 && "S".equalsIgnoreCase(userOption)) {
			System.out.println("*******************************");
			System.out.print("Indique el nombre de la cancion: ");
			String songName = STRINGSCANNER.nextLine();
			logger.info("Se busca el nombre introducido en la lista de canciones y se recoge su valor");
			logger.debug("El nombre de la cancion a buscar es: " + songName);

			SONGCONTROLLER.playSong(songName);
			String userOptionSubmenu;
			logger.info(
					"Se mete en un bucle que pergunta si se quiere volver a repetir la canción hasta que se salca con un N");
			do {
				System.out.println("¿Desea volver a escucharla?");
				userOptionSubmenu = STRINGSCANNER.nextLine();
				if (userOptionSubmenu.length() == 1 && "S".equalsIgnoreCase(userOptionSubmenu)) {
					SONGCONTROLLER.playSong(songName);
				} else if (userOptionSubmenu.length() == 1 && "N".equalsIgnoreCase(userOptionSubmenu)) {
					System.out.println("Espero que te haya gustado, adiós");
				} else {
					System.out.println("Por favor introduca un valor válido");
				}
			} while (!"N".equalsIgnoreCase(userOptionSubmenu));

			logger.info("Se sale del metodo playSong");
		} else if (userOption.length() == 1 && "N".equalsIgnoreCase(userOption)) {
			logger.info("No se quiere reproducir ninguna cancion, vuelve al menu principal");
			System.out.println("*******************************");
			System.out.println("Vale, Adiós");
			MENU.printMenuMain();
		}

	}

	public void deleteSong() {
		// Declaration
		String userOption = "";
		String songName = "";

		System.out.println("A continuacion va a borrar una cancion");
		System.out.println("* * * * * * * * * * * * * * * * * * * ");
		System.out.println("Desea ver la lista de melodias?S/N");
		userOption = STRINGSCANNER.nextLine();
		if (userOption.length() == 1 && "S".equalsIgnoreCase(userOption)) {
			songs = SONGCONTROLLER.readAllSongs();
			for (String song : songs.keySet()) {
				System.out.println(song);
			}
		} else if (userOption.length() == 1 && "N".equalsIgnoreCase(userOption)) {
			System.out.println("Introduzca el nombre de la cancion que desea eliminar");
			songName = STRINGSCANNER.nextLine();
			boolean deleteOK = SONGCONTROLLER.deleteSong(songName);
			if (deleteOK) {
				System.out.println("La cancion: " + songName + " se ha eliminado correctamente");
			}
		} else {
			System.out.println("Por favor introduca un valor valido");
			deleteSong();
		}
	}
}

package edu.beca.es.eoi.aleoixaUI;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.aleoixaControllers.JokeController;
import edu.beca.es.eoi.aleoixaMain.AleoixaMainApp;

public class JokeMenu {
	static Logger logger = Logger.getLogger(AleoixaMainApp.class);
	private static final JokeController JOKECONTROLLER = new JokeController();

	public void readaJoke() {
		logger.info("Entro en el menu de joke");
		String chiste = "";
		System.out.println("CHISTE: ");
		try {
			chiste = JOKECONTROLLER.jokeController();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(chiste);
	}

}

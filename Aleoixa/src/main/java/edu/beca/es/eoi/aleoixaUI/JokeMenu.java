package edu.beca.es.eoi.aleoixaUI;

import java.util.Random;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.aleoixaMain.AleoixaMainApp;
import edu.beca.es.eoi.aleoixaServices.JokesService;
import edu.beca.es.eoi.aleoixaServicesImpl.JokesServiceImpl;

public class JokeMenu {
	static Logger logger = Logger.getLogger(AleoixaMainApp.class);
	private static final JokesService JOKESSERVICE = new JokesServiceImpl();
	private static final Random RANDOMNUM = new Random();

	public void readaJoke() {
		logger.info("Entro en el menu de joke");
		System.out.println("CHISTE: ");
		System.out.println(JOKESSERVICE.readById(RANDOMNUM.nextInt(6) + 1));
	}

}

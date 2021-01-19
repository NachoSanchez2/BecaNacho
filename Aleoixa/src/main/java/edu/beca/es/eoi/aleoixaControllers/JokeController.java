package edu.beca.es.eoi.aleoixaControllers;

import java.util.Random;

import edu.beca.es.eoi.aleoixaServices.JokesService;
import edu.beca.es.eoi.aleoixaServicesImpl.JokesServiceImpl;

public class JokeController {
	private static final JokesService JOKESSERVICE = new JokesServiceImpl();
	private static final Random RANDOMNUM = new Random();

	public String jokeController() throws Exception {
		String chiste = JOKESSERVICE.readById(RANDOMNUM.nextInt(6) + 1);
		if (chiste != null) {
			return chiste;
		} else {
			throw new Exception("Hoy no tengo gracia, no te puedo contar ningun chiste");
		}
	}

}

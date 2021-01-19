package edu.beca.es.eoi.aleoixaControllers;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.aleoixaUI.CalculatorMenu;
import edu.beca.es.eoi.aleoixaUI.DayTimeMenu;
import edu.beca.es.eoi.aleoixaUI.JokeMenu;
import edu.beca.es.eoi.aleoixaUI.TranslationMenu;

public class MainController {

	static Logger logger = Logger.getLogger(MainController.class);
	private static final DayTimeMenu DAYTIMEMENU = new DayTimeMenu();
	private static final JokeMenu JOKEMENU = new JokeMenu();
	private static final CalculatorMenu CALCULATORMENU = new CalculatorMenu();
	private static final TranslationMenu TRANSLATEMENU = new TranslationMenu();

	public void mainController(String userOption) {
		logger.info("Entra en el controlador del main");
		if ("¿Qué día es?".equalsIgnoreCase(userOption)) {
			DAYTIMEMENU.showDay();
		} else if ("¿Qué hora es?".equalsIgnoreCase(userOption)) {
			DAYTIMEMENU.showTime();
		} else if ("Chiste".equalsIgnoreCase(userOption)) {
			JOKEMENU.readaJoke();
		} else if ("Calculadora".equalsIgnoreCase(userOption)) {
			CALCULATORMENU.printOperationMenu();
		} else if ("Traducir".equalsIgnoreCase(userOption)) {
			TRANSLATEMENU.printTranslationMenu();
		}
		logger.info("Sale del controlador del main");
	}

}

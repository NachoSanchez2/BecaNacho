package edu.beca.es.eoi.aleoixaUI;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.aleoixaControllers.ShowDayTimeController;

public class DayTimeMenu {
	private static Logger logger = Logger.getLogger(DayTimeMenu.class);
	private static final ShowDayTimeController SHOWDAYTIMECONTROLER = new ShowDayTimeController();
	private static final MenuPrincipal MAINMENU = new MenuPrincipal();

	public void showDay() {
		logger.info("Entro en el menu de showDay");
		String dia = "";
		try {
			dia = SHOWDAYTIMECONTROLER.showDay();
		} catch (Exception e) {
			logger.debug("Ha habido un error al recuperar la fecha actual");
			e.printStackTrace();
			MAINMENU.printMenuPrincipal();
		}
		System.out.println("Hoy estamos a ".concat(dia));
	}

	public void showTime() {
		logger.info("Entro en el menu de showTime");
		String hora = "";
		try {
			hora = SHOWDAYTIMECONTROLER.showTime();
		} catch (Exception e) {
			logger.debug("Ha habido un error al recuperar la fecha actual");
			e.printStackTrace();
			MAINMENU.printMenuPrincipal();
		}
		System.out.println("La hora actual es ".concat(hora));
	}

}

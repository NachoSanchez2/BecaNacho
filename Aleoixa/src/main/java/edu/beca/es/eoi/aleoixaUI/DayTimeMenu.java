package edu.beca.es.eoi.aleoixaUI;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.aleoixaMain.AleoixaMainApp;
import edu.beca.es.eoi.aleoixaServices.ShowDayTimeService;
import edu.beca.es.eoi.aleoixaServicesImpl.ShowDayTimeServiceImpl;

public class DayTimeMenu {
	private static final ShowDayTimeService SHOWDAYYTIMESERVICE = new ShowDayTimeServiceImpl();
	static Logger logger = Logger.getLogger(AleoixaMainApp.class);

	public void showDay() {
		logger.info("Entro en el menu de showDay");
		String dia = "";
		dia = SHOWDAYYTIMESERVICE.showDay();
		System.out.println("Hoy estamos a ".concat(dia));
	}

	public void showTime() {
		logger.info("Entro en el menu de showTime");
		String hora = "";
		hora = SHOWDAYYTIMESERVICE.showTime();
		System.out.println("La hora actual es ".concat(hora));
	}

}

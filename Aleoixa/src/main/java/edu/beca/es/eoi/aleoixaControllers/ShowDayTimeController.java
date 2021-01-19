package edu.beca.es.eoi.aleoixaControllers;

import edu.beca.es.eoi.aleoixaServices.ShowDayTimeService;
import edu.beca.es.eoi.aleoixaServicesImpl.ShowDayTimeServiceImpl;

public class ShowDayTimeController {
	private static final ShowDayTimeService SHOWDAYYTIMESERVICE = new ShowDayTimeServiceImpl();

	public String showDay() {
		String dia = null;
		dia = SHOWDAYYTIMESERVICE.showDay();
		if(dia!=null) {
			return dia;
		}
	}

}

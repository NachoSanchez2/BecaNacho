package edu.beca.es.eoi.aleoixaControllers;

import edu.beca.es.eoi.aleoixaServices.ShowDayTimeService;
import edu.beca.es.eoi.aleoixaServicesImpl.ShowDayTimeServiceImpl;

public class ShowDayTimeController {
	private static final ShowDayTimeService SHOWDAYTIMESERVICE = new ShowDayTimeServiceImpl();

	public String showDay() throws Exception {
		String dia = SHOWDAYTIMESERVICE.showDay();
		if(dia!=null) {
			return dia;
		}else {
			throw new Exception("Ha habido un problema al recuperar la hora");
		}
	}
	public String showTime() throws Exception {
		String hora = SHOWDAYTIMESERVICE.showTime();
		if(hora!=null) {
			return hora;
		}else {
			throw new Exception("Ha habido un problema al recuperar la hora");
		}
	}

}

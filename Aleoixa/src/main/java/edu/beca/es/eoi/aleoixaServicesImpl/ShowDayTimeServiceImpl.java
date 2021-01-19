package edu.beca.es.eoi.aleoixaServicesImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import edu.beca.es.eoi.aleoixaServices.ShowDayTimeService;

public class ShowDayTimeServiceImpl implements ShowDayTimeService {
	public static final SimpleDateFormat FORMATTERDAY = new SimpleDateFormat("dd-MMM-aaaa");
	public static final SimpleDateFormat FORMATTERTIME = new SimpleDateFormat("HH:mm:ss");
	public static final Date CURRENTDATETIME = new Date(Calendar.getInstance().getTimeInMillis());

	@Override
	public String showDay() {
		return FORMATTERDAY.format(CURRENTDATETIME);
	}

	@Override
	public String showTime() {
		return FORMATTERTIME.format(CURRENTDATETIME.getTime());
	}

}

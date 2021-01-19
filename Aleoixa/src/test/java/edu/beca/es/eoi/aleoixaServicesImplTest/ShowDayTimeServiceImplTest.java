package edu.beca.es.eoi.aleoixaServicesImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.aleoixaServices.ShowDayTimeService;
import edu.beca.es.eoi.aleoixaServicesImpl.ShowDayTimeServiceImpl;

class ShowDayTimeServiceImplTest {

	@Test
	void testShowDay() {
		// PreparedTest
		String day = "19/01/2021";
		ShowDayTimeService service = new ShowDayTimeServiceImpl();

		// Implementation
		String test = service.showDay();

		// Assert
		assertEquals(day, test);
	}

}

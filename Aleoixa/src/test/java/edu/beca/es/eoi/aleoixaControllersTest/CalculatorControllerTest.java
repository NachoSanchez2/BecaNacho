package edu.beca.es.eoi.aleoixaControllersTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.aleoixaControllers.CalculatorController;

class CalculatorControllerTest {

	@Test
	void testOperation() {
		// PreparedTest
		String userOption = "100.25 * 2";
		CalculatorController controller = new CalculatorController();
		double result = 0.0;

		// Implementation
		try {
			result = controller.operation(userOption);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Asserts
		assertEquals(200.50, result);
	}

}

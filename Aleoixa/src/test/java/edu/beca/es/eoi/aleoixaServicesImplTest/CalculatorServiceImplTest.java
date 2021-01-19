package edu.beca.es.eoi.aleoixaServicesImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.aleoixaServicesImpl.CalculatorServiceImpl;

class CalculatorServiceImplTest {

	@Test
	void testOperationAddition() {
		// PreparationTest
		char addition = '+';
		double number1 = 5.0;
		double number2 = 5.0;
		CalculatorServiceImpl service = new CalculatorServiceImpl();

		// Implementation
		double result = service.operation(addition, number1, number2);

		// Assert
		assertEquals(10.0, result);
	}

	@Test
	void testOperationSubstraction() {
		// PreparationTest
		char substraction = '-';
		double number1 = 5.0;
		double number2 = 5.0;
		CalculatorServiceImpl service = new CalculatorServiceImpl();

		// Implementation
		double result = service.operation(substraction, number1, number2);

		// Assert
		assertEquals(0.0, result);
	}

	@Test
	void testOperationMultiplication() {
		// PreparationTest
		char multiplication = '*';
		double number1 = 5.0;
		double number2 = 5.0;
		CalculatorServiceImpl service = new CalculatorServiceImpl();

		// Implementation
		double result = service.operation(multiplication, number1, number2);

		// Assert
		assertEquals(25.0, result);
	}

	@Test
	void testOperationDivision() {
		// PreparationTest
		char division = '/';
		double number1 = 5.0;
		double number2 = 5.0;
		CalculatorServiceImpl service = new CalculatorServiceImpl();

		// Implementation
		double result = service.operation(division, number1, number2);

		// Assert
		assertEquals(1.0, result);
	}

}

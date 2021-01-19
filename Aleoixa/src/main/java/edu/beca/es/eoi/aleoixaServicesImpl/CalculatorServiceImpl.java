package edu.beca.es.eoi.aleoixaServicesImpl;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.aleoixaRepositoryImpl.JokesRepositoryJDBCImpl;
import edu.beca.es.eoi.aleoixaServices.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

	private Logger logger = Logger.getLogger(JokesRepositoryJDBCImpl.class);
	public static final char ADDITION = '+';
	public static final char SUBSTRACTION = '-';
	public static final char MULTIPLICATION = '*';
	public static final char DIVISION = '/';

	@Override
	public double operation(Character operator, double number1, double number2) {
		double result = 0.0;
		logger.info("Entra en el metodo operation");
		switch (operator) {
		case ADDITION:
			result = number1 + number2;
			break;
		case SUBSTRACTION:
			result = number1 - number2;
			break;
		case MULTIPLICATION:
			result = number1 * number2;
			break;
		case DIVISION:
			result = number1 / number2;
			break;
		}
		logger.info("Sale del metodo operation");
		return result;
	}

}

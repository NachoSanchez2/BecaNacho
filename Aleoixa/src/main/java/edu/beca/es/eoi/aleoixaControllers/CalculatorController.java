package edu.beca.es.eoi.aleoixaControllers;

import edu.beca.es.eoi.aleoixaServices.CalculatorService;
import edu.beca.es.eoi.aleoixaServicesImpl.CalculatorServiceImpl;

public class CalculatorController {
	private static final CalculatorService CALCULATORSERVICE = new CalculatorServiceImpl();

	public double operation(String userOption) throws Exception {
		// Declaration
		double number1 = 0.0;
		double number2 = 0.0;
		char operator = ' ';
		int indexOfOperator = 0;
		double result = 0.0;

		// Separa las palabras por espacios
		String[] separedWord = userOption.split(" ");

		if (separedWord.length != 3) {
			throw new Exception("Ha habido un error con la operacion introducida");
		} else {
			// Cuando encuentre un operador que lo identifique como un operador y devuelva
			// el indice
			for (int i = 0; i < separedWord.length; i++) {
				if ("+".equals(String.valueOf(separedWord[i].charAt(0)))
						|| "-".equals(String.valueOf(separedWord[i].charAt(0)))
						|| "*".equals(String.valueOf(separedWord[i].charAt(0)))
						|| "/".equals(String.valueOf(separedWord[i].charAt(0)))) {
					operator = separedWord[1].charAt(0);
					indexOfOperator = userOption.indexOf(operator);
				}
			}

			// Todo lo que hay antes es el numero 1 evitando el espacio
			for (int i = 0; i < indexOfOperator - 1; i++) {
				number1 = Double.valueOf(separedWord[0]);
			}
			// Todo lo que hay despues es el numero 2 evitando el espacios
			for (int i = indexOfOperator + 1; i < userOption.length(); i++) {
				number2 = Double.valueOf(separedWord[2]);
			}

			result = CALCULATORSERVICE.operation(operator, number1, number2);
		}

		return result;
	}

}

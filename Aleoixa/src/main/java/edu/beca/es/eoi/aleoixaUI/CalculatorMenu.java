package edu.beca.es.eoi.aleoixaUI;

import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.aleoixaControllers.CalculatorController;
import edu.beca.es.eoi.aleoixaMain.AleoixaMainApp;

public class CalculatorMenu {
	private static final CalculatorController CALCULATORCONTROLLER = new CalculatorController();
	private static final Scanner ESCANER = new Scanner(System.in);
	static Logger logger = Logger.getLogger(AleoixaMainApp.class);

	public void printOperationMenu() {
		logger.info("Entra en el metodo printOperationMenu");
		System.out.println("¿Qué desea calcular?");
		System.out.println("Ejemplo: (5.0 * 5.0)");
		String userOption = ESCANER.nextLine();

		double result = 0.0;
		try {
			result = CALCULATORCONTROLLER.operation(userOption);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("Ha habido un problema con la introduccion de los valores para calcular");
			printOperationMenu();
		}
		System.out.println("El resultado es: ".concat(Double.toString(result)));

	}
}

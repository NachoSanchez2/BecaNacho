package edu.beca.es.eoi.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.beca.es.eoi.enums.Prizes;

public class PrizesMenu {
	private static String firstNumberAwarded;
	private static String secondNumberAwarded;
	private static String thirdNumberAwarded;
	private static List<String> fourthNumberAwarded = new ArrayList<String>();
	private static List<String> fifthNumberAwarded = new ArrayList<String>();

	public void showLoterySimulation(Map<Integer, Integer> simulatedLotery) {
		for (Integer number : simulatedLotery.keySet()) {
			simulatedLotery.get(number);
			if (Prizes.FIRSTPRIZE.getValue() == simulatedLotery.get(number)) {
				firstNumberAwarded = formatterInteger(number);
			} else if (Prizes.SECONDPRIZE.getValue() == simulatedLotery.get(number)) {
				secondNumberAwarded = formatterInteger(number);
			} else if (Prizes.THIRDPRIZE.getValue() == simulatedLotery.get(number)) {
				thirdNumberAwarded = formatterInteger(number);
			} else if (Prizes.FOURTHPRIZE.getValue() == simulatedLotery.get(number)) {
				fourthNumberAwarded.add(formatterInteger(number));
			} else if (Prizes.FIFTHPRIZE.getValue() == simulatedLotery.get(number)) {
				fifthNumberAwarded.add(formatterInteger(number));
			}
		}

		// Prizes
		System.out.println("PREMIOS:");
		System.out.print("Primer premio    ");
		System.out.print("Segundo Premio   ");
		System.out.print("Tercer Premio    ");
		System.out.print("Cuartos Premios  ");
		System.out.println("Quintos Premios");

		System.out.print(Prizes.FIRSTPRIZE.getValue());
		System.out.print("          " + Prizes.SECONDPRIZE.getValue());
		System.out.print("          " + Prizes.THIRDPRIZE.getValue());
		System.out.print("           " + Prizes.FOURTHPRIZE.getValue());
		System.out.println("            " + Prizes.FIFTHPRIZE.getValue() + " " + Prizes.FIFTHPRIZE.getValue());
		System.out.print("                                                   " + Prizes.FOURTHPRIZE.getValue());
		System.out.println("            " + Prizes.FIFTHPRIZE.getValue() + " " + Prizes.FIFTHPRIZE.getValue());
		System.out.println("                                                                     "
				+ Prizes.FIFTHPRIZE.getValue() + " " + Prizes.FIFTHPRIZE.getValue());
		System.out.println("                                                                     "
				+ Prizes.FIFTHPRIZE.getValue() + " " + Prizes.FIFTHPRIZE.getValue());
		// Numbers awarded
		System.out.println("NÚMEROS PREMIADOS:");
		System.out.print("Primer premio    ");
		System.out.print("Segundo Premio   ");
		System.out.print("Tercer Premio    ");
		System.out.print("Cuartos Premios  ");
		System.out.println("Quintos Premios");

		System.out.print(firstNumberAwarded);
		System.out.print("           " + secondNumberAwarded);
		System.out.print("           " + thirdNumberAwarded);
		System.out.print("           " + fourthNumberAwarded.get(0));
		System.out.println("            " + fifthNumberAwarded.get(0) + " " + fifthNumberAwarded.get(1));
		System.out.print("                                                   " + fourthNumberAwarded.get(1));
		System.out.println("            " + fifthNumberAwarded.get(2) + " " + fifthNumberAwarded.get(3));
		System.out.println("                                                                     "
				+ fifthNumberAwarded.get(4) + " " + fifthNumberAwarded.get(5));
		System.out.println("                                                                     "
				+ fifthNumberAwarded.get(6) + " " + fifthNumberAwarded.get(7));
	}

	private String formatterInteger(Integer number) {
		String newNumberFormatTwoFirstDigits = number.toString().substring(0, 2);
		String newNumberFormatLastDigits = number.toString().substring(2);
		String newNumberFormat = newNumberFormatTwoFirstDigits.concat(".").concat(newNumberFormatLastDigits);

//		if (newNumberFormat.length() < 5 || newNumberFormat.length() > 5) {
//			newNumberFormat = String.format("%08d", newNumberFormat);
//		}
		return newNumberFormat;
	}

	public void showPremiatedNumbers() {
		// Numbers awarded
		System.out.println("NÚMEROS PREMIADOS:");
		System.out.print("Primer premio    ");
		System.out.print("Segundo Premio   ");
		System.out.print("Tercer Premio    ");
		System.out.print("Cuartos Premios  ");
		System.out.println("Quintos Premios");

		System.out.print(firstNumberAwarded);
		System.out.print("           " + secondNumberAwarded);
		System.out.print("           " + thirdNumberAwarded);
		System.out.print("           " + fourthNumberAwarded.get(0));
		System.out.println("            " + fifthNumberAwarded.get(0) + " " + fifthNumberAwarded.get(1));
		System.out.print("                                                   " + fourthNumberAwarded.get(1));
		System.out.println("            " + fifthNumberAwarded.get(2) + " " + fifthNumberAwarded.get(3));
		System.out.println("                                                                     "
				+ fifthNumberAwarded.get(4) + " " + fifthNumberAwarded.get(5));
		System.out.println("                                                                     "
				+ fifthNumberAwarded.get(6) + " " + fifthNumberAwarded.get(7));
	}

	public void showPrizes() {
		// Prizes
		System.out.println("PREMIOS:");
		System.out.print("Primer premio    ");
		System.out.print("Segundo Premio   ");
		System.out.print("Tercer Premio    ");
		System.out.print("Cuartos Premios  ");
		System.out.println("Quintos Premios");

		System.out.print(Prizes.FIRSTPRIZE.getValue());
		System.out.print("          " + Prizes.SECONDPRIZE.getValue());
		System.out.print("          " + Prizes.THIRDPRIZE.getValue());
		System.out.print("           " + Prizes.FOURTHPRIZE.getValue());
		System.out.println("            " + Prizes.FIFTHPRIZE.getValue() + " " + Prizes.FIFTHPRIZE.getValue());
		System.out.print("                                                   " + Prizes.FOURTHPRIZE.getValue());
		System.out.println("            " + Prizes.FIFTHPRIZE.getValue() + " " + Prizes.FIFTHPRIZE.getValue());
		System.out.println("                                                                     "
				+ Prizes.FIFTHPRIZE.getValue() + " " + Prizes.FIFTHPRIZE.getValue());
		System.out.println("                                                                     "
				+ Prizes.FIFTHPRIZE.getValue() + " " + Prizes.FIFTHPRIZE.getValue());
	}

}

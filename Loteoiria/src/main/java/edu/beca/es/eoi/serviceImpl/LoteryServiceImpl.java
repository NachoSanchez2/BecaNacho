package edu.beca.es.eoi.serviceImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import edu.beca.es.eoi.Service.LoteryService;
import edu.beca.es.eoi.enums.Prizes;

public class LoteryServiceImpl implements LoteryService {
	private static final Random RANDOM = new Random();
	private static Map<Integer, Integer> SIMULATEDLOTERY = new HashMap<Integer, Integer>();

	@Override
	public Map<Integer, Integer> simulateLotery() {
		// First prize
		Integer firstNumber = RANDOM.nextInt(99999);
		SIMULATEDLOTERY.put(firstNumber, Prizes.FIRSTPRIZE.getValue());

		// Second prize
		Integer secondNumber = randomNumber();
		if (validationNumber(secondNumber)) {
			SIMULATEDLOTERY.put(secondNumber, Prizes.SECONDPRIZE.getValue());
		}

		// Third prize
		Integer thirdNumber = randomNumber();
		if (validationNumber(thirdNumber)) {
			SIMULATEDLOTERY.put(thirdNumber, Prizes.THIRDPRIZE.getValue());
		}

		// Fourth prize
		for (int i = 0; i < 2; i++) {
			Integer fourthNumber = randomNumber();
			if (validationNumber(fourthNumber)) {
				SIMULATEDLOTERY.put(fourthNumber, Prizes.FOURTHPRIZE.getValue());
			}
		}

		// Fiveth prize
		for (int i = 0; i < 8; i++) {
			Integer fifth = randomNumber();
			if (validationNumber(fifth)) {
				SIMULATEDLOTERY.put(fifth, Prizes.FIFTHPRIZE.getValue());
			}
		}

		// Sixth prize
		Integer sixthNumber1 = numberAbove(firstNumber);
		Integer sixthNumber2 = numberBelow(firstNumber);

		if (validationNumber(sixthNumber1)) {
			SIMULATEDLOTERY.put(sixthNumber1, Prizes.SIXTHPRIZE.getValue());
		}
		if (validationNumber(sixthNumber2)) {
			SIMULATEDLOTERY.put(sixthNumber2, Prizes.SIXTHPRIZE.getValue());
		}

		// Seventh prize
		Integer seventhNumber1 = numberAbove(secondNumber);
		Integer seventhNumber2 = numberBelow(secondNumber);
		if (validationNumber(seventhNumber1)) {
			SIMULATEDLOTERY.put(seventhNumber1, Prizes.SEVENTHPRIZE.getValue());
		}
		if (validationNumber(seventhNumber2)) {
			SIMULATEDLOTERY.put(seventhNumber2, Prizes.SEVENTHPRIZE.getValue());
		}

		Integer eighthNumber1 = numberAbove(thirdNumber);
		Integer eighthNumber2 = numberBelow(thirdNumber);

		if (validationNumber(eighthNumber1)) {
			SIMULATEDLOTERY.put(eighthNumber1, Prizes.EIGHTHPRIZE.getValue());
		}
		if (validationNumber(eighthNumber2)) {
			SIMULATEDLOTERY.put(eighthNumber2, Prizes.EIGHTHPRIZE.getValue());
		}

		Set<Integer> ninthAwardNumbers = ninthPrize(firstNumber);
		for (Integer number : ninthAwardNumbers) {
			SIMULATEDLOTERY.put(number, Prizes.NINETHPRIZE.getValue());
		}
		return SIMULATEDLOTERY;
	}

	private Set<Integer> ninthPrize(Integer firstNumber) {
		Set<Integer> ninthAwardNumbers = new HashSet<Integer>();

		Integer randomNumber = randomNumber();

		if (validationDigits(firstNumber, randomNumber) && validationNumber(randomNumber)) {
			ninthAwardNumbers.add(randomNumber);
		}
		return ninthAwardNumbers;
	}

	private boolean validationDigits(Integer firstNumber, Integer randomNumber) {
		String lastDigitRandomNumber = randomNumber.toString().substring(randomNumber.toString().length() - 1);
		String beforeLastDigitRandomNumber = randomNumber.toString().substring(randomNumber.toString().length() - 2);

		String lastDigitFirstNumberAwarded = firstNumber.toString().substring(firstNumber.toString().length() - 1);
		String beforeLastDigitFirstNumberAwarded = firstNumber.toString()
				.substring(firstNumber.toString().length() - 2);
		if (lastDigitRandomNumber.equals(lastDigitFirstNumberAwarded)
				&& beforeLastDigitRandomNumber.equals(beforeLastDigitFirstNumberAwarded)) {
			return true;
		} else {
			return false;
		}
	}

	private Integer numberAbove(Integer number) {
		return SIMULATEDLOTERY.get(number) + 1;
	}

	private Integer numberBelow(Integer number) {
		return SIMULATEDLOTERY.get(number) - 1;
	}

	private Integer randomNumber() {
		return RANDOM.nextInt(99999);
	}

	private boolean validationNumber(Integer number) {
		if (!SIMULATEDLOTERY.containsKey(number)) {
			return true;
		} else {
			return false;
		}

	}
}

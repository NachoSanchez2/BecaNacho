package edu.beca.es.eoi.enums;

public enum Prizes {
	FIRSTPRIZE(4000000), SECONDPRIZE(1250000), THIRDPRIZE(500000), FOURTHPRIZE(200000), FIFTHPRIZE(60000),
	SIXTHPRIZE(20000), SEVENTHPRIZE(12500), EIGHTHPRIZE(9600), NINETHPRIZE(1000);

	private Integer value;

	Prizes(Integer value) {
		this.value = value;
	}
	public Integer getValue() {
		return value;
	}
	protected void setValue(Integer value) {
		this.value = value;
	}
}

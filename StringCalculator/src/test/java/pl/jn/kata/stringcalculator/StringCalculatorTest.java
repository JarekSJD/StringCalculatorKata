package pl.jn.kata.stringcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	private final static String EMPTY = "";
	private final static String ONE_DIGIT = "1";
	private final static String TWO_DIGIT = "1,2";

	@Test
	public void returnZeroIfNull() {
		int result = StringCalculator.add(null);
		assertEquals(0, result);
	}

	@Test
	public void returnZeroIfEmpty() {
		int result = StringCalculator.add(EMPTY);
		assertEquals(0, result);
	}

	@Test
	public void returnResultWithOneDigitAsParam() {
		int result = StringCalculator.add(ONE_DIGIT);
		assertEquals(1, result);
	}

	@Test
	public void returnResultWithTwoDigitAsParam() {
		int result = StringCalculator.add(TWO_DIGIT);
		assertEquals(3, result);
	}

}

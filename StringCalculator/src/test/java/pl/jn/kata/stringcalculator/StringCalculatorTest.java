package pl.jn.kata.stringcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	private final static String EMPTY = "";
	private final static String ONE_DIGIT = "1";
	private final static String TWO_DIGITS = "1,2";
	private final static String UNKNOWN_DIGITS = "1,2,3,4,5,6";
	private final static String DIGITS_WITH_NEXT_LINE_SEPARATOR = "1\n2,3";
	private final static String DIGITS_WITH_NEXT_LINE_SEPARATOR_NOK = "1,\n2";

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
		int result = StringCalculator.add(TWO_DIGITS);
		assertEquals(3, result);
	}
	
	@Test
	public void returnResultWithUnknownDigitAsParam() {
		int result = StringCalculator.add(UNKNOWN_DIGITS);
		assertEquals(21, result);
	}
	
	@Test
	public void returnResultWithNextLineSeparatorDigitsParam() {
		int result = StringCalculator.add(DIGITS_WITH_NEXT_LINE_SEPARATOR);
		assertEquals(6, result);
	}
	
	@Test(expected=NumberFormatException.class)
	public void returnResultWithNextLineSeparatorDigitsNokParam() {
		StringCalculator.add(DIGITS_WITH_NEXT_LINE_SEPARATOR_NOK);
	}

}

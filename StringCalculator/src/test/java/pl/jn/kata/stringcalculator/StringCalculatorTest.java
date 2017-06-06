package pl.jn.kata.stringcalculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StringCalculatorTest {

	private static final String DIFFERENT_MULTI_DELIMITERS = "//[--][**]\n1--2**3";
	private static final String THREE_DIFFERENT_DELIMITERS = "//[-][*][#]\n1-2*3#4";
	private static final String DIFFERENT_DELIMITERS = "//[-][*]\n1-2*3";
	private static final String MULTI_DELIMIERS = "//[---]\n1---2---3";
	private static final String DIGIT_ABOVE_1000 = "1,1002";
	private static final String NEGATIVE_DIGIT = "-1";
	private static final String NEGATIVE_DIGITS = "-1,2,-2";
	private final static String EMPTY = "";
	private final static String ONE_DIGIT = "1";
	private final static String TWO_DIGITS = "1,2";
	private final static String MANY_DIGITS = "1,2,3,4,5,6";
	private final static String DIGITS_WITH_NEXT_LINE_SEPARATOR = "1\n2,3";
	private final static String DIGITS_WITH_NEXT_LINE_SEPARATOR_NOK = "1,\n2";
	private final static String CUSTOM_DELIMETER = "//;\n1;2;3";

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
		int result = StringCalculator.add(MANY_DIGITS);
		assertEquals(21, result);
	}

	@Test
	public void returnResultWithNextLineSeparatorDigitsParam() {
		int result = StringCalculator.add(DIGITS_WITH_NEXT_LINE_SEPARATOR);
		assertEquals(6, result);
	}

	@Test(expected = NumberFormatException.class)
	public void returnResultWithNextLineSeparatorDigitsNokParam() {
		StringCalculator.add(DIGITS_WITH_NEXT_LINE_SEPARATOR_NOK);
	}

	@Test
	public void returnResultWithCustomDelimeter() {
		int result = StringCalculator.add(CUSTOM_DELIMETER);
		assertEquals(6, result);
	}

	@Test
	public void checkNegativeNumber() {
		try {
			StringCalculator.add(NEGATIVE_DIGIT);
			fail();
		} catch (IllegalArgumentException iae) {
			assertThat(iae.getMessage(), is("-1"));
		}
	}

	@Test
	public void checkNegativeNumbers() {
		try {
			StringCalculator.add(NEGATIVE_DIGITS);
			fail();
		} catch (IllegalArgumentException iae) {
			assertThat(iae.getMessage(), is("-1,-2"));
		}
	}

	@Test
	public void returnResultWithDigitsAbove1000() {
		int result = StringCalculator.add(DIGIT_ABOVE_1000);
		assertEquals(1, result);
	}

	@Test
	public void returnResultWithMultiDelimeters() {
		assertThat(StringCalculator.add(MULTI_DELIMIERS), is(6));
	}

	@Test
	public void returnResultWithDifferentsDelimeters() {
		assertThat(StringCalculator.add(DIFFERENT_DELIMITERS), is(6));
	}

	@Test
	public void returnResultWith3DifferentsDelimeters() {
		assertThat(StringCalculator.add(THREE_DIFFERENT_DELIMITERS), is(10));
	}
	
	@Test
	public void returnResultWithDifferentsMultiDelimeters() {
		assertThat(StringCalculator.add(DIFFERENT_MULTI_DELIMITERS), is(6));
	}
}

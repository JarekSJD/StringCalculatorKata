package pl.jn.kata.stringcalculator;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

public class StringCalculator {

	private static final String DEFAULT_DELIMIETER = ",|\n";
	private static final int ZERO = 0;

	private StringCalculator() {
	}

	public static int add(String numbers) {
		if (Strings.isNullOrEmpty(numbers)) {
			return ZERO;
		}

		List<String> numberList = Lists.newArrayList(numbersToSplit(numbers).split(delimeter(numbers)));
		return resultAfterParse(numberList);
	}

	private static String numbersToSplit(String numbers) {
		if (numbers.startsWith("//")) {
			return numbers.substring(3);
		}
		return numbers;
	}

	private static String delimeter(String numbers) {
		if (numbers.startsWith("//")) {
			return numbers.substring(2, 3);
		}
		return DEFAULT_DELIMIETER;
	}

	private static Integer resultAfterParse(List<String> numberList) {
		return numberList.stream().map(x -> parseInt(x)).collect(Collectors.summingInt(x -> x));
	}

	private static Integer parseInt(String s) {
		try {
			return Integer.parseInt(s.trim());
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("This value is not supported: " + s);
		}
	}

}

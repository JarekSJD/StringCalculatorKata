package pl.jn.kata.stringcalculator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

public class StringCalculator {

	private static final String DESC_OF_DELIMIETER = "//";
	private static final String COMMA = ",";
	private static final String DEFAULT_DELIMIETER = ",|\n";
	private static final int ZERO = 0;

	private static List<String> numberList;
	
	private StringCalculator() {
	}

	public static int add(String numbers) {
		if (Strings.isNullOrEmpty(numbers)) {
			return ZERO;
		}

		numberList = Lists.newArrayList(numbersToSplit(numbers).split(delimeter(numbers)));
		areNegativeNumbers();
		return resultAfterParse();
	}

	private static String numbersToSplit(String numbers) {
		if (numbers.startsWith(DESC_OF_DELIMIETER)) {
			return numbers.split("\n", 2)[1];
		}
		return numbers;
	}

	private static String delimeter(String numbers) {
		if (numbers.startsWith(DESC_OF_DELIMIETER)) {
			String[] numbersParts = numbers.split("\n", 2);
			String headerDelimieter = numbersParts[0].substring(2);

			if (headerDelimieter.startsWith("[")) {
				headerDelimieter = headerDelimieter.substring(1, headerDelimieter.length() - 1);
			}

			return Stream.of(headerDelimieter.split("]\\[")).map(Pattern::quote).collect(Collectors.joining("|"));
		}
		return DEFAULT_DELIMIETER;
	}
	
	private static void areNegativeNumbers() {
		 String negativeMessage = getNumberList()
			.filter(x-> x < 0)
			.mapToObj(Integer::toString)
			.collect(Collectors.joining(COMMA));
		if (!negativeMessage.isEmpty()) {
			throw new IllegalArgumentException(negativeMessage);
		}
		
	}

	private static Integer resultAfterParse() {
		return getNumberList().sum();
	}

	private static IntStream getNumberList() {
		return numberList.stream()
				.mapToInt(x -> parseInt(x))
				.filter(x -> x <= 1000);
	}

	private static Integer parseInt(String s) {
		try {
			return Integer.parseInt(s.trim());
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("This value is not supported: " + s);
		}
	}

}

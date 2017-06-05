package pl.jn.kata.stringcalculator;

import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

public class StringCalculator {

	private static final String SEPARATOR = ",";
	private static final int ZERO = 0;

	private StringCalculator() {
	}

	public static int add(String numbers) {
		int result = 0;
		if (Strings.isNullOrEmpty(numbers)) {
			return ZERO;
		}
		List<String> numberList = Lists.newArrayList(numbers.split(SEPARATOR));
		result = numberList.stream().mapToInt(Integer::parseInt).sum();
		return result;
	}
}

package be.ccfun.aoc.day08;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Numbers {

	private Map<Integer, String> patterns = new HashMap<>();

	public Numbers(List<String> configure) {
		patterns.put(1, getValue(configure,2));
		patterns.put(4, getValue(configure,4));
		patterns.put(7, getValue(configure,3));
		patterns.put(8, getValue(configure,7));
		List<String> digits6 = getAllValues(configure, 6);
		for (String with6 : digits6) {
			if (!containsAllLetters(with6, patterns.get(7))) {
				patterns.put(6, with6);

			}
		}
		digits6.remove(patterns.get(6));
		patterns.put(3, getValue(configure,5, patterns.get(1)));
		List<String> allValues = getAllValues(configure,5);
		allValues.remove(patterns.get(3));
		for (String pat : allValues) {
			if (common(pat, patterns.get(6)) == 5) {
				patterns.put(5, pat);
			} else {
				patterns.put(2, pat);
			}
		}
		for (String with6: digits6) {
			if (common(with6, patterns.get(5)) == 5) {
				patterns.put(9, with6);
			} else {
				patterns.put(0, with6);
			}
		}
	}

	public int translate(String pattern) {
		return patterns.entrySet().stream()
				.filter(entry -> entry.getValue().length() == pattern.length())
				.filter(entry -> common(entry.getValue(), pattern) == pattern.length()).mapToInt(entry -> entry.getKey()).findFirst().getAsInt();
	}

	private String getValue(List<String> configure, int length) {
		return configure.stream().filter(s -> s.length() == length).findAny().get();
	}

	private List<String> getAllValues(List<String> configure, int length) {
		return configure.stream().filter(s -> s.length() == length).collect(Collectors.toList());
	}

	private String getValue(List<String> configure, int length, String containing) {
		return configure.stream().filter(s -> s.length() == length && containsAllLetters(s, containing)).collect(Collectors.toList()).stream().findAny().get();
	}

	public boolean containsAllLetters(String text, String letters) {
		for (int i = 0; i < letters.length(); i++) {
			if (!text.contains(letters.substring(i, i+1))) {
				return false;
			}
		}
		return true;
	}

	public int common(String text, String other) {
		int common = 0;
		for (int i = 0; i < text.length(); i++) {
			if (other.contains(text.substring(i, i+1))) {
				common++;
			}
		}
		return common;
	}


}

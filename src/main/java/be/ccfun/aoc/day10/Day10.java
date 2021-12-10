package be.ccfun.aoc.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Day10 {
	private static final List<String> closing = Arrays.asList("}", ")", "]", ">");

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day10.txt"));
		long totalError= 0;
		List<Long> completeError = new ArrayList<>();
		for (String line : lines) {
			long valid = isValid(line);
			if (valid > 0) {
				totalError += valid;
				System.out.println(line + " " + valid);
			} else if(valid < 0) {
				System.out.println("CS" + valid);
				completeError.add(-1 * valid);
			}
		}
		System.out.println(totalError);
		List<Long> collect = completeError.stream().sorted().collect(Collectors.toList());
		int middle = collect.size() / 2;
		System.out.println(collect.get(middle));

	}

	public static long isValid(String p) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < p.length(); i++) {
			String charAt = p.substring(i, i+1);
			if (closing.contains(charAt)) {
				String pop = stack.pop();
				if (!isMatch(pop, charAt)) {
					System.out.println("expected " + pop + " found " + charAt);
					return getSyntaxError(charAt);
				}
			} else {
				stack.push(charAt);
			}
		}
		if (!stack.isEmpty()) {
			System.out.println("COMPLETE: " + stack);
			return -1 * countCompleteScore(stack);
		}
		return 0;
	}

	public static long countCompleteScore(Stack<String> s) {
		long score = 0;
		while (!s.isEmpty()) {
			String pop = s.pop();
			score = 5 * score + getCompleteScore(pop);
		}
		return score;
	}

	public static int getCompleteScore(String x) {
		return switch (x) {
			case "(" -> 1;
			case "<" -> 4;
			case "{" -> 3;
			default -> 2;
		};
	}

	public static int getSyntaxError(String x) {
		return switch (x) {
			case ")" -> 3;
			case ">" -> 25137;
			case "}" -> 1197;
			default -> 57;
		};
	}

	public static boolean isMatch(String x, String y) {
		return switch (x) {
			case "(" -> y.equals(")");
			case "<" -> y.equals(">");
			case "{" -> y.equals("}");
			default -> y.equals("]");
		};
	}
}

package be.ccfun.aoc.day14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.stream.Stream;

public class Day14 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day14.txt"));
		String pattern = lines.get(0);
		Map<String, String> sub = new HashMap<>();
		for (int i =2; i< lines.size(); i++) {
			String[] split = lines.get(i).split("->");
			sub.put(split[0].trim(), split[1].trim());
		}
		for (int d = 0; d < 40; d++) {
			StringBuilder newPattern = new StringBuilder();
			for (int i = 0; i < pattern.length() - 1; i+=1) {
				String part = pattern.substring(i, i + 2);
				String subst = sub.get(part);
				if (subst != null) {
					newPattern.append(part.charAt(0)).append(subst);
				} else {
					newPattern.append(part);
				}
			}
			newPattern.append(pattern.charAt(pattern.length()-1));
			//System.out.println(newPattern.toString());
			pattern = newPattern.toString();
		}
		Map<String, Integer> count = count(pattern);
		long max = count.values().stream().mapToLong(x -> x).max().getAsLong();
		System.out.println(max);
		long min = count.values().stream().mapToLong(x -> x).min().getAsLong();
		System.out.println(min);
		System.out.println(max - min);
	}

	public static Map<String, Integer> count(String s) {
		Map<String, Integer> counts = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (counts.get(s.substring(i, i+1)) == null) {
				counts.put(s.substring(i, i+1), 1);
			} else {
				counts.put(s.substring(i, i+1), counts.get(s.substring(i, i+1)) + 1);
			}
		}
		return counts;
	}
}

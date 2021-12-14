package be.ccfun.aoc.day14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14P2 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day14.txt"));
		String pattern = lines.get(0);
		Map<String, String> sub = new HashMap<>();
		Map<String, Long> patocc = new HashMap<>();
		for (int i =2; i< lines.size(); i++) {
			String[] split = lines.get(i).split("->");
			sub.put(split[0].trim(), split[1].trim());
		}
		for (int i = 0; i < pattern.length() - 1; i+=1) {
			String substring = pattern.substring(i, i + 2);
			if (patocc.containsKey(substring)) {
				patocc.put(substring, patocc.get(substring) + 1);
			} else {
				patocc.put(substring, 1L);
			}
		}
		Map<String, Long> lettercount = count(pattern);
		for (int d = 0; d < 40; d++) {
			Map<String, Long> nextMap = new HashMap<>();
			for (String key: patocc.keySet()) {
				String newLetter = sub.get(key);
				if (lettercount.containsKey(newLetter)) {
					lettercount.put(newLetter, lettercount.get(newLetter) + patocc.get(key));
				} else {
					lettercount.put(newLetter, patocc.get(key));
				}
				String s1 = key.charAt(0) + newLetter;
				if (nextMap.containsKey(s1)) {
					nextMap.put(s1, nextMap.get(s1) + patocc.get(key));
				} else {
					nextMap.put(s1, patocc.get(key));
				}
				s1 = newLetter + key.charAt(1);
				if (nextMap.containsKey(s1)) {
					nextMap.put(s1, nextMap.get(s1) + patocc.get(key));
				} else {
					nextMap.put(s1, patocc.get(key));
				}
			}
			patocc = new HashMap<>(nextMap);
		}
		long max = lettercount.values().stream().mapToLong(x -> x).max().getAsLong();
		System.out.println(max);
		long min = lettercount.values().stream().mapToLong(x -> x).min().getAsLong();
		System.out.println(min);
		System.out.println(max - min);
	}

	public static Map<String, Long> count(String s) {
		Map<String, Long> counts = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (counts.get(s.substring(i, i+1)) == null) {
				counts.put(s.substring(i, i+1), 1L);
			} else {
				counts.put(s.substring(i, i+1), counts.get(s.substring(i, i+1)) + 1);
			}
		}
		return counts;
	}
}

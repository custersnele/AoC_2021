package be.ccfun.aoc.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

	public static void main(String[] args) throws IOException {
		List<Integer> lines = Files.readAllLines(Path.of("src/main/resources/day1.txt")).stream().map(Integer::parseInt).collect(Collectors.toList());
		long increases = 0;
		for (int i = 0 ; i < lines.size() - 1; i++) {
			if (lines.get(i) < lines.get(i+1)) {
				increases++;
			}
		}
		System.out.println(increases);
		increases = 0;
		lines = Files.readAllLines(Path.of("src/main/resources/day1.txt")).stream().map(Integer::parseInt).collect(Collectors.toList());
		for (int i = 0; i < lines.size() - 3; i++) {
			int sum1 = lines.get(i) + lines.get(i+1) + lines.get(i+2);
			int sum2 = lines.get(i+1) + lines.get(i+2) + lines.get(i+3);
			if (sum1 < sum2) {
				increases++;
			}
		}
		System.out.println(increases);
	}
}

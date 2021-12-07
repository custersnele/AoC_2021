package be.ccfun.aoc.day07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Day7 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day7.txt"));
		String[] split = lines.get(0).split(",");
		List<Integer> result = Arrays.stream(lines.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
		int mean = Arrays.stream(split).mapToInt(Integer::parseInt).sorted().skip(split.length / 2).findFirst().getAsInt();
		System.out.println(mean);
		int sum = result.stream().mapToInt(x -> Math.abs(x - mean)).sum();
		System.out.println(sum);



	}

}

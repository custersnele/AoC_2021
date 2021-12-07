package be.ccfun.aoc.day07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day7P2 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day7.txt"));
		String[] split = lines.get(0).split(",");
		List<Integer> result = Arrays.stream(lines.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
		int average = (int) Math.round(Arrays.stream(split).mapToInt(Integer::parseInt).average().getAsDouble());
		System.out.println(average);
		long minSum = Long.MAX_VALUE;
		for (int avg = average - 20; avg < average + 20; avg++) {
			int finalAvg = avg;
			long sum = result.stream().mapToInt(x -> Math.abs(x - finalAvg))
					.mapToLong(x -> IntStream.range(1, x + 1).sum())
					//.peek(System.out::println)
					.sum();
			if (sum < minSum) {
				System.out.println("average: " + avg);
				System.out.println("sum: " + sum);
				minSum = sum;
			}
		}
	}


}

package be.ccfun.aoc.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day8P2 {

	public static void main(String[] args) throws IOException {
		Numbers numbers = new Numbers(Arrays.stream("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab".split(" ")).toList());
		System.out.println(numbers.translate("cdfeb"));
		System.out.println(numbers.translate("fcadb"));
		System.out.println(numbers.translate("cdfeb"));
		System.out.println(numbers.translate("cdbaf"));

		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day8.txt"));
		long sum = 0;
		for (String line : lines) {
			String[] split = line.split("\\|");
			numbers = new Numbers(Arrays.stream(split[0].trim().split(" ")).toList());
			StringBuilder builder = new StringBuilder();
			for (String digit : split[1].trim().split(" ")) {
				int translate = numbers.translate(digit);
				builder.append(translate);

			}
			sum += Integer.parseInt(builder.toString());
		}
		System.out.println(sum);
	}

}

package be.ccfun.aoc.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day8 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day8.txt"));
		lines = lines.stream().map(l -> l.split("\\|")[1].trim()).collect(Collectors.toList());
		List<Integer> values = Arrays.asList(2,3,4,7);
		long count = lines.stream().flatMap((s -> Arrays.stream(s.split(" "))))
				.filter(s -> values.contains(s.length())).count();
		System.out.println(count);
	}

}

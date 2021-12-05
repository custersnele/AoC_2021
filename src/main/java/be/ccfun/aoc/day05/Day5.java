package be.ccfun.aoc.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5 {

	public static void main(String[] args) throws IOException {
		List<Point> allPoints = new ArrayList<>();
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day5.txt"));
		for (String line : lines) {
			 String[] split = line.split("->");
			 String[] part1 = split[0].split(",");
			 String[] part2 = split[1].split(",");
			 try {
				 Line vent = new Line(Integer.parseInt(part1[0].trim()), Integer.parseInt(part1[1].trim()), Integer.parseInt(part2[0].trim()), Integer.parseInt(part2[1].trim()));
				 System.out.println(vent.allPoints());
				 allPoints.addAll(vent.allPoints());
			 } catch (IllegalArgumentException e) {
				// ignore
			 }
		}
		System.out.println("Lines read - calculating occurences...");
		Map<Point, Integer> occurences = new HashMap<>();
		allPoints.stream().distinct().forEach(p -> occurences.put(p, Collections.frequency(allPoints, p)));
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				Integer val = occurences.get(new Point(x, y));
				if (val == null) {
					System.out.print(".");
				} else {
					System.out.print(val);
				}
			}
			System.out.println();
		}
		System.out.println(occurences.values().stream().filter(v -> v > 1).count());


	}

}

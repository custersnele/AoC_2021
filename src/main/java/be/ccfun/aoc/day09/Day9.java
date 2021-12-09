package be.ccfun.aoc.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day9 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day9.txt"));
		int totalRisk = 0;
		for (int y = 0; y < lines.size(); y++) {
			for (int x = 0; x < lines.get(0).length(); x++) {
				int currentHeight = Integer.parseInt(lines.get(y).substring(x, x+1));
				List<Integer> surroundingHeights = getSurroundingHeights(lines, x, y);
				long count = surroundingHeights.stream().filter(s -> s <= currentHeight).count();
				if (count == 0) {
					//System.out.println("Found: " + currentHeight);
					//System.out.println("Risk: " + (currentHeight + 1));
					totalRisk += (currentHeight + 1);
				}
			}

		}
		System.out.println(totalRisk);

	}

	public static List<Integer> getSurroundingHeights(List<String> lines, int x, int y) {

		List<Integer> surrounding = new ArrayList<>();
		if (y - 1 >= 0) {
			surrounding.add(Integer.parseInt(lines.get(y-1).substring(x, x+1)));
		}
		if (y + 1 < lines.size()) {
			surrounding.add(Integer.parseInt(lines.get(y+1).substring(x, x+1)));
		}
		if (x + 1 < lines.get(0).length()) {
			surrounding.add(Integer.parseInt(lines.get(y).substring(x+1, x+2)));
		}
		if (x - 1 >= 0) {
			surrounding.add(Integer.parseInt(lines.get(y).substring(x-1, x)));
		}
		return surrounding;
	}

}

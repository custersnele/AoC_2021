package be.ccfun.aoc.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Day9P2 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day9.txt"));
		int totalRisk = 0;
		List<Point> lowPoints = new ArrayList<>();
		for (int y = 0; y < lines.size(); y++) {
			for (int x = 0; x < lines.get(0).length(); x++) {
				int currentHeight = Integer.parseInt(lines.get(y).substring(x, x+1));
				List<Integer> surroundingHeights = getSurroundingHeights(lines, x, y);
				long count = surroundingHeights.stream().filter(s -> s <= currentHeight).count();
				if (count == 0) {
					//System.out.println("Found: " + currentHeight);
					//System.out.println("Risk: " + (currentHeight + 1));
					lowPoints.add(new Point(x, y, currentHeight));
					totalRisk += (currentHeight + 1);
				}
			}
		}
		List<Integer> sizes = new ArrayList<>();
		for (Point lowPoint : lowPoints) {
			List<Point> surrounding = surrounding = new ArrayList<>();
			surrounding.add(lowPoint);
			getSurrounding(lines, lowPoint, surrounding);
			int size = surrounding.size();
			System.out.println("Basin: " + size);
			sizes.add(size);
		}
		System.out.println(totalRisk);
		int result = sizes.stream().sorted((x, y) -> y - x).mapToInt(x -> x).limit(3).reduce(1, (v, acc) -> acc * v);
		System.out.println(result);
	}

	public static void getSurrounding(List<String> lines, Point point, List<Point> surrounding) {
		int x = point.getX();
		int y = point.getY();
 		if (y - 1 >= 0) {
		    int height = Integer.parseInt(lines.get(y - 1).substring(x, x + 1));
			if (height != 9) {
				Point newPoint = new Point(x, y - 1, height);
				if (!surrounding.contains(newPoint)) {
					surrounding.add(newPoint);
					getSurrounding(lines, newPoint, surrounding);
				}
			}
		}
		if (y + 1 < lines.size()) {
			int height = Integer.parseInt(lines.get(y + 1).substring(x, x + 1));
			if (height != 9) {
				Point newPoint = new Point(x, y + 1, height);
				if (!surrounding.contains(newPoint)) {
					surrounding.add(newPoint);
					getSurrounding(lines, newPoint, surrounding);
				}
			}
		}
		if (x + 1 < lines.get(0).length()) {
			int height = Integer.parseInt(lines.get(y).substring(x + 1, x + 2));
			if (height != 9) {
				Point newPoint = new Point(x + 1, y , height);
				if (!surrounding.contains(newPoint)) {
					surrounding.add(newPoint);
					getSurrounding(lines, newPoint, surrounding);
				}
			}
		}
		if (x - 1 >= 0) {
			int height = Integer.parseInt(lines.get(y).substring(x - 1, x));
			if (height != 9) {
				Point newPoint = new Point(x - 1, y , height);
				if (!surrounding.contains(newPoint)) {
					surrounding.add(newPoint);
					getSurrounding(lines, newPoint, surrounding);
				}
			}
		}
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

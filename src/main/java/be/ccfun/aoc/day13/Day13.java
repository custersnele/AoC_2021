package be.ccfun.aoc.day13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day13 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day13.txt"));
		List<Point> points = new ArrayList<>();
		List<String> foldInstructions = new ArrayList<>();
		for (String line : lines) {
			if (line.contains(",")) {
				String[] split = line.split(",");
				points.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
			} else if (line.contains("fold")) {
				foldInstructions.add(line);
			}
		}
		System.out.println("Folding:");
		for (String foldInstruction : foldInstructions) {
			int fold = Integer.parseInt(foldInstruction.split("=")[1]);
			if (foldInstruction.contains("x=")) {
				points.stream().forEach(p -> p.foldX(fold));
			} else {
				points.stream().forEach(p -> p.foldY(fold));
			}
			long count = points.stream().distinct().count();
			System.out.println(count);
		}
		print(points);
	}

	public static void print(List<Point> points) {
		int maxX = points.stream().mapToInt(p -> p.getX()).max().getAsInt();
		int maxY = points.stream().mapToInt(p -> p.getY()).max().getAsInt();
		for (int y = 0; y <= maxY; y++) {
			for (int x = 0; x <= maxX; x++) {
				int finalX = x;
				int finalY = y;
				if (points.stream().anyMatch(p -> p.getX()== finalX && p.getY() == finalY)) {
						System.out.print("#");
					} else {
						System.out.print(".");
					}
			}
			System.out.println();
		}
		System.out.println();
	}

}

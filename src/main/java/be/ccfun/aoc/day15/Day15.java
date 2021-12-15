package be.ccfun.aoc.day15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day15 {

	private static List<String> lines = null;

	public static void main(String[] args) throws IOException {
		lines = Files.readAllLines(Path.of("src/main/resources/day15.txt"));
		int destX = lines.get(0).length() - 1;
		int destY = lines.size() - 1;
		int curX = 0;
		int curY = 0;
		System.out.println(findOpt(curX, curY, destX, destY));
	}

	public static int findOpt(int x, int y, int destX, int destY) {
		//System.out.println(x + ", " + y);
		if (x == destX && y == destY) {
			return Integer.parseInt(lines.get(y).substring(x, x + 1));
		}
		if (x == destX) {
			StringBuilder builder = new StringBuilder();
			for (int i = y; i <= destY; i++) {
				builder.append(lines.get(i).substring(x, x + 1));
			}
			return sum(builder.toString());
		}
		if (y == destY) {
			return sum(lines.get(y).substring(x, destX+1));
		}
		int risk = Integer.parseInt(lines.get(y).substring(x, x + 1));
		return risk + Math.min(findOpt(x + 1, y, destX, destY), findOpt(x, y + 1, destX, destY));
	}

	public static int sum(String line) {
		int sum = 0;
		for (int i = 0; i < line.length(); i++) {
			sum += Integer.parseInt(line.substring(i, i+ 1));
		}
		return sum;
	}

}
